package com.rlabausa.cherishservice.photos.models;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "PHOTO")
public class Photo {

    @Transient
    @Value("${app.cherish.url}")
    private String URL_BASE;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filepath;

    @Transient
    private String url;

    public Photo() {
    }

    public Photo(Long id, String filepath) {
        this.id = id;
        this.filepath = filepath;
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return URL_BASE + filepath;
    }
}
