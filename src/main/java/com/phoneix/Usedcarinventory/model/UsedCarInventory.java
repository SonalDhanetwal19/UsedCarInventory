package com.phoneix.Usedcarinventory.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@Table(name = "UsedCarInventory")
public class UsedCarInventory implements Serializable {
    /** Serializable ID. */
    private static final long serialVersionUID = 1L;

    /** ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_Id", unique = true, nullable = false)
    private long carId;
    /*vehicle_type - hatchback/sedan*/
    @Column(name = "vehicle_type", length = 250, nullable = false)
    private String vehicleType;
    /*car_model - zxi/vxi*/
    @Column(name = "car_model", length = 250, nullable = false)
    private String model;
    /*car_comapny - car manufacturer - hyundai/ford*/
    @Column(name = "car_company", length = 250, nullable = false)
    private String company;
    /*car_price - price of used car*/
    @Column(name = "car_price",  nullable = false)
    private long price;
    /*car_name - figo/i20/i10*/
    @Column(name = "car_name", length = 250, nullable = false)
    private String carName;
    /*car_bhp*/
    @Column(name = "car_bhp", nullable = false)
    private int bhp;
    /*engine_Capacity - 1200cc*/
    @Column(name = "engine_capacity", length = 250, nullable = false)
    private String engineCapacity;
    /*car_mileage*/
    @Column(name = "car_mileage", nullable = false)
    private long mileage;
    /*car_km_run*/
    @Column(name = "car_km_run", nullable = false)
    private long kmRun;
    /*car_transmission - auto/manual*/
    @Column(name = "car_transmission", length = 250, nullable = false)
    private String transmission;
    /*car_color*/
    @Column(name = "car_color", length = 250, nullable = false)
    private String color;
    /*car_seater*/
    @Column(name = "car_seater", nullable = false)
    private int seater;
    /*car_seater*/
    @Column(name = "car_location", length = 250, nullable = false)
    private String location;
    /*car_version*/
    @Column(name = "car_version", length = 250, nullable = false)
    private String version;
    /*car_owner*/
    @Column(name = "car_owner", length = 250, nullable = false)
    private String owner;
    /*car_status - available/booked/SoldOut*/
    @Column(name = "car_status", length = 250, nullable = false)
    private String carStatus;
    /*date_Time*/
    @Column(name = "date_Time", nullable = false)
    private Timestamp dateTime;

    public UsedCarInventory(){
        super();
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
