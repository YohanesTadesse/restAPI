package restApi.chewata.repository.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "author")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "title")
    private String title;
    @Column(name = "profile_image")
    private String image;
    @Column(name = "company")
    private String company;
    @Column(name = "created")
    private Date createdDate;
    @Column(name = "last_modified")
    private Date lastModifiedDate;

//    @OneToMany(mappedBy="author")
//    private Set<News> newsSet;

    public Author(String name, String title, String image, String company, Date createdDate, Date lastModifiedDate) {
        this.name = name;
        this.title = title;
        this.image = image;
        this.company = company;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }
}
