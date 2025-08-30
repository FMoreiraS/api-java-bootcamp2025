package me.dio.api_java_bootcamp2025.domain.repository;

import me.dio.api_java_bootcamp2025.domain.model.Artist;
import me.dio.api_java_bootcamp2025.domain.model.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ArtworkRepository extends JpaRepository<Artwork, Long> {

    boolean existsByNameAndArtistName(String artworkName, String artistName);

    @Query(
            "SELECT CASE " +
                    "WHEN COUNT(a) > 0 THEN TRUE ELSE FALSE " +
                "END " +
                "FROM Artwork a " +
                    "WHERE a.name = :artworkName " +
                    "AND a.artistName = :artistName " +
                    "AND a.creationDate = :creationDate")
    boolean existsByArtworkNameAndArtistNameAndCreationDate(
            @Param("artworkName") String artworkName,
            @Param("artistName") String artistName,
            @Param("creationDate") Date creationDate);
}
