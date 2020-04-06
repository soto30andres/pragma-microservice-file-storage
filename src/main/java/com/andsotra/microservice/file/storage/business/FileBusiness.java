package com.andsotra.microservice.file.storage.business;

import java.util.List;

import com.andsotra.microservice.file.storage.domain.FilesDto;
import com.andsotra.microservice.file.storage.model.Files;

public interface FileBusiness {

	FilesDto findFileById(String id);

}
