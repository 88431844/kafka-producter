package com.luck.entity;

/**
 * @Author miracle
 * @Date 2017/11/15 0015 17:36
 */
public class KafkaPropertiesEntity {

    private String kafkaSever = "SY-LP1:9092,SY-LP2:9092,SY-LP3:9092";

    private String keySerializer = "org.apache.kafka.common.serialization.StringSerializer";

    private String valueSerializer = "org.apache.kafka.common.serialization.StringSerializer";

    @Override
    public String toString() {
        return "KafkaPropertiesEntity{" +
                "kafkaSever='" + kafkaSever + '\'' +
                ", keySerializer='" + keySerializer + '\'' +
                ", valueSerializer='" + valueSerializer + '\'' +
                '}';
    }

    public String getKafkaSever() {
        return kafkaSever;
    }

    public void setKafkaSever(String kafkaSever) {
        this.kafkaSever = kafkaSever;
    }

    public String getKeySerializer() {
        return keySerializer;
    }

    public void setKeySerializer(String keySerializer) {
        this.keySerializer = keySerializer;
    }

    public String getValueSerializer() {
        return valueSerializer;
    }

    public void setValueSerializer(String valueSerializer) {
        this.valueSerializer = valueSerializer;
    }
}
