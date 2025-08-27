package com.api.company.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "version")
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "version_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "app_id", nullable = false)
    private Application application;

    @Column(name = "version", nullable = false)
    private String version;

    @Column(name = "version_description")
    private String versionDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersionDescription() {
        return versionDescription;
    }

    public void setVersionDescription(String versionDescription) {
        this.versionDescription = versionDescription;
    }

}
