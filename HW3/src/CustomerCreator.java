
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class CustomerCreator {
    int customerId = 0;

    public CustomerCreator(Agent a, long period) {
        super(a, period);
    }

    @Override
    protected void onTick() {
        if (customerId < ((ModuleLayer.Controller) myAgent).customers.getCustomers().size()) {
            ((ModuleLayer.Controller) myAgent).addAgent("Customer " + ((ModuleLayer.Controller) myAgent).customers.getCustomers().get(customerId++).getName(),
                    CustomerAgent.class.getName(), "Customer-Container", new Menu[]{((ModuleLayer.Controller) myAgent).menu});
        }
    }
}
