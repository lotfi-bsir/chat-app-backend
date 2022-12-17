package tn.vapex.domain.storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import tn.vapex.domain.entitites.BaseEntity;
import tn.vapex.domain.storage.enums.FileUrlType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
}
