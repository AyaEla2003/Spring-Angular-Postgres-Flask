package com.Flask.Spring.postgres.Angular.Spring.controller;

import com.Flask.Spring.postgres.Angular.Spring.entity.Count;
import com.Flask.Spring.postgres.Angular.Spring.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CountController {
    @Autowired
    private CountService countService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/saveCounts")
    public String saveClassification(@RequestBody List<Count> counts) {
        countService.saveAll(counts);
        return "Classification results saved successfully";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getCounts")
    public List<Count> getCounts() {
        return countService.findAll();
    }
}
