package com.luck.dto;

/**
 * @Author miracle
 * @Date 2017/11/1 0001 16:39
 */
public class SendStatusEventDto extends EventBaseDto{

    private String carStatus = "0";
    private Integer speed = 100;


    @Override
    public String toString() {
        return "SendStatusEventDto{" +
                "carStatus='" + carStatus + '\'' +
                ", speed=" + speed +
                super.toString()+
                '}';
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}
