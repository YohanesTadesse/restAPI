package restApi.chewata.repository.entity;

import com.openpojo.business.annotation.BusinessKey;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "news")
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "image")
    private String image;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "author_id")
    private Long authorId;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    @BusinessKey
    private Date createdDate;
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "author_id", nullable = false)
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude private Author author;

    public News(String title, String image, String fileName, Long authorId, Date createdDate, Date lastUpdatedDate) {
        this.title = title;
        this.image = image;
        this.fileName = fileName;
        this.authorId = authorId;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }

}
