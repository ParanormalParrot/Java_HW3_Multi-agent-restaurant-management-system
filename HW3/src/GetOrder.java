
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class GetOrder extends Behaviour {

    @Override
    public void action() {
        ACLMessage msg = myAgent.receive();
        if (msg != null) {
            try {
                OrderMessage messageFromOrder = (OrderMessage) msg.getContentObject();
                System.out.println("Received " + messageFromOrder.getLocalName() +
                        " in cell " + messageFromOrder.getCellId() +
                        ": " + messageFromOrder.getMenu());
                JsonManager.writeLog(new JsonAction(
                        "Action",
                        myAgent.getLocalName(),
                        getClass().getName(),
                        messageFromOrder.getMenu().toString(),
                        "Received " + messageFromOrder.getLocalName()));
                ContainerController containerController = myAgent.getContainerController();
                myAgent.doDelete();
                containerController.kill();
            } catch (UnreadableException | StaleProxyException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
