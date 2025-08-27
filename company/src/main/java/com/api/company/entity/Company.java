package com.api.company.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompany;

    private String codigoCompany;

    private String nameCompany;

    private String descriptionCompany;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VersionCompany> versionCompanies;

    public Company() {
    }

    public Company(String codigoCompany, String nameCompany, String descriptionCompany) {
        this.codigoCompany = codigoCompany;
        this.nameCompany = nameCompany;
        this.descriptionCompany = descriptionCompany;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
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

    public Set<VersionCompany> getVersionCompanies() {
        return versionCompanies;
    }

    public void setVersionCompanies(Set<VersionCompany> versionCompanies) {
        this.versionCompanies = versionCompanies;
    }

}
