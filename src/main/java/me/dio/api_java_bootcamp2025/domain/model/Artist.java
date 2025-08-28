package me.dio.api_java_bootcamp2025.domain.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity (name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date birthday;

    private String nationality;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Artwork> works;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Artwork> getWorks() {
        return works;
    }

    public void setWorks(List<Artwork> works) {
        this.works = works;
    }
}
