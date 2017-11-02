package com.luck.dto;

/**
 * @Author miracle
 * @Date 2017/11/1 0001 16:39
 */
public class SendPointEventDto extends EventBaseDto{
    //沈阳经纬度 纬度（Latitude）：41.6771800000,经度（Longitude）：123.4631000000
    //大连经纬度 纬度（Latitude）：38.9136900000,经度（Longitude）：121.6147600000
    //滨州经纬度 纬度（Latitude）：37.3821100000,经度（Longitude）：117.9727900000
    //成都经纬度 纬度（Latitude）：30.5702000000,经度（Longitude）：104.0647600000

    //赋值经纬度时候应该去掉小数点，并且保留小数点后六位！！！！！！！！！！

    /**
     * 纬度
     */
    private Integer longitude = 37382110;
    /**
     * 经度
     */
    private Integer latitude = 117972790;

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
