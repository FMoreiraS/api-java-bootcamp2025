package me.dio.api_java_bootcamp2025.service.impl;

import me.dio.api_java_bootcamp2025.domain.model.Artist;
import me.dio.api_java_bootcamp2025.domain.repository.ArtistRepository;
import me.dio.api_java_bootcamp2025.service.ArtistService;

import java.sql.Date;
import java.util.NoSuchElementException;

//@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Artist findById(Long id) {
        return artistRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Artist addArtist(Artist artistToAdd) {
        String artistName = artistToAdd.getName();
        Date birthday = artistToAdd.getBirthday();
        if (artistRepository.existsByNameAndBirthday (artistName, birthday)) {
            throw new IllegalArgumentException("This Artist already had been added.");
        }
        return artistRepository.save(artistToAdd);
    }
}