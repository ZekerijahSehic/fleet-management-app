package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.JobTitle;
import com.zekerijah.fleetmanagement.repository.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository;

    public List<JobTitle> getAllJobTitle(){
        return jobTitleRepository.findAll();
    }

    public JobTitle save(JobTitle jobTitle){
        return jobTitleRepository.save(jobTitle);
    }

    public Optional<JobTitle> findById(int id){
        return jobTitleRepository.findById(id);
    }

    public void delte(int id){
        jobTitleRepository.deleteById(id);
    }
}
