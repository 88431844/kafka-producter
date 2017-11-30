package com.luck.entity;

import java.io.Serializable;

/**
 * 滞留超时
 * @Author miracle
 * @Date 2017/7/12 0012 10:24
 */
public class OvertimePark implements Serializable {
    private String _id;// mongo主键
    private long vid;//车辆ID
    private long aId;//区域标识
    private long begin;// 入区域时间
    private long end;// 出区域时间
    private int con;// 滞留超时时间长度

    private int limit;// 滞留阀值
    private int bLat;// 入区域纬度
    private int bLng;// 入区域经度
    private int eLat;// 出区域纬度
    private int eLng;// 出区域经度
    private int isDel;//逻辑删除标志位 0为未删除 1为删除

    @Override
    public String toString() {
        return "OvertimePark{" +
                "_id='" + _id + '\'' +
                ", vid=" + vid +
                ", aId=" + aId +
                ", begin=" + begin +
                ", end=" + end +
                ", con=" + con +
                ", limit=" + limit +
                ", bLat=" + bLat +
                ", bLng=" + bLng +
                ", eLat=" + eLat +
                ", eLng=" + eLng +
                ", isDel=" + isDel +
                '}';
    }

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

    public long getaId() {
        return aId;
    }

    public void setaId(long aId) {
        this.aId = aId;
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

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
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

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }
}
