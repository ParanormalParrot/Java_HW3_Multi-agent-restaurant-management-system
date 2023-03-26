import java.io.Serializable;
import java.util.HashSet;

public final class OrderMessage implements Serializable {
    private final String localName;
    private final HashSet<Order> menu;
    private final int cellId;

    public OrderMessage(String localName, HashSet<Order> menu, int cellId) {
        this.localName = localName;
        this.menu = menu;
        this.cellId = cellId;
    }

    public String getLocalName() {
        return localName;
    }

    public HashSet<Order> getMenu() {
        return menu;
    }

    public int getCellId() {
        return cellId;
    }
}