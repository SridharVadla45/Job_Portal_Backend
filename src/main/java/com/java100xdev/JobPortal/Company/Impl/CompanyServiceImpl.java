package com.java100xdev.JobPortal.Company.Impl;

import com.java100xdev.JobPortal.Company.Company;
import com.java100xdev.JobPortal.Company.CompanyRepository;
import com.java100xdev.JobPortal.Company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAllCompanies() throws SQLException {
        try {
            return companyRepository.findAll();
        } catch (Exception e) {
            throw new SQLException();
        }

    }

    @Override
    public Company getCompanybyId(int id) {

        Optional<Company> optionalCompany = companyRepository.findById(id);

        return optionalCompany.orElse(null);
    }

    @Override
    public boolean deleteCompanybyId(int id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addCompany(Company company) {
        try {
            companyRepository.save(company);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Company updateCompanybyId(Company company, int id) {
        try{
           Optional<Company> optionalCompany= companyRepository.findById(id);
           if(optionalCompany.isPresent()){
               Company company1=optionalCompany.get();
               company1.setCompanyName(company.getCompanyName());
               companyRepository.save(company1);
               return company1;
           }
        }catch (Exception e){
           return null;
        }
        return null;
    }
}
