package tn.vapex.domain.storage.rest;


import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tn.vapex.domain.storage.enums.FileType;

@Component
public class FileTypeEnumConverter implements Converter<String, FileType> {

    @Override
    public FileType convert(@NonNull String value) {
        try {
            return FileType.valueOf(value.toUpperCase());
        } catch (Exception e) {
            return FileType.ANY;
        }
    }
}
