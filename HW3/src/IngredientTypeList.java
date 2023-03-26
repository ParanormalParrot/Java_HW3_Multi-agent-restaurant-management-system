import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;

public class IngredientTypeList {

    @JsonProperty("product_types")
    private HashSet<IngredientType> ingredientTypes;

    public HashSet<IngredientType> getIngredientTypes() {
        return ingredientTypes;
    }

    public IngredientTypeList() {}

    public IngredientTypeList(HashSet<IngredientType> ingredientTypes) {
        this.ingredientTypes = ingredientTypes;
    }

    @Override
    public String toString() {
        return "IngredientTypeList{" +
                "ingredientTypes=" + ingredientTypes +
                '}';
    }
}
