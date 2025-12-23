package com.aistuff.service;


import com.aistuff.config.BankStmtYAMLtoJAVAConfig;
import com.aistuff.dto.StandardizedTransactionDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

@Service
public class NormalizerService {

    private final BankMappingLoader mappingLoader;

    public NormalizerService(BankMappingLoader mappingLoader) {
        this.mappingLoader = mappingLoader;
    }

    public StandardizedTransactionDTO normalize(String bank, Map<String, Object> raw) throws Exception {

        BankStmtYAMLtoJAVAConfig config = mappingLoader.load(bank);

        try {
            StandardizedTransactionDTO dto = new StandardizedTransactionDTO();

            dto.setTransactionId(get(raw, config, "transaction_id"));
            dto.setDate(LocalDate.parse(get(raw, config, "date")));
            dto.setDescription(get(raw, config, "description"));
            dto.setAmount(Double.parseDouble(get(raw, config, "amount")));
            dto.setBalance(Double.parseDouble(get(raw, config, "balance")));
            dto.setAccountNo(get(raw, config, "account_no"));
            dto.setBank(config.getBank_name());
            dto.setType(get(raw, config, "type"));
            return dto;

        } catch (Exception e) {
            throw new Exception("Normalization failed for bank: " + bank, e);
        }
    }

    private String get(Map<String, Object> raw, BankStmtYAMLtoJAVAConfig cfg, String canonicalField) throws Exception {
        String rawField = cfg.getMappings().get(canonicalField);
        Object value = raw.get(rawField);

        if (value == null) {
            throw new Exception("Missing field: " + rawField);
        }

        return value.toString();
    }

}
