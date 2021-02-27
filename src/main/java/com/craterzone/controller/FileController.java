package com.craterzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.craterzone.service.FileService;

@RestController
@RequestMapping("/")
public class FileController {
	@Autowired
	FileService fileService;

	@Autowired
	    FileController(FileService fileService) {
	        this.fileService = fileService;
	    }

	@PostMapping
	public String uploadFile(@RequestParam(value = "file") MultipartFile file) {
		return fileService.uploadFile(file);
	}

	@DeleteMapping
	public String deleteFile(@RequestPart(value = "url") String url) {             //body [form-data]
		return fileService.deleteFileFromS3Bucket(url);
	}

}