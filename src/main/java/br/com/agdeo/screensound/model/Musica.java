package br.com.agdeo.screensound.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String album;
    @ManyToOne
    private Artista artista;

    public Musica(String nome, String album) {
        this.nome = nome;
        this.album = album;
    }

    public Musica() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        album = album;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Musica= '" + nome + '\'' +
                ", Album= '" + album + '\'' +
                ", Artista= " + artista.getNome();
    }
}
