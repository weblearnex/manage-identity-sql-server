package com.notes.controller;

import com.notes.entity.Notes;
import com.notes.repository.NotesRepository;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class NotesController {
    private Parser parser;
    private HtmlRenderer renderer;
    @Autowired
    NotesRepository notesRepository;

    @PostConstruct
    void initialize(){
        parser = Parser.builder().build();
        renderer = HtmlRenderer.builder().build();
    }

    @GetMapping("/")
    public ModelAndView load() {
        ModelAndView modelAndView = new ModelAndView("notes");
        List<Notes> notes = notesRepository.findAll();
        modelAndView.addObject("userNotes", notes);
        return modelAndView;
    }

    @PostMapping("/note")
    public String save(@RequestParam String markdownText) {
        Node document = parser.parse(markdownText);
        String html= renderer.render(document);
        Notes note = new Notes();
        note.setMessage(html);
        notesRepository.save(note);
        return "redirect:/";
    }
}