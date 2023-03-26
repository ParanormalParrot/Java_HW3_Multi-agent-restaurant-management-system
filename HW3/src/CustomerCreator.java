
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.wrapper.AgentController;

import java.util.HashSet;


public class CustomerCreator extends TickerBehaviour {
    int customerId = 0;

    public CustomerCreator(Agent a, long period) {
        super(a, period);
    }

    @Override
    protected void onTick() {
        if (customerId < ((Controller) myAgent).customers.getCustomers().size()) {
            ((Controller) myAgent).addAgent("Customer " + ((Controller) myAgent).customers.getCustomers().get(customerId++).getName(),
                    CustomerAgent.class.getName(), "Customer-Container", new Menu[]{((Controller) myAgent).menu});
        }
    }
}
