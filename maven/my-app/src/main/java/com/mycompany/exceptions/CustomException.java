package com.mycompany.exceptions;

import java.util.Objects;

public class CustomException extends RuntimeException {
    int code;


    public CustomException(String msg, int code) {
        super("CustomException: " + msg);
        if (Objects.isNull(code))
            code = 500;
        this.setCode(code);

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
