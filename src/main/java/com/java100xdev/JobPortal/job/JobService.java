package com.java100xdev.JobPortal.job;

import java.util.List;

public interface JobService {
    List<Job> getJobs();
    void createJob(Job job);
    Job getJob(int id);
    boolean deleteJob(int id);
    boolean updateJob(Job job,int id);
}
