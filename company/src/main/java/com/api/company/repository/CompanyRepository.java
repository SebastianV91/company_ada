package com.api.company.repository;

import com.api.company.dto.CompanyAppVersionDTO;
import com.api.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    boolean existsByCodigoCompany(String codigoCompany);

    boolean existsByNameCompany(String nameCompany);

    @Query("SELECT new com.api.company.dto.CompanyAppVersionDTO(c.codigoCompany, c.nameCompany, a.appName, v.version) " +
            "FROM Company c " +
            "JOIN VersionCompany vc ON vc.company = c " +
            "JOIN Version v ON v = vc.version " +
            "JOIN Application a ON a = v.application " +
            "WHERE c.codigoCompany = :codigoCompany")
    List<CompanyAppVersionDTO> findCompanyAppVersions(@Param("codigoCompany") String codigoCompany);

}
