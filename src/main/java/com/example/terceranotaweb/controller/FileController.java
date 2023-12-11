package com.example.terceranotaweb.controller;

import com.example.terceranotaweb.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping({"/status"})
    public String status(){
        return "ok";
    }

    @PostMapping(value = "/api/files")
    @ResponseStatus(HttpStatus.OK)
    public void handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("ubicacion") String ubicacion) throws IOException {
        fileService.storeFile(file, ubicacion);
    }

    @GetMapping("/files/{ubicacion:.+}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename, @PathVariable String ubicacion) {
        Resource file = fileService.loadFile(filename, ubicacion);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @GetMapping("/files/view/{ubicacion:.+}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> viewFile(@PathVariable String filename, @PathVariable String ubicacion) {
        Resource file = fileService.loadFile(filename, ubicacion);

        HttpHeaders headers = new HttpHeaders();

        headers.add("content-disposition", "inline; filename="+file.getFilename());
        headers.setContentType(MediaType.parseMediaType("image/jpeg"));

        ResponseEntity<Resource> response = new ResponseEntity<Resource>(
                file, headers, HttpStatus.OK);

        return response;


    }
}
