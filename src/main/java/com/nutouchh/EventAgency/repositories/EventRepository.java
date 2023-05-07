package com.nutouchh.EventAgency.repositories;

import com.nutouchh.EventAgency.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findEventByTitle(String title);
}
