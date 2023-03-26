import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;

public class EquipmentTypeList {
    @JsonProperty("equipment_type")
    private HashSet<EquipmentType> equipmentTypesTypes;

    public HashSet<EquipmentType> getEquipmentTypes() {
        return equipmentTypesTypes;
    }

    public EquipmentTypeList() {}

    public EquipmentTypeList(HashSet<EquipmentType> equipmentTypes) {
        this.equipmentTypesTypes = equipmentTypes;
    }

    @Override
    public String toString() {
        return "EquipmentTypeList{" +
                "ingredientTypes=" + equipmentTypesTypes +
                '}';
    }
}
