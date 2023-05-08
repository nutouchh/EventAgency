package com.nutouchh.EventAgency.dao.repositories;

import com.nutouchh.EventAgency.dao.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findEventByTitle(String title);
}
