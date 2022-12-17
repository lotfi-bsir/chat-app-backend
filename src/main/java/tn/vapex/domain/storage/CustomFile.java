package tn.vapex.domain.storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import tn.vapex.domain.entitites.BaseEntity;
import tn.vapex.domain.storage.enums.FileUrlType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PreRemove;
import java.io.File;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Slf4j
public class CustomFile extends BaseEntity {

    private String fileUrl;

    private String completePath;

    @Enumerated(EnumType.STRING)
    private FileUrlType fileUrlType;

    @PreRemove
    @Transactional(noRollbackFor = Exception.class)
    public void deleteFile() {
        if (this.fileUrlType == FileUrlType.ABSOLUTE || Objects.isNull(this.completePath)) return;
        File file = new File(this.completePath);
        boolean isFileDeleted = file.delete(); //NOSONAR
        if (isFileDeleted) log.info("UPLOADED FILE DELETED - " + this.fileUrl);
        else log.error("UNABLE TO DELETE FILE - " + this.fileUrl);
    }
}
