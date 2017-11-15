package com.luck.dto;

/**
 * @Author miracle
 * @Date 2017/11/9 0009 15:46
 */
public class SendUnormalEventDto extends EventBaseDto {
    /**
     * 0：无任何不正常情况
     * 1: 急加速
     * 2：急减速
     * 3：急转弯
     * 4：急加速+急转弯
     * 5：急减速+急转弯
     */
    private Integer type = 0;

    @Override
    public String toString() {
        return "SendUnormalEventDto{" +
                "type=" + type +
                super.toString()+
                '}';
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
