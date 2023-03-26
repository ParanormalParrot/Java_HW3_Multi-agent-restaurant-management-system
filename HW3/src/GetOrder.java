
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class GetOrder extends Behaviour {
    @Override
    public void action() {
        ACLMessage msg = myAgent.receive();
        if (msg != null) {
            try {
                CustomerMessage customerMessage = (CustomerMessage) msg.getContentObject();
                System.out.println("Order by " + customerMessage.getLocalName() + ": " + customerMessage.getMenu());
                JsonManager.writeLog(new JsonAction(
                        "Action",
                        myAgent.getLocalName(),
                        getClass().getName(),
                        customerMessage.getMenu().toString(),
                        "Received order from " + customerMessage.getLocalName()));
                ((ManagerAgent)myAgent).setCurrentMenu(customerMessage.getMenu());
                ((ManagerAgent)myAgent).setCurrentCustomerName(customerMessage.getLocalName());
                ManagerAgent.orders.addAll(customerMessage.getMenu());
                myAgent.addBehaviour(new OrderCreator(customerMessage.getMenu()));
            } catch (UnreadableException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
