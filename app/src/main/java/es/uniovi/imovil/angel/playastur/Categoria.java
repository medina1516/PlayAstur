package es.uniovi.imovil.angel.playastur;

/**
 * Created by Angel on 28/06/2017.
 */

import com.google.gson.annotations.SerializedName;

public class Categoria {
//JSON: Permite el uso de esta parte del JSON, aunque no se utiliza

    long id;

    @SerializedName("content")
    String categoria;
}
