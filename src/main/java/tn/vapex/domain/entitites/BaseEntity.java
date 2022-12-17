package tn.vapex.domain.entitites;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
@FieldNameConstants
public abstract class BaseEntity implements Serializable {

    @Column
    @CreationTimestamp
    protected Date createdAt;

    @Column
    @UpdateTimestamp
    protected Date updatedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @PrePersist // In case @CreationTimestamp failed to init createdAt
    private void initCreationAt() {
        if (Objects.isNull(this.createdAt)) this.createdAt = new Date();
    }

}
