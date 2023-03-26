import jade.core.*;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerAgent extends Agent {

    public static HashMap<Integer, Integer> map = new HashMap<>();

    private HashSet<Order> currentMenu;

    public static Queue<Order> orders = new ArrayDeque<>();

    private String currentCustomerName;

    private final Logger logger = LoggerManager.createLogger(this.getClass().getName());

    protected void setup() {
        System.out.println("Manager agent " + getAID().getLocalName() + " is ready");
        addBehaviour(new GetOrder());
    }

    @Override
    protected void takeDown() {
        System.out.println("Manager agent " +getAID().getLocalName() + " is shutting down");
        JsonManager.writeLog(new JsonAction(
                "Deletion",
                getLocalName(),
                getClass().getName(),
                "",
                "Manager agent " + getLocalName() + " shut down"));
        super.takeDown();
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
            JsonManager.writeLog(new JsonAction(
                    "Initialization",
                    name,
                    className,
                    "",
                    name + " initialized"));
            return new AID(name, false);
        } catch (StaleProxyException e) {
            String entity = name + ":" + className;
            logger.log(Level.SEVERE, "unable to start agent " + entity);
            e.printStackTrace();
            JsonManager.writeFatalError(new JsonException("StaleProxyException", "unable to start agent " + entity));
        }
        return null;
    }

    public HashSet<Order> getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(HashSet<Order> currentMenu) {
        this.currentMenu = currentMenu;
    }

    public String getCurrentCustomerName() {
        return currentCustomerName;
    }

    public void setCurrentCustomerName(String currentCustomerName) {
        this.currentCustomerName = currentCustomerName;
    }
}
