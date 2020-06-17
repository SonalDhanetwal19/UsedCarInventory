package com.phoneix.Usedcarinventory.service;

import com.phoneix.Usedcarinventory.Exception.ResourceNotFoundException;
import com.phoneix.Usedcarinventory.model.UsedCarInventory;

import java.util.List;
import java.util.Optional;

public interface UsedCarServiceInterface {
    List<UsedCarInventory> getAllCars();
    Optional<UsedCarInventory> getEachCarId(long carId);
    void addUsedCarInv(UsedCarInventory usedCarInventory);
    UsedCarInventory updateUsedCarInfo(UsedCarInventory usedCarInventory, long carId);
    void deleteUsedCarInfo(long carId);
}
