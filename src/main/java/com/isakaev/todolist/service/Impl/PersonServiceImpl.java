package com.isakaev.todolist.service.Impl;

import com.isakaev.todolist.model.Person;
import com.isakaev.todolist.repository.PersonRepository;
import com.isakaev.todolist.service.PersonService;
import com.isakaev.todolist.service.exception.NotFoundRecordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public List<Person> getPersons() {
        Iterable<Person> personIterable = personRepository.findAll();
        List<Person> personArrayList = new ArrayList<>();
        personIterable.forEach(personArrayList::add);
        return  personArrayList;
    }

    @Override
    public Person getPerson(Integer id) {
        Optional<Person> newPerson = personRepository.findById(id);
        if (!newPerson.isPresent()){
            throw new NotFoundRecordException("Person not found with id " + id);
        }
            return newPerson.get();

    }

    @Override
    public Integer savePerson(Person person) {
        List<Person> personList = personRepository.findAll();
           if (personList.size() > 0){
            for (Person p: personList){
                if (p.equals(person)){
                    return p.getId();
                }
            }
        }
        Person newPerson = personRepository.save(person);
        return newPerson.getId();
    }

    @Override
    public Person updatePersonById(Person person, Integer id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (!optionalPerson.isPresent()){
            throw new NotFoundRecordException("Person not found with id " + id);
        }
        Person updatePerson = optionalPerson.get();
        updatePerson.setName(person.getName());
        updatePerson.setPhone(person.getPhone());
        updatePerson.setAddress(person.getAddress());
        return personRepository.save(updatePerson);

    }

    @Override
    public void deletePersonById(Integer id) {
        personRepository.deleteById(id);
    }

    @Override
    public void deleteAllPersons() {
        personRepository.deleteAll();
    }
}
