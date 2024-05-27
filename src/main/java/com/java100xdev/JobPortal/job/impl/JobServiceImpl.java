package com.java100xdev.JobPortal.job.impl;

import com.java100xdev.JobPortal.job.Job;
import com.java100xdev.JobPortal.job.JobRepository;
import com.java100xdev.JobPortal.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;


    @Override
    public List<Job> getJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJob(int id) {
        jobRepository.findById(id);

        Optional<Job> optionalJob = jobRepository.findById(id);

        return optionalJob.orElse(null);
    }

    @Override
    public boolean deleteJob(int id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean updateJob(Job job, int id) {
        try {
            Optional<Job> optionalJob = jobRepository.findById(id);
            if (optionalJob.isPresent()) {
                Job job1 = optionalJob.get();
                job1.setTitle(job.getTitle());
                job1.setJobDescription((job.getJobDescription()));
                job1.setLocation(job.getLocation());
                job1.setMinSalary(job.getMinSalary());
                job1.setMaxSalary(job.getMaxSalary());
                jobRepository.save(job1);
                return true;

            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }
}
