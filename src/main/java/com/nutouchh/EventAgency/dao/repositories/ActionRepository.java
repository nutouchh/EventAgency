package com.nutouchh.EventAgency.dao.repositories;

import com.nutouchh.EventAgency.dao.models.Action;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActionRepository extends JpaRepository<Action, Long> {
    List<Action> findActionByTitle(String title);
}
