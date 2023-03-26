import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;

public class Operation {
    @JsonProperty("oper_type_id")
    private int operationTypeId;

    @JsonProperty("equip_type")
    private int equipType;

    @JsonProperty("oper_time")
    private double time;

    @JsonProperty("oper_async_point")
    private int async;

    @JsonProperty("oper_products")
    private HashSet<Ingredient> ingredients;

    public int getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(int operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    public int getEquipType() {
        return equipType;
    }

    public void setEquipType(int equipType) {
        this.equipType = equipType;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getAsync() {
        return async;
    }

    public void setAsync(int async) {
        this.async = async;
    }

    public HashSet<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashSet<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operationType_id=" + operationTypeId +
                ", equip_type=" + equipType +
                ", time=" + time +
                ", async=" + async +
                ", ingredients=" + ingredients +
                '}';
    }

}