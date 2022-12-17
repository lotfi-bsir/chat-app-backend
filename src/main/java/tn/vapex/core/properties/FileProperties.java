package tn.vapex.core.properties;

import lombok.Data;
import tn.vapex.domain.storage.enums.FileType;

@Data
public class FileProperties {
    private String baseDir;
    private String defaultPath;
    private String deliveryMan;
    private String product;

    public String getPathByFileType(FileType type) {
        switch (type) {
            case DELIVERY_MAN_PHOTO:
                return deliveryMan;
            case PRODUCT_PHOTO:
                return product;
            default:
                return defaultPath;
        }
    }
}