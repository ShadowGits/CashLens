package com.aistuff.service;

import com.aistuff.config.BankStmtYAMLtoJAVAConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Component
public class BankMappingLoader {

    private final Map<String, BankStmtYAMLtoJAVAConfig> CACHE = new HashMap<>();
    private final ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

    public BankStmtYAMLtoJAVAConfig load(String bankName){
        return CACHE.computeIfAbsent(bankName.toLowerCase(), this::loadFromYAML);
    }

    private BankStmtYAMLtoJAVAConfig loadFromYAML(String bank_name) {

        try{
            String filename = "bank_statements_yamls/" + bank_name + ".yaml";
            InputStream is = getClass().getClassLoader().getResourceAsStream(filename);

            if(is == null)
            {
                throw new RuntimeException("No YAML mapping found for bank : "+bank_name);
            }

            return yamlMapper.readValue(is, BankStmtYAMLtoJAVAConfig.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load YAML mapping for bank : "+bank_name, e);
        }

    }
}
