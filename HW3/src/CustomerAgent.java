import jade.core.Agent;

import java.util.HashSet;

public class CustomerAgent extends Agent {

    HashSet<Order> menu;
    protected void setup() {
        Object[] args = getArguments();
        menu = (HashSet<Order>) args[0];
        System.out.println("Hello from " + getAID().getLocalName() + " agent, now it's ready to go!");
        addBehaviour(new MakeOrder());
        addBehaviour(new GetFood());
    }

    @Override
    protected void takeDown() {
        System.out.println(getAID().getLocalName() + " is shutting down");
        JSONManager.writeLog(new JSONAction(
                "Deletion",
                getLocalName(),
                getClass().getName(),
                "",
                getLocalName() + " shut down"));
        super.takeDown();
    }
}
