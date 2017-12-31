package com.studiomediatech.contessa.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;


/**
 * The storage configuration to use for the Contessa service.
 */
@Validated
@ConfigurationProperties(prefix = "contessa.storage")
public class ContessaStorageConfigurationProperties {

    public enum StorageType {

        NONE,
        LOCAL,
        SQL,
        NOSQL;
    }

    /**
     * The storage type to use, may not be empty.
     */
    @NotNull
    private StorageType type;

    /**
     * The base directory used by the {@link StorageType#LOCAL local} storage type.
     */
    private String baseDir;

    public StorageType getType() {

        return type;
    }


    public void setType(StorageType type) {

        this.type = type;
    }


    public String getBaseDir() {

        return baseDir;
    }


    public void setBaseDir(String baseDir) {

        this.baseDir = baseDir;
    }
}
