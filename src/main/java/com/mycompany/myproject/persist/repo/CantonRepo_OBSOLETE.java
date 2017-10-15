package com.mycompany.myproject.persist.repo;

import com.mycompany.myproject.persist.entity.Canton;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CantonRepo extends JpaRepository<Canton, Long> {

}