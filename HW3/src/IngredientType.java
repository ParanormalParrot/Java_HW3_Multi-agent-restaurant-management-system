import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class IngredientType {
    @JsonProperty("prod_type_id")
    private int id;
    @JsonProperty("prod_type_name")
    private String name;
    @JsonProperty("prod_is_food")
    private boolean is_food;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_food() {
        return is_food;
    }

    public void setIs_food(boolean is_food) {
        this.is_food = is_food;
    }

    @Override
    public String toString() {
        return "IngredientType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", is_food=" + is_food +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientType that = (IngredientType) o;

        if (id != that.id) return false;
        if (is_food != that.is_food) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (is_food ? 1 : 0);
        return result;
    }
}