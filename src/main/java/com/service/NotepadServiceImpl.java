package com.service;

import com.dao.NotepadDao;
import com.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NotepadServiceImpl implements NotepadService{

    @Autowired
    private NotepadDao notepadDao;

    @Override
    public List<Person> notepadList() {
        return notepadDao.notepadList();
    }

    @Override
    public List<Person> notepadListModify() {
            List<Person> notepadList = notepadDao.notepadList();
            return notepadList;
    }
    @Override
    public List<Person> addPersonToNotepadList(Person person){
        notepadDao.add(person);
        List<Person> notepadList = notepadDao.notepadList();
        return notepadList;
    }
    @Override
    public List<Person> deletePersonFromNotepadList(Person person){
        notepadDao.delete(person);
        return notepadDao.notepadList();
    }
}
