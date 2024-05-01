package br.com.agdeo.screensound.principal;

import br.com.agdeo.screensound.model.Artista;
import br.com.agdeo.screensound.model.Musica;
import br.com.agdeo.screensound.repository.ScreensoundRepository;
import br.com.agdeo.screensound.services.ConsultaChatGPT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuOpcoes {

    private static Scanner leitura = new Scanner(System.in);

    public static void cadastrarArtistas(ScreensoundRepository repositorio) {
        var flag = "S";
        do {
            System.out.println("Informe o nome desse artista:");
            var artistaAdd = leitura.nextLine();
            System.out.println("Informe o tipo desse artista: (solo, dupla, banda)");
            var tipoBandaAdd = leitura.nextLine();
            System.out.println("Informe o Genero desse artista:");
            var generoAdd = leitura.nextLine();
            Artista addArtista = new Artista(artistaAdd, generoAdd, tipoBandaAdd);
            repositorio.save(addArtista);
            System.out.println("Digite \"S\" para continuar cadastrando artistas? ");
            flag = leitura.nextLine();
        } while (flag.equalsIgnoreCase("S"));
    }

    public static Artista obterArtistaValido(String msg,List<Artista> artistasList) {

        var flag = "S";
        Artista artistaUpd;
        do {
            artistasList.forEach(System.out::println);
            System.out.println(msg);
            var artistaBuscado = leitura.nextLine();
            artistaUpd = new Artista();
            for (Artista artista : artistasList) {
                if (artista.getNome().toLowerCase().contains(artistaBuscado.toLowerCase())) {
                    artistaUpd = artista;
                }
            }
            if (artistaUpd.getNome().isEmpty()) {
                System.out.println("Artista invalido");
                continue;
            } else {
                break;
            }
        } while (true);

        return artistaUpd;
    }

    public static void cadastrarMusicas(ScreensoundRepository repositorio) {
        var flag = "S";
        do {
            var listaArtista = repositorio.findAll();
            var artistaUpd = obterArtistaValido("Qual artista você quer cadastar musica", listaArtista);

            System.out.println("Informe o nome da musica:");
            var nomeMusicaAdd = leitura.nextLine();
            System.out.println("Informe o Album dessa musica:");
            var albumMusicaAdd = leitura.nextLine();
            List<Musica> musicasAdd = new ArrayList<>();
            musicasAdd.add(new Musica(nomeMusicaAdd, albumMusicaAdd));
            artistaUpd.setMusicas(musicasAdd);
            repositorio.save(artistaUpd);

            System.out.println("Digite \"S\" para continuar cadastrando musicas? ");
            flag = leitura.nextLine();
        } while (flag.equalsIgnoreCase("S"));
    }

    public static void buscarMusicas(ScreensoundRepository repositorio) {
        List<Musica> musicas = repositorio.findMusicas();
        musicas.forEach(System.out::println);
    }

    public static void buscarMusicasPorArtista(ScreensoundRepository repositorio) {
        var listaArtista = repositorio.findAll();
        Artista artistaBusca = obterArtistaValido("Digite o artista para a busca:", listaArtista);

        List<Musica> musicas = repositorio.findMusicasByNome(artistaBusca.getNome());
        musicas.forEach(System.out::println);
    }

    public static void buscarInformacoesSobreArtista(ScreensoundRepository repositorio) {

        System.out.println("Qual o Artista que deseja buscar informação: ");
        var artistaBusca = leitura.nextLine();
        var informacao = ConsultaChatGPT.obterInformaoSobreArtista(artistaBusca);
        System.out.println(informacao);
    }
}
