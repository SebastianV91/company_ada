package com.api.company.service;

import com.api.company.entity.Company;
import com.api.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Company save(Company company){
        return companyRepository.save(company);
    }

}
