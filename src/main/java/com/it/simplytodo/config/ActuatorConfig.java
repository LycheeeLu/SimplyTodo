package com.it.simplytodo.config;



import com.it.simplytodo.actuator.TodoActuatorEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActuatorConfig {
    @Bean
    public TodoActuatorEndpoint customEndpoint(){
        return new TodoActuatorEndpoint();
    }
}
