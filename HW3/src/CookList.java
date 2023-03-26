import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;

public class CookList {
    @JsonProperty("cooks")
    private HashSet<Cook> cooks;

    public HashSet<Cook> getCooks() {
        return cooks;
    }

    public CookList(HashSet<Cook> cooks) {
        this.cooks = cooks;
    }

    @Override
    public String toString() {
        return "CookList{" +
                "cooks=" + cooks +
                '}';
    }
}