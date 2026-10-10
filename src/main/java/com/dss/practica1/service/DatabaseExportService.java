package com.dss.practica1.service;

import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

import com.dss.practica1.repository.ProductRepo;
import com.dss.practica1.model.Product;

@Service
public class DatabaseExportService {

    private final ProductRepo productRepo;

    public DatabaseExportService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public byte[] exportDatabaseToSql() {

        StringBuilder sql = new StringBuilder();

        sql.append("-- EXPORTACION SQL - P1 \n");

        for (Product product : productRepo.findAll()) {

            String name = product.getName()
                    .replace("'", "''");

            sql.append(
                "INSERT INTO product (id, name, price) VALUES ("
            );

            sql.append(product.getId()).append(", ");
            sql.append("'").append(name).append("', ");
            sql.append(product.getPrice());
            sql.append(");\n");
        }
        return sql.toString().getBytes(StandardCharsets.UTF_8);
    }
}