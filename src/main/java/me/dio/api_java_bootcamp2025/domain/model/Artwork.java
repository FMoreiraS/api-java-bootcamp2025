package me.dio.api_java_bootcamp2025.domain.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.sql.Date;

@Entity (name = "artwork")
public class Artwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_art")
    private TypeOfArt type;

    @OneToOne(cascade = CascadeType.ALL)
    private Artist artist;

    @Column (name = "date_of_creation")
    private Date creationDate;

    @Column (name = "artist_name")
    private String artistName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOfArt getType() {
        return type;
    }

    public void setType(TypeOfArt type) {
        this.type = type;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getArtistName() {
        if (this.getArtist().getName().equals(null)) return "Desconhecido";
        return this.getArtist().getName();
    }
}
