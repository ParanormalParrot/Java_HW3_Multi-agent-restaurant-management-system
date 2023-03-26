import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Process {
    @JsonProperty("operations")
    private List<Operation> operations;

    public List<Operation> getOperations() {
        return operations;
    }

    public Process() {}

    public Process(List<Operation> makingProcess) {
        this.operations = makingProcess;
    }

    @Override
    public String toString() {
        return "Process{" +
                "operations=" + operations +
                '}';
    }
}