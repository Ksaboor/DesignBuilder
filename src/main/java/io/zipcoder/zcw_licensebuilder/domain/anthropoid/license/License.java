package io.zipcoder.zcw_licensebuilder.domain.anthropoid.license;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 */
@Entity
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
