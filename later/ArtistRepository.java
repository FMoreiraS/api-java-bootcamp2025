package me.dio.api_java_bootcamp2025.domain.repository;

import me.dio.api_java_bootcamp2025.domain.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

//@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    boolean existsByNameAndBirthday(String artistName, Date birthday);
}
