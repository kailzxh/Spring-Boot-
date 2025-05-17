package com.example.journelApp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JournelEntries {
    public long id;
    @JsonProperty("Time")
    public String Time;
    public String msg;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
