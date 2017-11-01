package com.luck.dto;

/**
 * @Author miracle
 * @Date 2017/11/1 0001 16:39
 */
public class SendSpeedEventDto extends EventBaseDto{

    private Integer speed = 100;

    @Override
    public String toString() {
        return "SendSpeedEventDto{" +
                "speed=" + speed +
                super.toString()+
                '}';
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}
