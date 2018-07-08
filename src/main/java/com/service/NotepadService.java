package com.service;


import com.model.Person;
import java.util.List;

public interface NotepadService {

    List<Person> notepadList();

    List<Person> notepadListModify();

    List<Person> addPersonToNotepadList(Person person);

    List<Person> deletePersonFromNotepadList(Person person);
}
