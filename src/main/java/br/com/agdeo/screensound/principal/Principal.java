package br.com.agdeo.screensound.principal;

import br.com.agdeo.screensound.repository.ScreensoundRepository;

import java.util.Scanner;

public class Principal {

    private ScreensoundRepository repositorio;
    private Scanner leitura = new Scanner(System.in);

    public Principal(ScreensoundRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibirMenu() {

        var opcao = -1;
        while (opcao != 9) {

            System.out.println("""
                    *************** Menu ***************
                    1- Cadastrar artistas         
                    2- Cadastrar músicas
                    3- Listar músicas         
                    4- Buscar músicas por artistas
                    5- Pesquisar dados sobre um artista
                                    
                    9- Sair
                    *************************************
                    """);

            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    MenuOpcoes.cadastrarArtistas(repositorio);
                    break;
                case 2:
                    MenuOpcoes.cadastrarMusicas(repositorio);
                    break;
                case 3:
                    MenuOpcoes.buscarMusicas(repositorio);
                    break;
                case 4:
                    MenuOpcoes.buscarMusicasPorArtista(repositorio);
                    break;
                case 5:
                    MenuOpcoes.buscarInformacoesSobreArtista(repositorio);
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }



}
