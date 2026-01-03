package com.aistuff.service;

import org.springframework.web.multipart.MultipartFile;

public class ExcelIngestionService {

    private final NormalizerService normalizerService;

    public ExcelIngestionService(NormalizerService normalizerService)
    {
        this.normalizerService = normalizerService;
    }

    public void process(MultipartFile file, String bank)
    {
        // FOR NOW: just log + placeholder
        System.out.println("Received file: " + file.getOriginalFilename());
        System.out.println("Bank: " + bank);

        // Later:
        // 1. Parse Excel rows
        // 2. Convert each row -> Map<String, Object>
        // 3. Call normalizerService.normalize(bank, row)
    }
}
