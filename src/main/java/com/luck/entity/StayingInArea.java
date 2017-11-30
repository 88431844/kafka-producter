package com.luck.entity;

import java.io.Serializable;

/**
 * @Author miracle
 * @Date 2017/11/30 0030 10:07
 */
public class StayingInArea implements Serializable {
    private String _id;//mongodb主键
    private long vid;//车辆ID
    private long aId;//区域标识
    private long begin;//入区域时间
    private long end;//出区域时间
    private int con;//停留时长
    private int lat;//纬度
    private int lng;//经度

    @Override
    public String toString() {
        return "StayingInArea{" +
                "_id='" + _id + '\'' +
                ", vid=" + vid +
                ", aId=" + aId +
                ", begin=" + begin +
                ", end=" + end +
                ", con=" + con +
                ", lat=" + lat +
                ", lng=" + lng +
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

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }
}
