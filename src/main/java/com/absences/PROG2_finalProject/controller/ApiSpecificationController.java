package com.absences.PROG2_finalProject.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class ApiSpecificationController {

    @GetMapping(value = "/openapi.yaml", produces = "application/yaml")
    public String getApiSpec() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/main/resources/api/openapi.yaml")));
    }
}