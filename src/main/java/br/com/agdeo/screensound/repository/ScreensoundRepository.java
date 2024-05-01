package br.com.agdeo.screensound.repository;

import br.com.agdeo.screensound.model.Artista;
import br.com.agdeo.screensound.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScreensoundRepository extends JpaRepository<Artista, Long> {


    @Query("SELECT m from Artista a JOIN a.musicas m")
    List<Musica> findMusicas();

    @Query("SELECT m from Artista a JOIN a.musicas m WHERE a.nome = :artistaBusca")
    List<Musica> findMusicasByNome(String artistaBusca);
}
