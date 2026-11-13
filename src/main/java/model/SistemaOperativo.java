package model;

public enum SistemaOperativo {
    ANDROID("Android"),
    IOS("iOS"),
    OTRO("Otro");

    private final String etiqueta;

    SistemaOperativo(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
}