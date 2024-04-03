package org.example.shorturl.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_URL_COUNT")
@Getter
@NoArgsConstructor
@Setter
public class UrlCountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUNT_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "URL_ID", nullable = false)
    private UrlEntity urlEntity;

    @Column(name = "COUNT", nullable = false, columnDefinition = "bigint default 0")
    private Long count;

    public UrlCountEntity(UrlEntity urlEntity) {
        this.urlEntity = urlEntity;
        this.count = 0L;
        urlEntity.setUrlCountEntity(this);
    }

    public void increaseCount() {
        this.count += 1;
    }


}
