import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class MakeOrder extends OneShotBehaviour {
    @Override
    public void action() {
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        message.addReceiver(new AID("Manager", AID.ISLOCALNAME));
        try {
            var customerMessage = new CustomerMessage(myAgent.getLocalName(), ((CustomerAgent) myAgent).menu);
            message.setContentObject(customerMessage);
            myAgent.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}