package me.dio.api_java_bootcamp2025.controller;

import me.dio.api_java_bootcamp2025.domain.model.Artist;
import me.dio.api_java_bootcamp2025.domain.model.Artwork;
import me.dio.api_java_bootcamp2025.service.ArtistService;
import me.dio.api_java_bootcamp2025.service.ArtworkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

//@RestController
//@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> findById(@PathVariable Long id) {
        var artist = artistService.findById(id);
        return ResponseEntity.ok(artist);
    }

    @PostMapping
    public ResponseEntity<Artist> addArtist(@RequestBody Artist artistToAdd) {
        var artistAdded = artistService.addArtist(artistToAdd);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(artistAdded.getId())
                .toUri();
        return ResponseEntity.created(location).body(artistAdded);
    }
}
