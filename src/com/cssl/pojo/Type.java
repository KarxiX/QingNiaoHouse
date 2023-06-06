package com.cssl.pojo;

import java.io.Serializable;

public class Type implements Serializable {
    private Integer tid;
    private String tname;

    @Override
    public String toString() {
        return "Type{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                '}';
    }

    public Type() {
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Type(Integer tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }
}
