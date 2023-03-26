
import jade.core.behaviours.OneShotBehaviour;

public class ManagerCreator extends OneShotBehaviour {
    @Override
    public void action() {
        ((Controller)myAgent).addAgent("Manager", ManagerAgent.class.getName());
    }
}
