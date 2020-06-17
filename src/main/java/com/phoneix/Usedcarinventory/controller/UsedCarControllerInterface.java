package com.phoneix.Usedcarinventory.controller;

import com.phoneix.Usedcarinventory.Exception.ResourceNotFoundException;
import com.phoneix.Usedcarinventory.model.UsedCarInventory;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public interface UsedCarControllerInterface {

    @GetMapping("/carList")
    List<UsedCarInventory> getCarList();

    @GetMapping("/carListById/{carId}")
    ResponseEntity <UsedCarInventory> getCarListId(
            @ApiParam(value = "Employee id from which employee object will retrieve", required = true)
            @PathVariable (value = "carId")long carId) throws ResourceNotFoundException;

    @PostMapping("/addUsedCar")
    void addUsedCar(@ApiParam(value = "UsedCar object store in database table", required = true)
                    @RequestBody UsedCarInventory usedCarInventory);

    @PutMapping("/updateUsedCar/{carId}")
    ResponseEntity<UsedCarInventory> updateCarInfo(
            @ApiParam(value = "Update Used car object", required = true)
            @RequestBody UsedCarInventory usedCarInventory,
            @ApiParam(value = "CarId to update Used car object", required = true)
            @PathVariable(value = "carId") long carId) throws ResourceNotFoundException;

    @DeleteMapping("/deleteUsedCar/{carId}")
    Map< String, Boolean > deleteUsedCar(
            @ApiParam(value = "carId that UsedCar object will delete from database table", required = true)
            @PathVariable(value = "carId") long carId) throws ResourceNotFoundException;
}
