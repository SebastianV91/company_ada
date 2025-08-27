package com.api.company.dto;

public class CompanyDTO {

    private String codigo_company;
    private String name_company;
    private String description_company;

    public CompanyDTO() {
    }

    public CompanyDTO(String codigo_company, String name_company, String description_company) {
        this.codigo_company = codigo_company;
        this.name_company = name_company;
        this.description_company = description_company;
    }

    public String getCodigo_company() {
        return codigo_company;
    }

    public void setCodigo_company(String codigo_company) {
        this.codigo_company = codigo_company;
    }

    public String getName_company() {
        return name_company;
    }

    public void setName_company(String name_company) {
        this.name_company = name_company;
    }

    public String getDescription_company() {
        return description_company;
    }

    public void setDescription_company(String description_company) {
        this.description_company = description_company;
    }

}
