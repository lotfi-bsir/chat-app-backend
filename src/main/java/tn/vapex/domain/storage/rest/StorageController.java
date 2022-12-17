package tn.vapex.domain.storage.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.vapex.core.properties.VapexProperties;
import tn.vapex.domain.storage.CustomFile;
import tn.vapex.domain.storage.StorageService;
import tn.vapex.domain.storage.enums.FileType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/upload-files")
@RequiredArgsConstructor
public class StorageController {

    private final StorageService storageService;
    private final CustomFileMapper customFileMapper;
    private final VapexProperties vapexProperties;

    @PostMapping("")
    public ResponseEntity<List<CustomFileDto>> uploadFiles(@RequestPart("files") MultipartFile[] files,
                                                           @RequestParam(defaultValue = "ANY", name = "accepted-extension") List<String> acceptedExtension,
                                                           @RequestParam(defaultValue = FileType.DEFAULT_VALUE, name = "type", required = false) FileType fileType) {
        List<CustomFile> customFiles = new ArrayList<>();
        Arrays.stream(files).forEach(file -> {
            CustomFile uploadedFile = this.storageService.uploadFile(file, vapexProperties.getFile().getPathByFileType(fileType), acceptedExtension.toArray(String[]::new));
            customFiles.add(uploadedFile);
        });
        return ResponseEntity.ok(customFileMapper.toDto(customFiles));
    }
}