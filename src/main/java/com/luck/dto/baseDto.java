package com.luck.dto;

import com.luck.entity.KafkaPropertiesEntity;

/**
 * @Author miracle
 * @Date 2017/11/15 0015 17:25
 */
public class baseDto {
    private KafkaPropertiesEntity kafkaPropertiesEntity;

    private boolean useOwnKafka = false;

    @Override
    public String toString() {
        return "baseDto{" +
                "kafkaPropertiesEntity=" + kafkaPropertiesEntity +
                ", useOwnKafka=" + useOwnKafka +
                '}';
    }

    public KafkaPropertiesEntity getKafkaPropertiesEntity() {
        return kafkaPropertiesEntity;
    }

    public void setKafkaPropertiesEntity(KafkaPropertiesEntity kafkaPropertiesEntity) {
        this.kafkaPropertiesEntity = kafkaPropertiesEntity;
    }

    public boolean isUseOwnKafka() {
        return useOwnKafka;
    }

    public void setUseOwnKafka(boolean useOwnKafka) {
        this.useOwnKafka = useOwnKafka;
    }
}
