package com.home.books.models;

import org.springframework.stereotype.Component;

@Component
public class AppResponse {

    private String msg;
    private String id;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
