package me.dio.api_java_bootcamp2025.service;

import me.dio.api_java_bootcamp2025.domain.model.Artist;

public interface ArtistService {

    Artist findById(Long id);

    Artist addArtist(Artist artistToAdd);

}
