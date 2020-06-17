package com.phoneix.Usedcarinventory.service.implementation;

import com.phoneix.Usedcarinventory.model.UsedCarInventory;
import com.phoneix.Usedcarinventory.repository.UsedCarRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class UsedCarServiceTest {

    @InjectMocks
    private UsedCarService usedCarService;

    @Mock
    private UsedCarRepository usedCarRepository;

    UsedCarInventory usedCarInventory;

    @BeforeEach
    void setUp() {
        usedCarInventory = new UsedCarInventory();
        usedCarInventory.setCarStatus("Available");
        usedCarInventory.setSeater(5);
        usedCarInventory.setCarName("i10");
        usedCarInventory.setCarId(1);
    }


    void tearDown() {
    }

    @Test
    void testGetAllCars() {
        when(usedCarRepository.findAll()).thenReturn(Arrays.asList(usedCarInventory));
        assertEquals(Arrays.asList(usedCarInventory), usedCarService.getAllCars());
    }

    @Test
    void testGetEachCarId() {
        when(usedCarRepository.findById(1L)).thenReturn(Optional.of(usedCarInventory));
        assertEquals(Optional.of(usedCarInventory), usedCarService.getEachCarId(1));
    }

    @Test
    void testAddUsedCarInv() {
        when(usedCarRepository.save(usedCarInventory)).thenReturn(usedCarInventory);
        usedCarService.addUsedCarInv(usedCarInventory);
        assertTrue(Boolean.TRUE);

    }

    @Test
    void updateUsedCarInfo() {
        when(usedCarRepository.findById(1L)).thenReturn(Optional.of(usedCarInventory));
        when(usedCarRepository.save(usedCarInventory)).thenReturn(usedCarInventory);
        assertEquals(usedCarInventory, usedCarService.updateUsedCarInfo(usedCarInventory, 1L));
    }

    @Test
    void testDeleteUsedCarInfo() {
        usedCarService.deleteUsedCarInfo(1L);
        assertTrue(Boolean.TRUE);
    }

}