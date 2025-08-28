package me.dio.api_java_bootcamp2025.service;

import me.dio.api_java_bootcamp2025.domain.model.Artwork;

public interface ArtworkService {

    Artwork findById(Long id);

    Artwork addArtwork(Artwork artworkToAdd);

}
