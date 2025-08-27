package com.api.company.service;

import com.api.company.dto.CompanyAppVersionDTO;
import com.api.company.entity.Company;
import com.api.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Optional<Company> findById(Integer id) {
        return companyRepository.findById(id);
    }

    public void save(Company company){
         companyRepository.save(company);
    }

    public void delete(Integer id) {
        companyRepository.deleteById(id);
    }

    public List<CompanyAppVersionDTO> getCompanyAppVersions(String codigoCompany) {
        return companyRepository.findCompanyAppVersions(codigoCompany);
    }

}
