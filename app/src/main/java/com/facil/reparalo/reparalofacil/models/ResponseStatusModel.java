package com.facil.reparalo.reparalofacil.models;

public class ResponseStatusModel {

    String msg;
    Integer status;

    public String getMsg() {
        return msg;
    }

    public ResponseStatusModel setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ResponseStatusModel setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
