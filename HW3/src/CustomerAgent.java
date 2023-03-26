import jade.core.Agent;

import java.util.HashSet;

public class CustomerAgent extends Agent {

    HashSet<Order> menu;
    protected void setup() {
        Object[] args = getArguments();
        menu = (HashSet<Order>) args[0];
        System.out.println("Customer agent" + getAID().getLocalName() + "is ready.");
        addBehaviour(new MakeOrder());
        addBehaviour(new GetFood());
    }

    @Override
    protected void takeDown() {
        System.out.println("Customer agent" + getAID().getLocalName() + " is shutting down");
        JsonManager.writeLog(new JsonAction(
                "Deletion",
                getLocalName(),
                getClass().getName(),
                "",
                "Customer agent " + getLocalName() + " shut down"));
        super.takeDown();
    }
}
