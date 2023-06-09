package com.cssl.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

//房屋表
public class House implements Serializable {
    private Integer id;
    private Integer street_id;
    private Integer user_id;
    private Integer type_id;
    private String title;
    private String descript;
    private double price;
    @JSONField(format = "yyyy-MM-dd")private Date pubdate;
    private Integer floorage;
    private String contant;

    public House(Integer id, Integer street_id, Integer user_id, Integer type_id, String title, String descript, double price, Date pubdate, Integer floorage, String contant, Integer tid, String tname) {
        this.id = id;
        this.street_id = street_id;
        this.user_id = user_id;
        this.type_id = type_id;
        this.title = title;
        this.descript = descript;
        this.price = price;
        this.pubdate = pubdate;
        this.floorage = floorage;
        this.contant = contant;
        this.tid = tid;
        this.tname = tname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    //两表联查 type表
    private Integer tid;
    private String tname;

    //四表联查
    //Street表
    private Integer sid;
    private Integer district_id;
    private String sname;
    //District表
    private Integer did;
    //地区编号
    private String dname;

    public House(Integer id, Integer street_id, Integer user_id, Integer type_id, String title, String descript, double price, Date pubdate, Integer floorage, String contant, Integer tid, String tname, Integer sid, Integer district_id, String sname, Integer did, String dname) {
        this.id = id;
        this.street_id = street_id;
        this.user_id = user_id;
        this.type_id = type_id;
        this.title = title;
        this.descript = descript;
        this.price = price;
        this.pubdate = pubdate;
        this.floorage = floorage;
        this.contant = contant;
        this.tid = tid;
        this.tname = tname;
        this.sid = sid;
        this.district_id = district_id;
        this.sname = sname;
        this.did = did;
        this.dname = dname;
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

    public House(Integer id, Integer street_id, Integer user_id, Integer type_id, String title, String descript, double price, Date pubdate, Integer floorage, String contant) {
        this.id = id;
        this.street_id = street_id;
        this.user_id = user_id;
        this.type_id = type_id;
        this.title = title;
        this.descript = descript;
        this.price = price;
        this.pubdate = pubdate;
        this.floorage = floorage;
        this.contant = contant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStreet_id() {
        return street_id;
    }

    public void setStreet_id(Integer street_id) {
        this.street_id = street_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public double getPrivce() {
        return price;
    }

    public void setPrivce(double privce) {
        this.price = privce;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Integer getFloorage() {
        return floorage;
    }

    public void setFloorage(Integer floorage) {
        this.floorage = floorage;
    }

    public String getContant() {
        return contant;
    }

    public void setContant(String contant) {
        this.contant = contant;
    }

    public House() {
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", street_id=" + street_id +
                ", user_id=" + user_id +
                ", type_id=" + type_id +
                ", title='" + title + '\'' +
                ", descript='" + descript + '\'' +
                ", price=" + price +
                ", pubdate=" + pubdate +
                ", floorage=" + floorage +
                ", contant='" + contant + '\'' +
                ", tid=" + tid +
                ", tname='" + tname + '\'' +
                ", sid=" + sid +
                ", district_id=" + district_id +
                ", sname='" + sname + '\'' +
                ", did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }
}
