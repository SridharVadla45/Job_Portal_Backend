package com.java100xdev.JobPortal.job;

public class Job {

    private int id;
    private String title;
    private String jobDescription;
    private String location;
    private int minSalary;
    private int maxSalary;

    public Job(int id, String title, String jobDescription, String location, int minSalary, int maxSalary) {
        this.id = id;
        this.title = title;
        this.jobDescription = jobDescription;
        this.location = location;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }


}
