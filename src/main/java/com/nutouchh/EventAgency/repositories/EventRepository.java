package com.nutouchh.EventAgency.repositories;

import com.nutouchh.EventAgency.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findEventByTitle(String title);

//    Long findIdByTitle(String eventTitle);
//    Event findEventByTitle(String title);
//    Long findIdByTitle(String title);

//    Optional<Object> findByTitle(String eventTitle);

//    Long findEventIdByTitle(String title);
}