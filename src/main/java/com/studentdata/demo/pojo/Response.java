package com.studentdata.demo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include. NON_NULL)
@NoArgsConstructor
public class Response {
    String status;
    Object response;
    private Response(String status) {
        this.status = status;
    }
    private Response(String status, Object response) {
        this.status = status;
        this.response = response;
    }
    public static Response getInstance(String status) {
        return new Response(status);
    }
    public static Response getInstance(String status, Object response) {
        return new Response(status, response);
    }
}
