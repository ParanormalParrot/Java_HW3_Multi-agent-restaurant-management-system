import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;

public class Stock {
    @JsonProperty("products")
    private HashSet<Product> storage;

    public HashSet<Product> getStorage() {
        return storage;
    }

    public Stock(HashSet<Product> storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "storage=" + storage +
                '}';
    }
}