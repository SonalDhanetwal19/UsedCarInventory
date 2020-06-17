package com.phoneix.Usedcarinventory.repository;

import com.phoneix.Usedcarinventory.model.UsedCarInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsedCarRepository extends JpaRepository<UsedCarInventory,Long> {


}
