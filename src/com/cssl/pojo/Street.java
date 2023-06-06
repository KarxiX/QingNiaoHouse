package com.cssl.pojo;

import java.io.Serializable;

//街道表
public class Street implements Serializable {
    private Integer sid;
    private Integer district_id;
    private String sname;

    public Street(Integer sid, Integer district_id, String sname) {
        this.sid = sid;
        this.district_id = district_id;
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Street{" +
                "sid=" + sid +
                ", district_id=" + district_id +
                ", sname='" + sname + '\'' +
                '}';
    }

    public Street() {
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Integer district_id) {
        this.district_id = district_id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
