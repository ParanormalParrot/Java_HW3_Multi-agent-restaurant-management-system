
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.Objects;

public class Product {
    @JsonProperty("prod_item_id")
    private int id;

    @JsonProperty("prod_item_type")
    private int type;

    @JsonProperty("prod_item_name")
    private String name;

    @JsonProperty("prod_item_company")
    private String company;

    @JsonProperty("prod_item_unit")
    private String unit;

    @JsonProperty("prod_item_quantity")
    private double amount;

    @JsonProperty("prod_item_cost")
    private int price;

    @JsonProperty("prod_item_delivered")
    private Timestamp delivered;

    @JsonProperty("prod_item_valid_until")
    private Timestamp usableUntil;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getDelivered() {
        return delivered;
    }

    public void setDelivered(Timestamp delivered) {
        this.delivered = delivered;
    }

    public Timestamp getUsableUntil() {
        return usableUntil;
    }

    public void setUsableUntil(Timestamp usableUntil) {
        this.usableUntil = usableUntil;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", unit='" + unit + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", delivered=" + delivered +
                ", usableUntil=" + usableUntil +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (type != product.type) return false;
        if (Double.compare(product.amount, amount) != 0) return false;
        if (price != product.price) return false;
        if (!Objects.equals(name, product.name)) return false;
        if (!Objects.equals(company, product.company)) return false;
        if (!Objects.equals(unit, product.unit)) return false;
        if (!Objects.equals(delivered, product.delivered)) return false;
        return Objects.equals(usableUntil, product.usableUntil);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + type;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + price;
        result = 31 * result + (delivered != null ? delivered.hashCode() : 0);
        result = 31 * result + (usableUntil != null ? usableUntil.hashCode() : 0);
        return result;
    }
}

