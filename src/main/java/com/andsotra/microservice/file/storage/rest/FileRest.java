package com.andsotra.microservice.file.storage.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andsotra.microservice.file.storage.business.FileBusinessImpl;
import com.andsotra.microservice.file.storage.domain.FilesDto;
import com.andsotra.microservice.file.storage.domain.ResponseDto;

@RestController
@RequestMapping("dev/api/v1/file")
public class FileRest {
	

    private static final Logger logger = LogManager.getLogger(FileRest.class);
	
	@Autowired
	FileBusinessImpl fileBusinessImpl;
	
	@GetMapping("/{fileId}")
	public ResponseEntity<ResponseDto> findFile(@PathVariable(name = "fileId", required = true) String fileId) {
		logger.info("Start get file by id");
		ResponseDto response = new ResponseDto("OK", HttpStatus.OK.value(), fileBusinessImpl.findFileById(fileId));	
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<ResponseDto> createFile(@RequestBody FilesDto filestDto) {
		logger.info("Start create file");
		logger.info("base 64 image: " +filestDto.getFileBase64());
		logger.info("name image: " +filestDto.getFileName());
		ResponseDto response = new ResponseDto("OK", HttpStatus.OK.value(), fileBusinessImpl.createFile(filestDto.getFileName(), filestDto.getFileBase64()));
		
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
		
	}

}
