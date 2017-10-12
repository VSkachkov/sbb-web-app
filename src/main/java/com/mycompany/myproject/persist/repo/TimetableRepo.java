package com.mycompany.myproject.persist.repo;

import com.mycompany.myproject.persist.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableRepo extends JpaRepository<Timetable, Long> {


}