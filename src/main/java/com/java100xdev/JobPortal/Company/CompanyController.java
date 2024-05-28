package com.java100xdev.JobPortal.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> findAll() throws SQLException {
        return new ResponseEntity<>(companyService.findAllCompanies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable int id) {
        Company company = companyService.getCompanybyId(id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteCompany(@PathVariable int id) {
        if (companyService.deleteCompanybyId(id)) {
            return new ResponseEntity<>("Successfully Deleted Company ", HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //post company
    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        if(companyService.addCompany(company)){
            return  new ResponseEntity<>("Company details added successfully",HttpStatus.CREATED);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company,  @PathVariable  int id){
       Company company1= companyService.updateCompanybyId(company,id);
       if(company1!=null){
           return  new ResponseEntity<>(company1,HttpStatus.OK);
       }
       return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
