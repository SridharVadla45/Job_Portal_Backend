package com.java100xdev.JobPortal.job.impl;

import com.java100xdev.JobPortal.job.Job;
import com.java100xdev.JobPortal.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> getJobs() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(jobs.size() + 1);
        jobs.add(job);
    }

    @Override
    public Job getJob(int id) {

        Optional<Job> optionalJob = jobs.stream().filter(job -> job.getId() == id).findFirst();

        return optionalJob.orElse(null);
    }

    @Override
    public boolean deleteJob(int id) {
        return jobs.removeIf(job -> job.getId() == id);
    }

    @Override
    public boolean updateJob(Job job, int id) {
        Optional<Job> optionalJob = jobs.stream().filter(job1 -> job1.getId() == id).findFirst();
        if (optionalJob.isPresent()) {
            Job job1 = optionalJob.get();
            job1.setTitle(job.getTitle());
            job1.setJobDescription((job.getJobDescription()));
            job1.setLocation(job.getLocation());
            job1.setMinSalary(job.getMinSalary());
            job1.setMaxSalary(job.getMaxSalary());
            return true;

        }
        return false;
    }
}
