package restApi.chewata.model;

import lombok.Setter;

import java.util.Date;
import java.util.Objects;

public class News {
    private Long id;
    private String title;
    private String image;
    private String fileName;
    private Long authorId;
    private Date createdDate;
    private Date lastUpdatedDate;

    public News() {
    }

    public News(Long id,
                String title,
                String image,
                String fileName,
                Long authorId,
                Date createdDate,
                Date lastUpdatedDate) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.fileName = fileName;
        this.authorId = authorId;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getFileName() {
        return fileName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(id, news.id) &&
                Objects.equals(title, news.title) &&
                Objects.equals(image, news.image) &&
                Objects.equals(fileName, news.fileName) &&
                Objects.equals(authorId, news.authorId) &&
                Objects.equals(createdDate, news.createdDate) &&
                Objects.equals(lastUpdatedDate, news.lastUpdatedDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, image, fileName, authorId, createdDate, lastUpdatedDate);
    }
}
