package com.luck.dto;

/**
 * @Author miracle
 * @Date 2017/11/1 0001 16:39
 */
public class SendPointEventDto extends EventBaseDto{
    //沈阳经纬度 纬度（Longitude）：41.6771800000,经度（Latitude）：123.4631000000
    //大连经纬度 纬度（Longitude）：38.9136900000,经度（Latitude）：121.6147600000
    //滨州经纬度 纬度（Longitude）：37.3821100000,经度（Latitude）：117.9727900000
    //成都经纬度 纬度（Longitude）：30.5702000000,经度（Latitude）：104.0647600000

    /**
     * 纬度
     */
    private Integer longitude;
    /**
     * 经度
     */
    private Integer latitude;

    @Override
    public String toString() {
        return "SendPointEventDto{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                super.toString()+
                '}';
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }
}
