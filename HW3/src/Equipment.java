import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Equipment {
    public class EquipmentType {
        @JsonProperty("equip_type_id")
        private int id;
        @JsonProperty("equip_type_name")
        private String name;

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

        @Override
        public String toString() {
            return "EquipmentType{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            EquipmentType that = (EquipmentType) o;

            if (id != that.id) return false;
            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }
}
