package com.example.persistclient.global;

import com.fasterxml.jackson.annotation.JsonProperty;


public class StatusResponse {
    public StatusResponse(String status){
        this.status = status;
    }
    @JsonProperty("status")
    public String status;
}
