package me.dio.api_java_bootcamp2025.controller;

import me.dio.api_java_bootcamp2025.domain.model.Artwork;
import me.dio.api_java_bootcamp2025.service.ArtworkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/artworks")
public class ArtworkController {

    private final ArtworkService artworkService;

    public ArtworkController(ArtworkService artworkService) {
        this.artworkService = artworkService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artwork> findById(@PathVariable Long id) {
        var artwork = artworkService.findById(id);
        return ResponseEntity.ok(artwork);
    }

    @PostMapping
    public ResponseEntity<Artwork> addArtwork(@RequestBody Artwork artworkToAdd) {
        var artworkAdded = artworkService.addArtwork(artworkToAdd);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(artworkAdded.getId())
                .toUri();
        return ResponseEntity.created(location).body(artworkAdded);
    }
}
