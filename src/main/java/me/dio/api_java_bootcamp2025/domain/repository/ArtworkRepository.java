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

    boolean existsByNameArtistAndDate(String name, Artist artist, Date dateCreated);

//    @Query(value = "SELECT CASE WHEN count(a) > 0 THEN TRUE ELSE FALSE END FROM ARTWORK a INNER JOIN ARTIST t2 ON a.artist_id=t2.id WHERE t2.name = :name AND a.name = :artworkName AND a.date_of_creation = :date_of_creation", nativeQuery = true)
//    boolean existsByNameAuthorAndDate(@Param("name") String artistName, @Param("artworkName") String artworkName, @Param("date_of_creation") Date creationDate);

//    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN TRUE ELSE FALSE END FROM Artwork a WHERE a.artist.name = :artistName AND a.name = :artworkName AND a.creationDate = :creationDate")
//    boolean existsByNameArtistAndDate(@Param("artistName") String artistName, @Param("artworkName") String artworkName, @Param("creationDate") Date creationDate);


    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN TRUE ELSE FALSE END FROM Artwork a WHERE a.artist.name = :artistName AND a.name = :artworkName AND a.creationDate = :creationDate")
//    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN TRUE ELSE FALSE END FROM Artwork a WHERE a.artist.name = :artistName AND a.name = :artworkName AND a.creationDate = :creationDate")
    boolean existsByNameAndArtistNameAndCreationDate(String artworkName, String artistName, Date creationDate);
//    boolean existsByArtistNameAndArtworkNameAndCreationDate(@Param("artistName") String artistName, @Param("artworkName") String artworkName, @Param("creationDate") Date creationDate);
//    @Query(
//            "SELECT FROM artwork aw " +
//                    "WHERE aw.name = :artworkName " +
//                    "AND aw.artist.name = :artistName " +
//                    "AND aw.date_of_creation = :creationDate"
//    )
//    boolean existsByNameAndArtistNameAndCreationDate(
//            @Param("artworkName") String artworkName,
//            @Param("artistName") String artistName,
//            @Param("creationDate") Date creationDate);
//
}
