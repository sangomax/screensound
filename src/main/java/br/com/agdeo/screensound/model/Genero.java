package br.com.agdeo.screensound.model;

public enum Genero {

    SAMBA("samba"),
    PAGODE("pagode"),
    FORRO("forró"),
    JAZZ("jazz"),
    ROCK("rock"),
    SERTANEJO("sertanejo"),
    BLUES("blues"),
    GOSPEL("gospel"),
    ELETRONICA("eletrônica"),
    FUNK("funk");

    private String genero;
    Genero(String genero) {
        this.genero = genero;
    }

    public static Genero obterGenero(String text) {
        for (Genero item : Genero.values()) {
            if (item.genero.equalsIgnoreCase(text)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Nenhum Genero musical encontrado para a string fornecida: " + text);
    }
}
