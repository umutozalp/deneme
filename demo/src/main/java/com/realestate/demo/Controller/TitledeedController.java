package com.realestate.demo.Controller;


import com.realestate.demo.Entity.Titledeed;
import com.realestate.demo.Service.TitledeedService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/titledeed")
public class TitledeedController {


    TitledeedService titledeedService;


    public TitledeedController(TitledeedService titledeedService) {
        this.titledeedService = titledeedService;
    }

    @GetMapping("{id}")
    public Titledeed getTitledeed(@PathVariable int id)
    {
        return titledeedService.getTitledeed(id);
    }

    @GetMapping
    public List<Titledeed> getAllTitledeed()
    {
        return titledeedService.getAllTitledeed();
    }

    @PostMapping
    public Titledeed createTitledeed(@RequestBody Titledeed titledeed)
    {
        titledeedService.createTitledeed(titledeed);

        return titledeedService.getTitledeed(titledeed.getId());
    }
    @PutMapping
    public String updateTitledeed(@RequestBody Titledeed titledeed)
    {
        titledeedService.updateTitledeed(titledeed);
        return "Titledeed updated Successfully";
    }
@DeleteMapping("{id}")
    public String deleteTitledeed(@PathVariable("id") int id) {
        titledeedService.deleteTitledeed(id);
    return "Titledeed deleted Successfully";
}
}
