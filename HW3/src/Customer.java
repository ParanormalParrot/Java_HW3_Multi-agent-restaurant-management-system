

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;

public class Customer {

    @JsonProperty("vis_name")
    private String name;

    @JsonProperty("vis_ord_started")
    private Timestamp start;

    @JsonProperty("vis_ord_ended")
    private Timestamp end;

    @JsonProperty("vis_ord_total")
    private int total;

    @JsonProperty("vis_ord_dishes")
    private HashSet<Order> order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Order> getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", total=" + total +
                ", order=" + order +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (total != customer.total) return false;
        if (!Objects.equals(name, customer.name)) return false;
        if (!Objects.equals(start, customer.start)) return false;
        if (!Objects.equals(end, customer.end)) return false;
        return Objects.equals(order, customer.order);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + total;
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }
}