package com.api.company.dto;

public class CompanyAppVersionDTO {

    private String codigoCompany;
    private String nameCompany;
    private String appName;
    private String version;

    public CompanyAppVersionDTO(String codigoCompany, String nameCompany, String appName, String version) {
        this.codigoCompany = codigoCompany;
        this.nameCompany = nameCompany;
        this.appName = appName;
        this.version = version;
    }

    public String getCodigoCompany() {
        return codigoCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public String getAppName() {
        return appName;
    }

    public String getVersion() {
        return version;
    }

}
