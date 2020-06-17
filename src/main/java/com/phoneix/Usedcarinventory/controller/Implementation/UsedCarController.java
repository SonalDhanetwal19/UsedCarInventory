package com.phoneix.Usedcarinventory.controller.Implementation;

import com.phoneix.Usedcarinventory.Exception.ResourceNotFoundException;
import com.phoneix.Usedcarinventory.controller.UsedCarControllerInterface;
import com.phoneix.Usedcarinventory.model.UsedCarInventory;
import com.phoneix.Usedcarinventory.service.implementation.UsedCarService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is controller class for UsedCar API. This class will have all the
 * operations to add,list,update and delete for Used cars of different variants.
 *
 */

@RestController
@RequestMapping("/api/v1")
@Api(
        value = "UsedCar Service API",
        tags = "UsedCar Service API",
        description = "UsedCar Service API provides operations to add,list,update and delete Used cars of different variants"
)

public class UsedCarController implements UsedCarControllerInterface {

    private Logger logger = LoggerFactory.getLogger(UsedCarController.class);

    /** UsedCarService instance */
    @Autowired
    private UsedCarService usedCarService;

    public UsedCarController()
    {
        super();
    }

        /** fetches the list of available used cars**/
    @ApiOperation(
            value = "Get List of used cars", response = List.class)
    @ApiResponses(
            value = { @ApiResponse(code = 200, message = "Success"),
                      @ApiResponse(code = 400, message = "Token not found"),
                      @ApiResponse(code = 401, message = "not authorized!"),
                      @ApiResponse(code = 403, message = "forbidden!!!"),
                      @ApiResponse(code = 404, message = "not found!!!"),
                      @ApiResponse(code = 500, message = "Internal server error")})

    @Override
    @GetMapping("/usedCars")
    public List<UsedCarInventory> getCarList()
    {
        logger.info("getCarList");
        return usedCarService.getAllCars();
    }

    /** fetches the used car by Id **/
    @ApiOperation(value = "Get specific Car By carId in the System ", response = UsedCarInventory.class)
    @GetMapping("/usedCars/{carId}")
    public ResponseEntity <UsedCarInventory> getCarListId(
            @ApiParam(value = "Employee id from which employee object will retrieve", required = true)
            @PathVariable (value = "carId")long carId) throws ResourceNotFoundException
    {
        logger.info("getCarListId");
        UsedCarInventory usedCarInventory = usedCarService.getEachCarId(carId)
                .orElseThrow(()-> new ResourceNotFoundException("UsedCar Id not found :: " + carId));
        return ResponseEntity.ok().body(usedCarInventory);
    }

    /** adds a new used car in the usedcarinventory **/
    @ApiOperation(value = "Add used car")
    @Override
    @PostMapping("/usedCars")
    public void addUsedCar(@ApiParam(value = "UsedCar object store in database table", required = true)
                               @RequestBody UsedCarInventory usedCarInventory)
    {
        logger.info("addUsedCar");
        usedCarService.addUsedCarInv(usedCarInventory);
    }

    /** updates features and availability of an existing used cars
     * @return**/
    @ApiOperation(value = "Update UsedCar")
    @Override
    @PutMapping("/usedCars/{carId}")
    public ResponseEntity<UsedCarInventory> updateCarInfo(
            @ApiParam(value = "Update Used car object", required = true)
            @RequestBody UsedCarInventory usedCarInventory,
            @ApiParam(value = "CarId to update Used car object", required = true)
            @PathVariable(value = "carId") long carId) throws ResourceNotFoundException {
            logger.info("updateCarInfo");
            final UsedCarInventory updatedUsedCar = usedCarService.updateUsedCarInfo(usedCarInventory,carId);
            if(updatedUsedCar!= null) {
                return ResponseEntity.ok().body(updatedUsedCar);
            }
            else
                return ResponseEntity.notFound().build();
     }

    /** deletes record used car **/
    @ApiOperation(value = "Delete record of UsedCar")
    @Override
    @DeleteMapping("/usedCars/{carId}")
    public Map< String, Boolean > deleteUsedCar(
            @ApiParam(value = "carId that UsedCar object will delete from database table", required = true)
            @PathVariable(value = "carId") long carId) throws ResourceNotFoundException
    {
        logger.info("deleteUsedCar");
        usedCarService.deleteUsedCarInfo(carId);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
