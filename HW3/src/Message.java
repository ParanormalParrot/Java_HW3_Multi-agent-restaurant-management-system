import jade.content.AgentAction;

public class Message implements AgentAction {
    private String localName;
    private String content;

    public Message(String localName, String content) {
        this.localName = localName;
        this.content = content;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}