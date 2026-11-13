package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "movil")
public class Movil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La marca es obligatoria")
    @Size(max = 50)
    private String marca;

    @NotBlank(message = "El modelo es obligatorio")
    @Size(max = 80)
    private String modelo;

    @NotNull(message = "Elige un sistema operativo")
    @Enumerated(EnumType.STRING)
    @Column(name = "sistema_operativo")
    private SistemaOperativo sistemaOperativo;

    @NotNull(message = "Elige un tipo de pantalla")
    @Enumerated(EnumType.STRING)
    private TipoPantalla pantalla;

    @NotNull(message = "La RAM es obligatoria")
    @Min(value = 1, message = "La RAM debe ser al menos 1 GB")
    @Column(name = "ram_gb")
    private Integer ramGb;

    @NotNull(message = "El almacenamiento es obligatorio")
    @Min(value = 1, message = "El almacenamiento debe ser al menos 1 GB")
    @Column(name = "almacenamiento_gb")
    private Integer almacenamientoGb;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", message = "El precio no puede ser negativo")
    private BigDecimal precio;

    @NotNull(message = "El año de lanzamiento es obligatorio")
    @Min(value = 2007, message = "El año debe ser 2007 o posterior")
    @Max(value = 2100, message = "Año no válido")
    @Column(name = "anio_lanzamiento")
    private Integer anioLanzamiento;

    public Movil() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public SistemaOperativo getSistemaOperativo() { return sistemaOperativo; }
    public void setSistemaOperativo(SistemaOperativo sistemaOperativo) { this.sistemaOperativo = sistemaOperativo; }

    public TipoPantalla getPantalla() { return pantalla; }
    public void setPantalla(TipoPantalla pantalla) { this.pantalla = pantalla; }

    public Integer getRamGb() { return ramGb; }
    public void setRamGb(Integer ramGb) { this.ramGb = ramGb; }

    public Integer getAlmacenamientoGb() { return almacenamientoGb; }
    public void setAlmacenamientoGb(Integer almacenamientoGb) { this.almacenamientoGb = almacenamientoGb; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public Integer getAnioLanzamiento() { return anioLanzamiento; }
    public void setAnioLanzamiento(Integer anioLanzamiento) { this.anioLanzamiento = anioLanzamiento; }
}