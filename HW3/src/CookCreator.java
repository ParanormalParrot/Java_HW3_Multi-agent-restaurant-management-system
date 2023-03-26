import jade.core.behaviours.OneShotBehaviour;
public class CookCreator extends OneShotBehaviour {
    @Override
    public void action()  {
        for (var cook :
                ((Controller) myAgent).cooks.getCooks()) {
            ((Controller) myAgent).addAgent("Cook" + cook.getId(), CookAgent.class.getName(),
                    "Cook-Container", new Object[]{});
        }
    }
}
