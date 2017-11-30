package com.luck.entity;

import java.io.Serializable;

/**
 * @Author miracle
 * @Date 2017/7/11 0011 15:36
 */
public class FaultCode implements Serializable {
    private String _id;// mongo主键
    private long vid;//车辆ID
    private int spn;// SPN
    private int fmi;// FMI
    private long begin;// 开始时间
    private long end;// 结束时间
    private int con;// 持续时长
    private int bLat;// 开始纬度
    private int bLng;// 开始经度
    private int eLat;// 结束纬度
    private int eLng;// 结束经度

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public long getVid() {
        return vid;
    }

    public void setVid(long vid) {
        this.vid = vid;
    }

    public int getSpn() {
        return spn;
    }

    public void setSpn(int spn) {
        this.spn = spn;
    }

    public int getFmi() {
        return fmi;
    }

    public void setFmi(int fmi) {
        this.fmi = fmi;
    }

    public long getBegin() {
        return begin;
    }

    public void setBegin(long begin) {
        this.begin = begin;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getbLat() {
        return bLat;
    }

    public void setbLat(int bLat) {
        this.bLat = bLat;
    }

    public int getbLng() {
        return bLng;
    }

    public void setbLng(int bLng) {
        this.bLng = bLng;
    }

    public int geteLat() {
        return eLat;
    }

    public void seteLat(int eLat) {
        this.eLat = eLat;
    }

    public int geteLng() {
        return eLng;
    }

    public void seteLng(int eLng) {
        this.eLng = eLng;
    }

    @Override
    public String toString() {
        return "{" +
                "_id='" + _id + '\'' +
                ", vid=" + vid +
                ", spn=" + spn +
                ", fmi=" + fmi +
                ", begin=" + begin +
                ", end=" + end +
                ", con=" + con +
                ", bLat=" + bLat +
                ", bLng=" + bLng +
                ", eLat=" + eLat +
                ", eLng=" + eLng +
                '}';
    }
}
