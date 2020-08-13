package com.nataraj.management.auction.pdms;

import com.nataraj.management.auction.pdms.config.DbConfig;
import com.nataraj.management.auction.pdms.config.WebConfig;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


public class ConfigSelector implements ImportSelector{

    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{DbConfig.class.getName(), WebConfig.class.getName()};
    }
}
