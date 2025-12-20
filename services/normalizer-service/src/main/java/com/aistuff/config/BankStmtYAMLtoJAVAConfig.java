package com.aistuff.config;

import java.util.Map;

public class BankStmtYAMLtoJAVAConfig {

    private String bank_name;
    private Map<String,String> mappings;

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public Map<String, String> getMappings() {
        return mappings;
    }

    public void setMappings(Map<String, String> mappings) {
        this.mappings = mappings;
    }
}
