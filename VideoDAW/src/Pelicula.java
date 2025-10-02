import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pelicula {

    // Defino atributos
    private String cod;
    private String titulo;
    private Genero genero;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    public Pelicula(String cod, String titulo, Genero genero) {
        this.cod = cod;
        this.titulo = titulo;
        this.genero = genero;
        this.fechaRegistro = LocalDate.now();
        this.isAlquilada = false;
    }

    public String getCod() {
        return cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void setIsAlquilada(boolean isAlquilada) {
        this.isAlquilada = isAlquilada;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "cod='" + cod + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero=" + genero +
                ", fechaRegistro=" + fechaRegistro +
                ", fechaBaja=" + fechaBaja +
                ", fechaAlquiler=" + fechaAlquiler +
                ", isAlquilada=" + isAlquilada +
                '}';
    }
}
