package com.phoneix.Usedcarinventory.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

public class UsedCarEntity implements Serializable {
    /** Serializable ID. */
    private static final long serialVersionUID = 1L;
    private long carId;
    private String vehicleType;
    private String model;
    private String company;
    private long price;
    private String carName;
    private int bhp;
    private String engineCapacity;
    private long mileage;
    private long kmRun;
    private String transmission;
    private String color;
    private int seater;
    private String location;
    private String version;
    private String owner;
    private String carStatus;
    private Timestamp dateTime;

    public UsedCarEntity()
    {
        super();
    }

    public UsedCarEntity(long carId, String vehicleType, String model, String company, long price, String carName, int bhp, String engineCapacity, long mileage, long kmRun, String transmission, String color, int seater, String location, String version, String owner) {
        this.carId = carId;
        this.vehicleType = vehicleType;
        this.model = model;
        this.company = company;
        this.price = price;
        this.carName = carName;
        this.bhp = bhp;
        this.engineCapacity = engineCapacity;
        this.mileage = mileage;
        this.kmRun = kmRun;
        this.transmission = transmission;
        this.color = color;
        this.seater = seater;
        this.location = location;
        this.version = version;
        this.owner = owner;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getBhp() {
        return bhp;
    }

    public void setBhp(int bhp) {
        this.bhp = bhp;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public long getKmRun() {
        return kmRun;
    }

    public void setKmRun(long kmRun) {
        this.kmRun = kmRun;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeater() {
        return seater;
    }

    public void setSeater(int seater) {
        this.seater = seater;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

}
