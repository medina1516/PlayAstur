package es.uniovi.imovil.angel.playastur;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Angel on 28/06/2017.
 */

public class Categorias {
//JSON: Categorias contiene un array de Categoria

    @SerializedName("categoria")
    Categoria[] categorias;

}
