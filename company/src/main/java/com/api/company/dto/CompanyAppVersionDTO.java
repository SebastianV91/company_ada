package com.api.company.dto;

public class CompanyAppVersionDTO {

    private String codigo_company;
    private String name_company;
    private String app_name;
    private String version;

    public CompanyAppVersionDTO(String codigo_company, String name_company, String app_name, String version) {
        this.codigo_company = codigo_company;
        this.name_company = name_company;
        this.app_name = app_name;
        this.version = version;
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

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
