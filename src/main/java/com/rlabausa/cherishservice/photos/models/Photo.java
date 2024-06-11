package com.rlabausa.cherishservice.photos.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PHOTO")
public class Photo {
    @Transient
    private final String URL_BASE = "TODO";

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

    public String getFilepath() {
        return filepath;
    }

    public String getUrl() {
        return URL_BASE + filepath;
    }
}
