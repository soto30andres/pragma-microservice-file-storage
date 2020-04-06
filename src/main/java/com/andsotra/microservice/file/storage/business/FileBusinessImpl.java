package com.andsotra.microservice.file.storage.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andsotra.microservice.file.storage.domain.FilesDto;
import com.andsotra.microservice.file.storage.model.Files;
import com.andsotra.microservice.file.storage.repository.FileRepository;
import com.andsotra.microservice.file.storage.utils.FilesUtils;

@Service
public class FileBusinessImpl implements FileBusiness{
	
	private final String pathImages = "C:\\Users\\57315\\Documents\\fotosPrueba\\";

    private static final Logger logger = LogManager.getLogger(FileBusinessImpl.class);
	@Autowired
	FileRepository fileRepository;
	
	@Override
	public FilesDto findFileById(String id) {
		
		Files file = fileRepository.findById(id).orElse(null);
		FilesDto filesDto = null;
		if(file != null) {
			String fileName = file.getFileName() +"."+file.getFileType();
			String fileBase64 = FilesUtils.fileToBase64(pathImages + fileName);
			filesDto = new FilesDto(file.getId(), fileBase64, fileName);
		}
			
		return filesDto;
	}
	
	public FilesDto createFile(String fullFileName, String base64image) {
		
		logger.info("Creating file");
		String[] splitfileName = fullFileName.split("\\.");
		String fileName = splitfileName[0];
		String fileType = splitfileName[1];
		boolean fileCreated = FilesUtils.createFile(pathImages+fullFileName, base64image);
		FilesDto filesDto = null;
		logger.info("file was created {}", fileCreated);
		if(fileCreated) {
			Files file = new Files();
			file.setFileName(fileName);
			file.setFilePath(pathImages);
			file.setFileType(fileType);
			file = fileRepository.save(file);
			filesDto = new FilesDto(file.getId(), base64image, fileName);
		}
			
		return filesDto;
	}

}
