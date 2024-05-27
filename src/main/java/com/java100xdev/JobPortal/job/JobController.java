package com.java100xdev.JobPortal.job;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;


    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getJobs() {
        return new ResponseEntity<>(jobService.getJobs(), HttpStatus.OK);
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        try {
            jobService.createJob(job);
            return new ResponseEntity<>("Added job Successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getjob(@PathVariable int id) {
        Job job = jobService.getJob(id);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable int id) {
        try {
            if (jobService.deleteJob(id)) {
                return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@RequestBody Job job, @PathVariable int id) {
        try {
            if (jobService.updateJob(job, id)) {
                return new ResponseEntity<>("Job Updated Successfully ", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Provide Correct ID", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }


}
