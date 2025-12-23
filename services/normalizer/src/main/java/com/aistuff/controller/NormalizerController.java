package com.aistuff.controller;

import com.aistuff.dto.StandardizedTransactionDTO;
import com.aistuff.service.NormalizerService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("normalize")
public class NormalizerController{

    private final NormalizerService normalizerService;


    public NormalizerController(NormalizerService normalizerService) {
        this.normalizerService = normalizerService;
    }

    @PostMapping("/{bank_name}")
    public StandardizedTransactionDTO normalizer(@PathVariable String bank_name, @RequestBody Map<String, Object> payload) throws Exception {
        return normalizerService.normalize(bank_name, payload);
    }

}
