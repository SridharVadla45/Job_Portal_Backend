package com.java100xdev.JobPortal.job;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;


    @GetMapping("/jobs")
    public List<Job> getJobs() {
        return jobService.getJobs();
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return "Job added successfully ";
    }

    @GetMapping("/jobs/{id}")
    public Job getjob(@PathVariable int id) {
        return jobService.getJob(id);
    }

    @DeleteMapping("/jobs/{id}")
    public String deleteJob(@PathVariable int id) {

        return jobService.deleteJob(id) ? "Job Deleted Successfully " : "Not found Job with Provided id to delete ";
    }

    @PutMapping("/jobs/{id}")
    public String updateJob(@RequestBody  Job job,@PathVariable int id ){

      return jobService.updateJob(job,id) ? "Job updated successfully " : "Provide correct ID";
    }


}
