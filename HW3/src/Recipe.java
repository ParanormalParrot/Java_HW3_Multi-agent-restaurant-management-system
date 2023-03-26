import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.Objects;

public class Recipe {
    @JsonProperty("card_id")
    private int id;

    @JsonProperty("dish_name")
    private String name;

    @JsonProperty("card_descr")
    private String description;

    @JsonProperty("card_time")
    private double time;

    @JsonUnwrapped
    private Process process;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                ", process=" + process +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (id != recipe.id) return false;
        if (Double.compare(recipe.time, time) != 0) return false;
        if (!Objects.equals(name, recipe.name)) return false;
        if (!Objects.equals(description, recipe.description)) return false;
        return Objects.equals(process, recipe.process);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(time);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (process != null ? process.hashCode() : 0);
        return result;
    }
}
