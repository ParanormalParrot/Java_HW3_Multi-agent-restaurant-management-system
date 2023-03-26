import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.ContainerController;

public class OrderReady extends OneShotBehaviour {
    @Override
    public void action() {
        myAgent.doWait(4000);
        System.out.println(myAgent.getLocalName() + " send message to " + ((OrderAgent)myAgent).getCustomerName());
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        message.addReceiver(new AID(((OrderAgent)myAgent).getCustomerName(), AID.ISLOCALNAME));
        try {
            var messageFromOrder = new OrderMessage(
                    myAgent.getLocalName(),
                    ((OrderAgent)myAgent).getMenu(),
                    ((OrderAgent)myAgent).getCellId());
            message.setContentObject(messageFromOrder);
            myAgent.send(message);
            ContainerController containerController = myAgent.getContainerController();
            myAgent.doDelete();
            containerController.kill();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}