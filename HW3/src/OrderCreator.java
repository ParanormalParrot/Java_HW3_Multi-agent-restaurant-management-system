import jade.core.behaviours.OneShotBehaviour;

import java.util.HashSet;

public class OrderCreator extends OneShotBehaviour {

    static int orderId = 1;

    HashSet<Order> menu;

    @Override
    public void action() {
        ((ManagerAgent) myAgent).addAgent("Order" + orderId,
                OrderAgent.class.getName(), "Order-Container", new Object[]{
                        ((ManagerAgent) myAgent).getCurrentMenu(),
                        ((ManagerAgent) myAgent).getCurrentCustomerName()
                });
        myAgent.addBehaviour(new ReserveIngredients(((ManagerAgent) myAgent).getCurrentCustomerName()));
        ManagerAgent.map.put(ManagerAgent.orders.peek().getId(), orderId);
        ++orderId;
    }

    public OrderCreator(HashSet<Order> menu) {
        this.menu = menu;
    }
}
