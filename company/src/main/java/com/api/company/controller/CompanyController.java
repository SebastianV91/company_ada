package com.api.company.controller;

import com.api.company.dto.CompanyAppVersionDTO;
import com.api.company.dto.CompanyDTO;
import com.api.company.dto.Mensaje;
import com.api.company.entity.Company;
import com.api.company.service.CompanyService;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAll() {
        return companyService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CompanyDTO companyDTO) {

        if(StringUtils.isBlank(companyDTO.getNameCompany()))
            return new ResponseEntity(new Mensaje("El Nombre de la compania es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(companyDTO.getCodigoCompany()))
            return new ResponseEntity(new Mensaje("El Codigo de la compania es obligatorio"), HttpStatus.BAD_REQUEST);

        Company company = new Company(companyDTO.getNameCompany(), companyDTO.getCodigoCompany(), companyDTO.getDescriptionCompany());
         companyService.save(company);
         return new ResponseEntity<>(new Mensaje("Compania creada."), HttpStatus.OK);
    }

    @GetMapping("/{codigoCompany}/versions")
    public List<CompanyAppVersionDTO> getCompanyAppVersions(@PathVariable String codigoCompany) {
        return companyService.getCompanyAppVersions(codigoCompany);
    }

}
