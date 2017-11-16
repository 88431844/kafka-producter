package com.luck.dto;

/**
 * @Author miracle
 * @Date 2017/11/1 0001 17:28
 */
public class MessageBaseDto extends baseDto {
    private Long sleepTime = 500L;
    private String mainDriverId = "2d7206379f3741548c0d17a9999519bf";

    @Override
    public String toString() {
        return "MessageBaseDto{" +
                "sleepTime=" + sleepTime +
                ", mainDriverId='" + mainDriverId + '\'' +
                super.toString() +
                '}';
    }

    public Long getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(Long sleepTime) {
        this.sleepTime = sleepTime;
    }

    public String getMainDriverId() {
        return mainDriverId;
    }

    public void setMainDriverId(String mainDriverId) {
        this.mainDriverId = mainDriverId;
    }
}
