import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

import java.util.Objects;

public class GetFood extends Behaviour {

    @Override
    public void action() {
        ACLMessage message = myAgent.receive();
        if (message != null) {
            if (Objects.equals(message.getOntology(), CustomerOntology.ONTOLOGY_NAME)) {
                try {
                    OrderMessage orderMessage = (OrderMessage) message.getContentObject();
                    System.out.println("Received " + orderMessage.getLocalName() +
                            " in cell " + orderMessage.getCellId() +
                            ": " + orderMessage.getMenu());
                    JsonManager.writeLog(new JsonAction(
                            "Action",
                            myAgent.getLocalName(),
                            getClass().getName(),
                            orderMessage.getMenu().toString(),
                            "Received " + orderMessage.getLocalName() + " in cell " + orderMessage.getCellId()));
                    ContainerController containerController = myAgent.getContainerController();
                    myAgent.doDelete();
                    containerController.kill();
                } catch (UnreadableException | StaleProxyException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
