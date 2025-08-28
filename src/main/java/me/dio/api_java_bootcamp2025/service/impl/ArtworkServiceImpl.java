package me.dio.api_java_bootcamp2025.service.impl;

import me.dio.api_java_bootcamp2025.domain.model.Artwork;
import me.dio.api_java_bootcamp2025.domain.repository.ArtworkRepository;
import me.dio.api_java_bootcamp2025.service.ArtworkService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.NoSuchElementException;

@Service
public class ArtworkServiceImpl  implements ArtworkService {

    private final ArtworkRepository artworkRepository;

    public ArtworkServiceImpl(ArtworkRepository artworkRepository) {
        this.artworkRepository = artworkRepository;
    }

    public Artwork findById(Long id) {
        return artworkRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

//    public Artwork addArtwork(Artwork artworkToAdd) {
//        if (artworkRepository.existsByNameArtistAndDate(
//                artworkToAdd.getName(),
//                artworkToAdd.getArtist(), //.getName(),
//                artworkToAdd.getCreationDate()
//        )) {
//            throw new IllegalArgumentException("This Artwork already had been added.");
//        }
//        return artworkRepository.save(artworkToAdd);
//    }

    public Artwork addArtwork(Artwork artworkToAdd) {
        String artworkName = artworkToAdd.getName();
//        String artistName = artworkToAdd.getArtistName();
        String artistName = artworkToAdd.getArtist().getName();
        Date artworkDateOfCreation = artworkToAdd.getCreationDate();
        if (artworkRepository.existsByNameAndArtistNameAndCreationDate(
                artworkName,
                artistName,
                artworkDateOfCreation
        )) {
            throw new IllegalArgumentException("This Artwork already had been added.");
        }
        return artworkRepository.save(artworkToAdd);
    }
}