import jade.core.Agent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller extends Agent {

    private final Logger logger = LoggerManager.createLogger("Java_HW3/logs/" + this.getClass().getName());

    public Menu menu;
    public static RecipeBook recipes;
    public static IngredientTypeList ingredientTypes;
    public Stock storage;
    public EquipmentTypeList equipmentTypes;
    public EquipmentList equipment;
    public CookList cooks;
    public OperationTypeList operationTypes;
    public CustomerQueue customers;

    protected void setup() {
        System.out.println("Hello from " + getAID().getLocalName() + " agent, now it's ready to go!");
        readData();
        addBehaviour(new CreateCustomer(this, 3000));
        addBehaviour(new CreateManager());
    }

    private void readData() {
        menu = new Menu(new HashSet<>(JsonManager.readFromFile("resources/menu_items.txt", Menu.class)
                .getMenu()));
        recipes = new RecipeBook(new HashSet<>(JsonManager.readFromFile("resources/recipes.txt", RecipeBook.class)
                .getRecipes()));
        ingredientTypes = new IngredientTypeList(new HashSet<>(JsonManager.readFromFile("resources/ingredient_types.txt", IngredientTypeList.class)
                .getIngredientTypes()));
        storage = new Stock(new HashSet<>(JsonManager.readFromFile("resources/products.txt", Stock.class)
                .getStorage()));
        equipmentTypes = new EquipmentTypeList(new HashSet<>(JsonManager.readFromFile("resources/equipment_types.txt", EquipmentTypeList.class)
                .getEquipmentTypes()));
        equipment = new EquipmentList(new HashSet<>(JsonManager.readFromFile("resources/equipment.txt", EquipmentList.class)
                .getEquipment()));
        cooks = new CookList(new HashSet<>(JsonManager.readFromFile("resources/cooks.txt", CookList.class)
                .getCooks()));
        operationTypes = new OperationTypeList(new HashSet<>(JsonManager.readFromFile("resources/operation_types.txt", OperationTypeList.class)
                .getOperationTypes()));
        customers = new CustomerQueue(new ArrayList<>(JsonManager.readFromFile("resources/customers.txt", CustomerQueue.class)
                .getCustomers()));

//        List<AID> cookAgents = this.cookers.values()
//                .stream()
//                .map(cook -> spawnActor(cook.getName(), "agents.cook.CookAgent", "Cooker", new Object[]{cook}))
//                .collect(Collectors.toList());
//        logger.log(Level.INFO, cookAgents.toString());
    }

    public AID addAgent(String name, String className, String containerName, Object[] args) {
        Runtime runtime = Runtime.instance();
        Profile profile = new ProfileImpl();
        profile.setParameter(Profile.CONTAINER_NAME, containerName);
        profile.setParameter(Profile.MAIN_HOST, "localhost");
        ContainerController container = runtime.createAgentContainer(profile);
        try {
            AgentController agent = container.createNewAgent(name, className, args);
            agent.start();
            logger.log(Level.INFO, name);
            JsonManager.writeLog(new JsonAction(
                    "Initialization",
                    name,
                    className,
                    "",
                    name + " initialized"));
            return new AID(name, false);
        } catch (StaleProxyException e) {
            String entity = name + ":" + className;
            logger.log(Level.SEVERE, "Unable to start agent " + entity);
            e.printStackTrace();
            JsonManager.writeFatalError(new JsonException("StaleProxyException", "Unable to start agent " + entity));
        }
        return null;
    }

    public void addAgent(String name, String agent) {
        CreateAgent ca = new CreateAgent();
        ca.setAgentName(name);
        ca.setClassName(agent);
        ca.setContainer(new ContainerID("Main-Container", null));
        Action actExpr = new Action(getAMS(), ca);
        ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
        request.addReceiver(getAMS());
        request.setOntology(JADEManagementOntology.getInstance().getName());

        getContentManager().registerLanguage(new SLCodec(),
                FIPANames.ContentLanguage.FIPA_SL);

        getContentManager().registerOntology(JADEManagementOntology.getInstance());

        request.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        request.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
        try {
            getContentManager().fillContent(request, actExpr);
            addBehaviour(new AchieveREInitiator(this, request) {
                protected void handleInform(ACLMessage inform) {
                    logger.log(Level.INFO, agent);
                    JsonManager.writeLog(new JsonAction(
                            "Initialization",
                            name,
                            agent,
                            "",
                            name + " initialized"
                    ));
                }

                protected void handleFailure(ACLMessage failure) {
                    System.out.println("Exception occurred while creating agent");
                    JsonManager.writeException(new JsonException("OntologyException",
                            "Exception occurred while creating agent"));
                }
            });
        } catch (OntologyException | Codec.CodecException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void takeDown() {
        JsonManager.writeLog(new JsonAction(
                "Deletion",
                getLocalName(),
                getClass().getName(),
                "",
                getLocalName() + " shut down"));
        super.takeDown();
    }
}