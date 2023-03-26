import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class MenuItem implements Serializable {

    @JsonProperty("menu_dish_id")
    private int Id;

    @JsonProperty("menu_dish_card")
    private int recipeId;

    @JsonProperty("menu_dish_price")
    private int price;

    @JsonProperty("menu_dish_active")
    private boolean isAvailable;

    public MenuItem() {
    }

    public MenuItem(int id, int recipeId, int price, boolean isAvailable) {
        this.Id = id;
        this.recipeId = recipeId;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return Id;
    }


    public int getRecipeId() {
        return recipeId;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + Id +
                ", recipe_id=" + recipeId +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuItem menuItem = (MenuItem) o;

        if (Id != menuItem.Id) return false;
        if (recipeId != menuItem.recipeId) return false;
        if (price != menuItem.price) return false;
        return isAvailable == menuItem.isAvailable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, recipeId, price, isAvailable);
    }
}