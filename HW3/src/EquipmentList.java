import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;

public class EquipmentList {
    @JsonProperty("equipment")
    private HashSet<Equipment> equipment;

    public HashSet<Equipment> getEquipment() {
        return equipment;
    }

    public EquipmentList() {}

    public EquipmentList(HashSet<Equipment> equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "EquipmentList{" +
                "equipment=" + equipment +
                '}';
    }
}
