package com.controller;

import com.checkData.CheckData;
import com.model.Person;
import com.service.NotepadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/")
public class NotepadController {
    private String errorMessage=null;

    @Autowired
    private NotepadService notepadService;

    @RequestMapping(method = RequestMethod.GET)
    public String getNotepadList(Model model) {
        model.addAttribute("notepadList", notepadService.notepadList());
        model.addAttribute("notepadListModify", notepadService.notepadListModify());
        model.addAttribute("errorPhone", errorMessage);
        return "notepad";
    }

    @RequestMapping(value = "modify", method = RequestMethod.GET)
    public String serviceStudent(@ModelAttribute Person person, HttpServletRequest req) {
        if (CheckData.checkPhone(person) == 0) {
            if (req.getParameter("add") != null) {
                notepadService.addPersonToNotepadList(person);
            }
            if (req.getParameter("del") != null) {
                notepadService.deletePersonFromNotepadList(person);
            }
        } else {
           errorMessage="Phone number is wrong!";
        }
        return "redirect:/";
    }
}
