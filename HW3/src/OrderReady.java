import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.ContainerController;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.ContainerController;

public class Ready extends OneShotBehaviour {
    @Override
    public void action() {
        System.out.println(myAgent.getLocalName() + " send message to " + ((OrderAgent)myAgent).getCustomerName());
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID(((OrderAgent)myAgent).getCustomerName(), AID.ISLOCALNAME));
        try {
            var orderMessage = new OrderMessage(
                    myAgent.getLocalName(),
                    ((OrderAgent)myAgent).getMenu(),
                    ((OrderAgent)myAgent).getCellId());
            CustomerOntology customerOntology = CustomerOntology.getInstance();
            msg.setContentObject(orderMessage);
            msg.setOntology(customerOntology.getName());
            myAgent.send(msg);
            ContainerController containerController = myAgent.getContainerController();
            myAgent.doDelete();
            containerController.kill();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
