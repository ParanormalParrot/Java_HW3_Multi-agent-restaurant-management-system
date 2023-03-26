import java.io.Serializable;

public final class OrderMessage implements Serializable {
    private final String localName;
    private final Menu menu;
    private final int cellId;

    public OrderMessage(String localName, Menu menu, int cellId) {
        this.localName = localName;
        this.menu = menu;
        this.cellId = cellId;
    }

    public String getLocalName() {
        return localName;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getCellId() {
        return cellId;
    }
}