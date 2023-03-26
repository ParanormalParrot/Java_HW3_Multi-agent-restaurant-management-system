import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CustomerQueue {
    @JsonProperty("visitors_orders")
    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public CustomerQueue() {}

    public CustomerQueue(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "CustomerQueue{" +
                "customers=" + customers +
                '}';
    }
}
