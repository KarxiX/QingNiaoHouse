package com.cssl.pojo;

import java.io.Serializable;

//地区表
public class District implements Serializable {
    private Integer did;
    //地区编号
    private String dname;
    //地区名称
    public District(Integer did, String dname) {
        this.did = did;
        this.dname = dname;
    }
    public District() {
    }
    public Integer getDid() {
        return did;
    }
    public void setDid(Integer did) {
        this.did = did;
    }
    public String getDname() {
        return dname;
    }
    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "District{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }
}
