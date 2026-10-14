package com.dss.practica1.controller;

import org.springframework.http.HttpHeaders;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dss.practica1.service.DatabaseExportService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private final DatabaseExportService databaseExportService;

    AdminController(DatabaseExportService databaseExportService) {
        this.databaseExportService = databaseExportService;
    }

    // Endpoint para descargar  SQL
    @GetMapping("/export")
    public ResponseEntity<ByteArrayResource> exportDatabase() {
    	
        byte[] data = databaseExportService.exportDatabaseToSql();
        
        ByteArrayResource resource = new ByteArrayResource(data);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=productos.sql")
        		.contentType(MediaType.APPLICATION_OCTET_STREAM)
        		.contentLength(data.length).body(resource);
    }
}
