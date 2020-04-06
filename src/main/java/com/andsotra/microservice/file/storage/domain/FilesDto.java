package com.andsotra.microservice.file.storage.domain;

public class FilesDto {

	String id;
	String fileBase64;
	String fileName;
	
	public FilesDto(String id, String fileBase64, String fileName) {
		super();
		this.id = id;
		this.fileBase64 = fileBase64;
		this.fileName = fileName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileBase64() {
		return fileBase64;
	}
	public void setFileBase64(String fileBase64) {
		this.fileBase64 = fileBase64;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
