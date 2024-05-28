package com.java100xdev.JobPortal.Company;

import java.sql.SQLException;
import java.util.List;

public interface CompanyService {
    List<Company> findAllCompanies() throws SQLException;

    Company getCompanybyId(int id);

    boolean deleteCompanybyId(int id);

    boolean addCompany(Company company);

    Company updateCompanybyId(Company company, int id);
}
