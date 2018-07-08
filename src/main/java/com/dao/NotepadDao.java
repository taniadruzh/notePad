package com.dao;

import com.model.Person;

import java.util.List;

public interface NotepadDao {
    List<Person> notepadList();
    void add(Person person);
    void delete(Person person);
}
