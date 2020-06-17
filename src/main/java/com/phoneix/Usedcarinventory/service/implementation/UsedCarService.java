package com.phoneix.Usedcarinventory.service.implementation;

import com.phoneix.Usedcarinventory.Exception.ResourceNotFoundException;
import com.phoneix.Usedcarinventory.model.UsedCarInventory;
import com.phoneix.Usedcarinventory.repository.UsedCarRepository;
import com.phoneix.Usedcarinventory.service.UsedCarServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Temporal;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsedCarService implements UsedCarServiceInterface {

    @Autowired
    UsedCarRepository usedCarRepository;

    @Override
    public List<UsedCarInventory> getAllCars() {
    List usedCarList = new ArrayList();
    usedCarRepository.findAll().forEach(usedCarList::add);
    return usedCarList;
    }

    @Override
    public Optional<UsedCarInventory> getEachCarId(long carId) {
    return usedCarRepository.findById(carId);
    }

    @Override
    @Transactional
    public void addUsedCarInv(UsedCarInventory usedCarInventory) {
        Timestamp t= new Timestamp(System.currentTimeMillis());
        usedCarInventory.setDateTime(t);
        usedCarRepository.save(usedCarInventory);
    }

    @Override
    public UsedCarInventory updateUsedCarInfo(UsedCarInventory usedCarInventory, long carId) {
            Optional<UsedCarInventory> getCarForUpdate= usedCarRepository.findById(carId);
            Timestamp t = new Timestamp(System.currentTimeMillis());
            UsedCarInventory usedCarUdpate = getCarForUpdate.get();
            usedCarUdpate.setDateTime(t);
            usedCarUdpate.setBhp(usedCarInventory.getBhp());
            usedCarUdpate.setCarName(usedCarInventory.getCarName());
            usedCarUdpate.setColor(usedCarInventory.getColor());
            usedCarUdpate.setCompany(usedCarInventory.getCompany());
            usedCarUdpate.setEngineCapacity(usedCarInventory.getEngineCapacity());
            usedCarUdpate.setKmRun(usedCarInventory.getKmRun());
            usedCarUdpate.setLocation(usedCarInventory.getLocation());
            usedCarUdpate.setMileage(usedCarInventory.getMileage());
            usedCarUdpate.setModel(usedCarInventory.getModel());
            usedCarUdpate.setOwner(usedCarInventory.getOwner());
            usedCarUdpate.setTransmission(usedCarInventory.getTransmission());
            usedCarUdpate.setPrice(usedCarInventory.getPrice());
            usedCarUdpate.setSeater(usedCarInventory.getSeater());
            usedCarUdpate.setVehicleType(usedCarInventory.getVehicleType());
            usedCarUdpate.setVersion(usedCarInventory.getVersion());
            usedCarUdpate.setCarStatus(usedCarInventory.getCarStatus());
            final UsedCarInventory updatedCar = usedCarRepository.save(usedCarUdpate);
            return updatedCar;
    }

    @Override
    public void deleteUsedCarInfo(long carId) {
        usedCarRepository.deleteById(carId);
    }
}
