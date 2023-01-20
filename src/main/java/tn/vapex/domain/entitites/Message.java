package tn.vapex.domain.entitites;

import lombok.Getter;
import lombok.Setter;
import tn.vapex.domain.storage.CustomFile;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Message extends BaseEntity{

    @Lob
    @Column
    private String text;

    @OneToOne
    @JoinColumn
    private CustomFile image;

    @OneToOne
    @JoinColumn
    private User sender;

    @OneToOne
    @JoinColumn
    private User recipient;
}
