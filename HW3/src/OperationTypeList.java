import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;

public class OperationTypeList {
    @JsonProperty("operation_types")
    private HashSet<OperationType> operationTypes;

    public HashSet<OperationType> getOperationTypes() {
        return operationTypes;
    }

    public OperationTypeList() {
    }

    public OperationTypeList(HashSet<OperationType> operationTypes) {
        this.operationTypes = operationTypes;
    }

    @Override
    public String toString() {
        return "OperationTypeList{" +
                "operationTypes=" + operationTypes +
                '}';
    }
}