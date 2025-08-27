package com.api.company.controller;

import com.api.company.dto.CompanyDTO;
import com.api.company.dto.Mensaje;
import com.api.company.entity.Company;
import com.api.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CompanyDTO companyDTO){

        Company company = new Company(companyDTO.getCodigo_company(), companyDTO.getName_company(), companyDTO.getDescription_company());
        companyService.save(company);
        return new ResponseEntity(new Mensaje("Compania agregada"), HttpStatus.CREATED);
    }

}
