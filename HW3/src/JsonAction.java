import com.fasterxml.jackson.annotation.JsonProperty;


public class JsonAction {
    @JsonProperty("type")
    private String type;

    @JsonProperty("local_name")
    private String localName;

    @JsonProperty("class_name")
    private String className;

    @JsonProperty("content")
    private String content;

    @JsonProperty("description")
    private String description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JsonAction(String type, String localName, String className, String content, String description) {
        this.type = type;
        this.localName = localName;
        this.className = className;
        this.content = content;
        this.description = description;
    }
}

