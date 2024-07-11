package com.Flask.Spring.postgres.Angular.Spring.service;

import com.Flask.Spring.postgres.Angular.Spring.entity.Count;
import com.Flask.Spring.postgres.Angular.Spring.repository.CountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CountService {

    @Autowired
    private CountRepository countRepository;

    public void saveAll(List<Count> counts) {
        countRepository.saveAll(counts);
    }

    public List<Count> findAll() {
        return countRepository.findAll();
    }



}
