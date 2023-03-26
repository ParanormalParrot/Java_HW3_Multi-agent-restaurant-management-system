import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Cook {

    @JsonProperty("cook_id")
    private int id;

    @JsonProperty("cook_name")
    private String name;

    @JsonProperty("cook_active")
    private boolean available;

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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Cook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cook cook = (Cook) o;

        if (id != cook.id) return false;
        if (available != cook.available) return false;
        return Objects.equals(name, cook.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, available);
    }
}