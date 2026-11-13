package model;

public enum TipoPantalla {
    LCD("LCD"),
    OLED("OLED"),
    AMOLED("AMOLED");

    private final String etiqueta;

    TipoPantalla(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
}