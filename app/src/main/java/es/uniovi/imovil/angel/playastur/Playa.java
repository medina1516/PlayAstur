package es.uniovi.imovil.angel.playastur;

/**
 * Created by Angel on 28/06/2017.
 */

import com.google.gson.annotations.SerializedName;

public class Playa {

    //Objetos que se obtienen del JSON, una playa tiene unas caracteristicas
    // que se mostraran en la aplicacion, aunque no se utilizaran todas


    @SerializedName("descripcion")
    conContent descripcion;

    @SerializedName("foto")
    conContent foto;

    @SerializedName("horario")
    Object horario;

    @SerializedName("localizacion")
    conContent lat_long;

    @SerializedName("nombre")
    conContent nombre;

    @SerializedName("telefono.content")
    int telefono;

    @SerializedName("url")
    String webGijon;

    @SerializedName("correo-electronico")
    String contacto;


    //getters y setters

    public String getDescripcion() {
        return descripcion.content;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.content = descripcion;
    }

    public String getFoto() {
        return foto.content;
    }

    public void setFoto(String foto) {
        this.foto.content = foto;
    }

    public Object getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public conContent getLat_long() {
        return lat_long;
    }

    public void setLat_long(String lat_long) {
        this.lat_long.content = lat_long;
    }

    public String getNombre() {
        return nombre.content;
    }

    public void setNombre(String nombre) {
        this.nombre.content = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getWebGijon() {
        return webGijon;
    }

    public void setWebGijon(String webGijon) {
        this.webGijon = webGijon;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }


}
