package com.rlabausa.cherishservice.posts.models;

import com.rlabausa.cherishservice.locations.models.Location;
import com.rlabausa.cherishservice.photos.models.Photo;
import jakarta.persistence.*;

import java.util.List;

@Entity()
@Table(name = "POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String caption;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "POST_LOCATION",
            joinColumns = @JoinColumn(
                    name = "post_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "location_id"
            )
    )
    private Location location;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "POST_PHOTO",
            joinColumns = @JoinColumn(
                    name = "post_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "photo_id"
            )
    )
    private List<Photo> photos;


    public Post() {
    }

    public Post(Long id, String author, String caption, Location location, List<Photo> photos) {
        this.id = id;
        this.author = author;
        this.caption = caption;
        this.location = location;
        this.photos = photos;
    }

    public Long getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }

    public String getAuthor() {
        return author;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public Location getLocation() {
        return location;
    }
}
