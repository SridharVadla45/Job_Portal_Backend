package com.java100xdev.JobPortal.Company;

import com.java100xdev.JobPortal.job.Job;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Company_Details")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int companyId;
    String companyName;

    public Company() {
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
