package com.luck.entity;


import com.luck.kafka.KafkaCommand;

import java.io.Serializable;
import java.util.List;

public class PushStatusRecordEntity extends KafkaCommand implements Serializable {
    private Long id;

    private String autoTerminalId;

    private String carId;

    private String carNumber;

    /**
     * 车主id
     */
    private String ownerId;

    /**
     * 主驾id
     */
    private String mainDriver;

    private String mainDriverName;

    private String mainDriverPhone;

    /**
     * 副驾id
     */
    private String subDriver;

    private String subDriverName;

    private String subDriverPhone;

    private Integer type;

    private Long beginTime;

    private Double beginLon;

    private Double beginLat;

    private Integer beginSpeed;

    private Double instantOil;

    private String position;

    private Double tripLength;

    private String description;

    private Integer direction;

    private Integer travelStatus;

    private List<String> managerIds;

    public List<String> getManagerIds() {
        return managerIds;
    }

    public void setManagerIds(List<String> managerIds) {
        this.managerIds = managerIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber == null ? null : carNumber.trim();
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
    }

    public String getMainDriver() {
        return mainDriver;
    }

    public void setMainDriver(String mainDriver) {
        this.mainDriver = mainDriver == null ? null : mainDriver.trim();
    }

    public String getMainDriverName() {
        return mainDriverName;
    }

    public void setMainDriverName(String mainDriverName) {
        this.mainDriverName = mainDriverName == null ? null : mainDriverName.trim();
    }

    public String getMainDriverPhone() {
        return mainDriverPhone;
    }

    public void setMainDriverPhone(String mainDriverPhone) {
        this.mainDriverPhone = mainDriverPhone == null ? null : mainDriverPhone.trim();
    }

    public String getSubDriver() {
        return subDriver;
    }

    public void setSubDriver(String subDriver) {
        this.subDriver = subDriver == null ? null : subDriver.trim();
    }

    public String getSubDriverName() {
        return subDriverName;
    }

    public void setSubDriverName(String subDriverName) {
        this.subDriverName = subDriverName == null ? null : subDriverName.trim();
    }

    public String getSubDriverPhone() {
        return subDriverPhone;
    }

    public void setSubDriverPhone(String subDriverPhone) {
        this.subDriverPhone = subDriverPhone == null ? null : subDriverPhone.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public Double getBeginLon() {
        return beginLon;
    }

    public void setBeginLon(Double beginLon) {
        this.beginLon = beginLon;
    }

    public Double getBeginLat() {
        return beginLat;
    }

    public void setBeginLat(Double beginLat) {
        this.beginLat = beginLat;
    }

    public Integer getBeginSpeed() {
        return beginSpeed;
    }

    public void setBeginSpeed(Integer beginSpeed) {
        this.beginSpeed = beginSpeed;
    }

    public Double getInstantOil() {
        return instantOil;
    }

    public void setInstantOil(Double instantOil) {
        this.instantOil = instantOil;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Double getTripLength() {
        return tripLength;
    }

    public void setTripLength(Double tripLength) {
        this.tripLength = tripLength;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getTravelStatus() {
        return travelStatus;
    }

    public void setTravelStatus(Integer travelStatus) {
        this.travelStatus = travelStatus;
    }

    public String getAutoTerminalId() {
        return autoTerminalId;
    }

    public void setAutoTerminalId(String autoTerminalId) {
        this.autoTerminalId = autoTerminalId;
    }
}