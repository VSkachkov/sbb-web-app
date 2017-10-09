package com.mycompany.myproject.persist.repo;

import com.mycompany.myproject.persist.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepo  extends JpaRepository<Station, Long> {

}
