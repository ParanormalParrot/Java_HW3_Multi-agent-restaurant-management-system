import com.fasterxml.jackson.annotation.JsonProperty;

public class Ingredient {

    @JsonProperty("prod_type_id")
    private int type_id;

    @JsonProperty("prod_quantity")
    private double amount;

    @Override
    public String toString() {
        return "Ingredient{" +
                "type_id=" + type_id +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (type_id != that.type_id) return false;
        return Double.compare(that.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = type_id;
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}