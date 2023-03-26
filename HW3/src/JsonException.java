import com.fasterxml.jackson.annotation.JsonProperty;

    public class JsonException {

        @JsonProperty("type")
        private String exceptionType;

        @JsonProperty("description")
        private String exceptionDescription;

        public JsonException(String type, String description) {
            exceptionType = type;
            exceptionDescription = description;
        }
    }

