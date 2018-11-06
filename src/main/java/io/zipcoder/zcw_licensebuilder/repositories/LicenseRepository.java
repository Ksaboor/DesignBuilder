package io.zipcoder.zcw_licensebuilder.repositories;

import io.zipcoder.zcw_licensebuilder.domain.anthropoid.license.License;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 */
public interface LicenseRepository extends JpaRepository<License, Long> {
}
