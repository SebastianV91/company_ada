package com.api.company.dto;

public class CompanyDTO {

    private String codigoCompany;
    private String nameCompany;
    private String descriptionCompany;

    public CompanyDTO() {
    }

    public CompanyDTO(String codigoCompany, String nameCompany, String descriptionCompany) {
        this.codigoCompany = codigoCompany;
        this.nameCompany = nameCompany;
        this.descriptionCompany = descriptionCompany;
    }

    public String getCodigoCompany() {
        return codigoCompany;
    }

    public void setCodigoCompany(String codigoCompany) {
        this.codigoCompany = codigoCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getDescriptionCompany() {
        return descriptionCompany;
    }

    public void setDescriptionCompany(String descriptionCompany) {
        this.descriptionCompany = descriptionCompany;
    }

}
