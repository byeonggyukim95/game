package com.kbg.game.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CommonResponse {

    private String code = "0";
    private String message = "OK";
    private Object data;

    public CommonResponse(Object data) {
        this.data = data;
    }

    public CommonResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public CommonResponse(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
