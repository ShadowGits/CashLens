package com.aistuff.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class ExcelIngestionController {

    @RestController
    @RequestMapping("/ingest")
    public class ExcelIngestionController{
        private final ExcelIngestionService excelIngestionService;

        public ExcelIngestionController(ExcelIngestionService excelIngestionService) {
            this.excelIngestionService = excelIngestionService;
        }

        @PostMapping("/excel")
        publi



    }
}
