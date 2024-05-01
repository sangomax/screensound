package br.com.agdeo.screensound.model;

public enum TipoArtista {

    SOLO("solo"),
    DUPLA("dupla"),
    BANDA("banda");

    private String tipoArtista;

    TipoArtista(String tipo) {
        this.tipoArtista = tipo;
    }

    public static TipoArtista tiposArtistas(String text) {
        for (TipoArtista tipo : TipoArtista.values()) {
            if (tipo.tipoArtista.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nenhum tipo de artista encontrado para a string fornecida: " + text);
    }
}
