package com.viranga.shoppingcart.module.dto.common;

import com.viranga.shoppingcart.commons.Constant;

import java.io.Serializable;

public class ResponseDTO<T> implements Serializable {

    private T result;

    private String message;

    private boolean success;

    private Constant.ResponseStatus status;

    public ResponseDTO() {
    }

    public ResponseDTO(T result) {
        this.result = result;
        status = Constant.ResponseStatus.SUCCESS;
        success = true;

    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Constant.ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(Constant.ResponseStatus status) {
        this.status = status;
    }
}
