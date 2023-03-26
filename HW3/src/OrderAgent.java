import jade.core.Agent;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;

public class OrderAgent extends Agent implements Serializable {

    private String customerName;
    private int cellId = 0;
    private HashSet<Order> menu;

    protected void setup() {
        Object[] args = getArguments();
        menu = (HashSet<Order>) args[0];
        Random random = new Random();
        cellId = random.nextInt(1, 20);
        customerName = (String) args[1];
        System.out.println("Manager created new order " + this.getLocalName() + ", now it's ready to go!");
        addBehaviour(new PrepareOrder());
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCellId() {
        return cellId;
    }

    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    public HashSet<Order> getMenu() {
        return menu;
    }

    public void setMenu(HashSet<Order> menu) {
        this.menu = menu;
    }

    @Override
    protected void takeDown() {
        JsonManager.writeLog(new JsonAction(
                "Deletion",
                getLocalName(),
                getClass().getName(),
                "",
                getLocalName() + " shut down"));
        super.takeDown();
    }
}