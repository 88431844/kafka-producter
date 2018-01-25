package com.luck.dto;

/**发送字符串到kafka DTO
 * Created by gzh on 2018/1/25 0025.
 */
public class SendStringDto {
    /**
     * 要发送的topic
     */
    private String sendTopic;
    /**
     * 要发送的字符串
     */
    private String sendStr;

    @Override
    public String toString() {
        return "SendStringDto{" +
                "sendTopic='" + sendTopic + '\'' +
                ", sendStr='" + sendStr + '\'' +
                '}';
    }

    public String getSendTopic() {
        return sendTopic;
    }

    public void setSendTopic(String sendTopic) {
        this.sendTopic = sendTopic;
    }

    public String getSendStr() {
        return sendStr;
    }

    public void setSendStr(String sendStr) {
        this.sendStr = sendStr;
    }
}
