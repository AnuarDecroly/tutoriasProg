import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VideoDaw {


    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private List<Pelicula> peliculasRegistradas;
    private List<Cliente> clientesRegistrados;

    public VideoDaw(String cif, String direccion) {
        this.cif = cif;
        this.direccion = direccion;

        this.fechaAlta = LocalDate.now();

        this.peliculasRegistradas = new LinkedList<>();
        this.clientesRegistrados = new LinkedList<>();
    }

    public String getCif() {
        return cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /*
    Además de los constructores y propiedades necesarios, deberá tener al menos
    Un método para devolver una película devolverPelicula(Pelicula p, cliente c):  deberá comprobar que no haya excedido el tiempo máximo de 48 horas, en caso de excederlo mostrara un mensaje de advertencia.
    */


    public boolean registraCliente(Cliente c){
        if(!this.clientesRegistrados.isEmpty()){
            if(clientesRegistrados.contains(c)){
                return false;
            }else{
                clientesRegistrados.add(c);
                return true;
            }
        }
        else{
            clientesRegistrados.add(c);
            return true;
        }
    }

    public boolean registraPeliculas(Pelicula p){
        if(!this.peliculasRegistradas.isEmpty()){
            if(peliculasRegistradas.contains(p)){
                return false;
            }else{
                peliculasRegistradas.add(p);
                return true;
            }
        }
        else{
            peliculasRegistradas.add(p);
            return true;
        }
    }

    public boolean darBajaCliente(Cliente c){
        boolean baja = false;
        if(!this.clientesRegistrados.isEmpty()){
            if(clientesRegistrados.contains(c)){
                this.clientesRegistrados.remove(c);
                baja = true;
            }
        }
        return baja;
    }

    public boolean alquilarPelicula(Pelicula pelicula, Cliente cliente) {
        boolean respuesta = false;
        //Comprobar si existe cliente
        if(!this.clientesRegistrados.isEmpty()){
            boolean existeCliente = false;
            for (Cliente c : this.clientesRegistrados) {
                if(c.equals(cliente)){
                    existeCliente = true;
                }
            }
            if(!existeCliente){
                return false;
            }
            if(!this.peliculasRegistradas.isEmpty()){
                boolean existePelicula = false;
                for (Pelicula p : this.peliculasRegistradas) {
                    if(p.equals(pelicula)){
                        existePelicula = true;
                    }
                }
                if(!existePelicula){
                    return false;
                }
                if(existePelicula == true && existeCliente == true){
                    for (Pelicula p : this.peliculasRegistradas) {
                        if(p.equals(pelicula)){
                            if(!p.isAlquilada()){
                                p.setIsAlquilada(true);
                                p.setFechaAlquiler(LocalDateTime.now());

                                cliente.alquilarPelicula(pelicula);
                            }else{
                                return false;
                            }

                        }
                    }

                }
            }

        }else{
            //No se puede alquilar porque el cliente no esta registrado
            return false;
        }

        //Comprobar si existe pelicula

        return respuesta;
    }

    @Override
    public String toString() {
        return "VideoDaw{" +
                "cif='" + cif + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaAlta=" + fechaAlta +
                '}';
    }

    public String mostrarPeliculas(){
        String info = "No hay peliculas registradas";
        if(!this.peliculasRegistradas.isEmpty()){
            info = "";
            for(Pelicula p : this.peliculasRegistradas){
                info = p.toString() + "\n";
            }
        }
        return info;
    }

    public String mostrarCliente(){
        String info = "No hay clientes registrados";
        if(!this.clientesRegistrados.isEmpty()){
            info = "";
            for(Cliente c : this.clientesRegistrados){
                info = c.toString() + "\n";

            }
        }
        return info;
    }


}
