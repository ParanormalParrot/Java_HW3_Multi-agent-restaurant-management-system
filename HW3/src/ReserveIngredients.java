
import jade.core.behaviours.OneShotBehaviour;

public class ReserveIngredients extends OneShotBehaviour {

    String customerName;
    @Override
    public void action() {
        JsonManager.writeLog(new JsonAction(
                "Action",
                myAgent.getLocalName(),
                getClass().getName(),
                customerName,
                "Ingredients reserved for " + customerName));
    }

    public ReserveIngredients(String customerName) {
        this.customerName = customerName;
    }
}
