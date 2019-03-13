package com.dugauguez.crunch.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class Task {

    @JsonProperty("name")
    String name;

    @JsonProperty("status")
    String status;

}
