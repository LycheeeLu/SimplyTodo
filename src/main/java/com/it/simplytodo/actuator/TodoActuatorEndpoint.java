package com.it.simplytodo.actuator;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

@Endpoint(id = "todo_actuator_endpoint")
public class TodoActuatorEndpoint {
    @ReadOperation
    public String customOperation() {

        // custom logic to implement
        return "custom operation for todo";
    }
}
