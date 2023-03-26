import jade.content.AgentAction;

import java.util.HashSet;


public class CustomerMessage implements AgentAction {

    private String localName;

    private HashSet<Order> menu;

    public CustomerMessage(String localName, HashSet<Order> menu) {
        this.localName = localName;
        this.menu = menu;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public HashSet<Order> getMenu() {
        return menu;
    }

    public void setMenu(HashSet<Order> menu) {
        this.menu = menu;
    }
}