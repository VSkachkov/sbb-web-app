package com.mycompany.myproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    private int code;

    private String message;

    private Error error;

    public Response(int code, String message, Error error) {
        this.code = code;
        this.message = message;
        this.error = error;
    }

}
