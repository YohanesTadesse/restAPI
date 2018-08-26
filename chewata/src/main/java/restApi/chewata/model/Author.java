package restApi.chewata.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Author {
    private Long id;
    private String name;
    private String title;
    private String image;
    private String company;
    private Date createdDate;
    private Date lastModifiedDate;
}
