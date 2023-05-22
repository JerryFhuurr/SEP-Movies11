package com.movie.movies11.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.movie.movies11.models.People;
import com.movie.movies11.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/people/")
public class PeopleController {
    @Autowired
    PeopleService peopleService;

    @GetMapping("getAll")
    public Object getAllPeople(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<People> peopleList = peopleService.getAllPeople();
        return new PageInfo<>(peopleList);
    }

    @GetMapping("getSome")
    public Object getPeopleByIdOrName(int id, String name) {
        return peopleService.getPeople(id, name);
    }

    @GetMapping("getDirector")
    public People getDirector(@RequestParam String movieTitle) {
        return peopleService.getDirector(movieTitle);
    }

    @GetMapping("getActors")
    public Object getActorsByMovie(@RequestParam String movieTitle, @RequestParam int pageNum, @RequestParam int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<People> peopleList = peopleService.getActorsByMovie(movieTitle);
        return new PageInfo<>(peopleList);
    }
}
