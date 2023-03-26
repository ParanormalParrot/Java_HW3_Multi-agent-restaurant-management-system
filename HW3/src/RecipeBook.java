import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;

public class RecipeBook {
    @JsonProperty("dish_cards")
    private HashSet<Recipe> recipes;

    public HashSet<Recipe> getRecipes() {
        return recipes;
    }

    public RecipeBook() {}

    public RecipeBook(HashSet<Recipe> menu) {
        this.recipes = menu;
    }

    @Override
    public String toString() {
        return "RecipeBook{" +
                "recipes=" + recipes +
                '}';
    }
}
