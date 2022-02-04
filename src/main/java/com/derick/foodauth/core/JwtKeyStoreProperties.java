package com.derick.foodauth.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
@Component
@ConfigurationProperties("application.keystore")
public class JwtKeyStoreProperties {

    @NotBlank
    private String jksResource;
    @NotBlank
    private String keyStorePass;
    @NotBlank
    private String keyPairAlias;

    public String getJksResource() {
        return jksResource;
    }

    public void setJksResource(String jksResource) {
        this.jksResource = jksResource;
    }

    public String getKeyStorePass() {
        return keyStorePass;
    }

    public void setKeyStorePass(String keyStorePass) {
        this.keyStorePass = keyStorePass;
    }

    public String getKeyPairAlias() {
        return keyPairAlias;
    }

    public void setKeyPairAlias(String keyPairAlias) {
        this.keyPairAlias = keyPairAlias;
    }
}
