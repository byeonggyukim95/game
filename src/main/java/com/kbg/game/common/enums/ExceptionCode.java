package com.kbg.game.common.enums;

import lombok.Getter;

@Getter
public enum ExceptionCode {

    INTERNAL_SERVER_ERROR("00001", "exception_server_error");

    private String code;
    private String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
