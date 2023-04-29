package com.nutouchh.EventAgency.services;

import com.nutouchh.EventAgency.models.Action;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActionService {

    private List<Action> actions = new ArrayList<>();
    private long ID = 0;

    {
        actions.add(new Action(++ID, "Выездная регистрация", "лялялялял", 20000));
        actions.add(new Action(++ID, "Ведущий", "лялялялял", 55000));
    }

    public List<Action> getActions() {
        return actions;
    }

    public void saveAction(Action action){
        action.setId(++ID);
        actions.add(action);
    }

    public void deleteAction(Long id){
        actions.removeIf(action -> action.getId().equals(id));
    }

    public Action getActionById(Long id) {
        for (Action action : actions) {
            if (action.getId().equals(id)) return action;
        }
        return null;
    }
}
