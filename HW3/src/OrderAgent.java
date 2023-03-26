import jade.core.Agent;

import java.io.Serializable;

public class OrderAgent extends Agent implements Serializable {

    private String customerName;
    private int cellId = 0;
    private Menu menu;

    protected void setup() {
        Object[] args = getArguments();
        menu = (Menu) args[0];
        customerName = (String) args[1];
        System.out.println("Order agent " + this.getLocalName() + ", is ready.");
        addBehaviour(new OrderReady());
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}