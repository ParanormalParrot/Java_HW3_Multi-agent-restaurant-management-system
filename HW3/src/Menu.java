import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashSet;

public class Menu implements Serializable {

    @JsonProperty("menu_dishes")
    private HashSet<MenuItem> menu;

    public HashSet<MenuItem> getMenu() {
        return menu;
    }

    public Menu() {}

    public Menu(HashSet<MenuItem> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menu=" + menu +
                '}';
    }
}