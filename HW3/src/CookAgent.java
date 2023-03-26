import jade.core.Agent;

public class CookAgent extends Agent {

    protected void setup() {
        System.out.println("Cook agent " + getAID().getLocalName() + " is ready.");
        addBehaviour(new PrepareDish());
    }

    @Override
    protected void takeDown() {
        System.out.println("Cook agent " + getAID().getLocalName() + " is shutting down");
        JsonManager.writeLog(new JsonAction(
                "Deletion",
                getLocalName(),
                getClass().getName(),
                "",
                "Cook agent " + getLocalName() + " shut down"));
        super.takeDown();
    }
}
