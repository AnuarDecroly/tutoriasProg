import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Cliente {

    private static int contadorSocios = 0;

    private String dni;
    private String nombre;
    private String numSocio;
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private List<Pelicula> peliculasAlquiladas;

    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;

        this.peliculasAlquiladas = new LinkedList<>();

        contadorSocios++;
        this.numSocio = "S-" + Integer.toString(contadorSocios);
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumSocio() {
        return numSocio;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String mostrarPeliculas(){
        String info = "No hay peliculas alquiladas";
        if(!peliculasAlquiladas.isEmpty()){
            info = "";
            for(Pelicula p : peliculasAlquiladas){
                info = p.toString() + "\n";
            }
        }
        return info;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", numSocio='" + numSocio + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaBaja=" + fechaBaja +
                '}';
    }

    public void alquilarPelicula(Pelicula p){
        p.setIsAlquilada(true);
        p.setFechaAlquiler(LocalDateTime.now());
        this.peliculasAlquiladas.add(p);
    }

    public void devolverPelicula(Pelicula p){
        p.setIsAlquilada(false);
    }
}
