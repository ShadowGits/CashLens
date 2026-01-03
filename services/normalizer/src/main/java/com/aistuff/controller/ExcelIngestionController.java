package com.aistuff.controller;

import com.aistuff.service.ExcelIngestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/ingest")
public class ExcelIngestionController {
    private final ExcelIngestionService excelIngestionService;

    public ExcelIngestionController(ExcelIngestionService excelIngestionService) {
        this.excelIngestionService = excelIngestionService;
    }

    @PostMapping("/excel")
    public ResponseEntity<String> ingestExcel(@RequestParam("file") MultipartFile file,
                                              @RequestParam("bank") String bank) {
        excelIngestionService.process(file, bank);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("File Accepted for Processing");
    }


}

