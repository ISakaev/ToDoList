package com.isakaev.todolist.service.Impl;

import com.isakaev.todolist.model.Action;
import com.isakaev.todolist.model.Person;
import com.isakaev.todolist.repository.ActionRepository;
import com.isakaev.todolist.repository.PersonRepository;
import com.isakaev.todolist.service.ActionService;
import com.isakaev.todolist.service.exception.NotFoundRecordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActionServiceImpl implements ActionService {

    private ActionRepository actionRepository;

    private PersonRepository personRepository;

    @Autowired
    public ActionServiceImpl(ActionRepository actionRepository, PersonRepository personRepository) {
        this.actionRepository = actionRepository;
        this.personRepository = personRepository;
    }

    @Override
    public List<Action> getActions() {
        Iterable<Action> actionIterable = actionRepository.findAll();
        List<Action> actionArrayList = new ArrayList<>();
        actionIterable.forEach(actionArrayList::add);
        return actionArrayList;
    }

    @Override
    public Action getAction(Integer id) {
        Optional<Action> newAction = actionRepository.findById(id);
        if (!newAction.isPresent()){
           throw new NotFoundRecordException("Person not found with id " + id);
        }
        return newAction.get();
    }

    @Override
    public Integer saveAction(Action action) {
        Action addAction = action;
        List<Action> actionList = actionRepository.findAll();
        if (actionList.contains(addAction)){
            return (actionList.indexOf(addAction) + 1);
        }
        List<Person> personList = personRepository.findAll();
        if (personList.size() > 0) {
            for (Person p : personList) {
                if (p.equals(addAction.getPerson())){
                    addAction.setPerson(p);
                }
            }
        }
        Action newAction = actionRepository.save(addAction);
        return newAction.getId();
    }

    @Override
    public Action updateActionById(Action newAction, Integer id) {
        Optional<Action> optionalAction = actionRepository.findById(id);
        if (!optionalAction.isPresent()){
            throw new NotFoundRecordException("Person not found with id " + id);
        }
        Action updateAction = optionalAction.get();
        updateAction.setDescription(newAction.getDescription());
        updateAction.setPerson(newAction.getPerson());
        actionRepository.save(updateAction);
        return updateAction;
    }

    @Override
    public void deleteActionById(Integer id) {
        actionRepository.deleteById(id);
    }

    @Override
    public void deleteAllActions() {
        actionRepository.deleteAll();
    }
}
