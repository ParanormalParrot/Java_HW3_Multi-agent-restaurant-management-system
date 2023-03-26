import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class PrepareOrder extends Behaviour {
    @Override
    public void action() {
        ACLMessage aclMessage = myAgent.receive();
        if (aclMessage != null) {
            try {
                Message message = (Message) aclMessage.getContentObject();
                System.out.println("Received " + message.getLocalName());
                JsonManager.writeLog(new JsonAction(
                        "Action",
                        myAgent.getLocalName(),
                        getClass().getName(),
                        "Order is ready",
                        "Received " + message.getLocalName()));
                myAgent.addBehaviour(new OrderReady());
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
