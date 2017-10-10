package com.mycompany.myproject.persist.repo;

import com.mycompany.myproject.persist.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrainRepo extends JpaRepository<Train, Long> {

}
