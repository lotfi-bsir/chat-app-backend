package tn.vapex.domain.storage.enums;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public enum FileType {
    /**
     * IMPORTANT: any enum added here must be added to {@link tn.vapex.core.properties.FileProperties}  getPathByFileType(FileType) and {@link tn.selket.developmental.fakers.files.FakeFileFetcher}
     */
    ANY(AnyExtension.class), DELIVERY_MAN(ImageExtension.class), PRODUCT(ImageExtension.class);

    public static final String DEFAULT_VALUE = "ANY";
    private final Set<String> extensionSet;
    private final Class<? extends Enum<?>> extensionClass;

    FileType(Class<? extends Enum<?>> extensionClass) {
        this.extensionClass = extensionClass;
        this.extensionSet = new HashSet<>();
        Enum<?>[] enumExtensions = extensionClass.getEnumConstants();
        for (Enum<?> ext : enumExtensions) {
            extensionSet.add(ext.name().toLowerCase());
        }
    }
}
