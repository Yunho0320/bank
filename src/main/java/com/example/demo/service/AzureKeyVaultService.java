//package com.example.demo.service;
//
//
//import com.azure.security.keyvault.secrets.SecretClient;
//import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AzureKeyVaultService {
//
//    @Autowired
//    private SecretClient secretClient;
//
//    @PostConstruct
//    public void fetchSecretOnStartup() {
//        String secretName = "API-KEY";
//        String secretValue = getSecret(secretName);
//
//        System.out.println("Secret fetched at startup: " + secretValue);
//    }
//
//
//    public String getSecret(String secretName) {
//        KeyVaultSecret secret = secretClient.getSecret(secretName);
//        System.out.println("Secret fetched = " + secret.getValue());
//        return secret.getValue();
//    }
//}
