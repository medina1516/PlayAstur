package es.uniovi.imovil.angel.playastur;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Angel on 28/06/2017.
 */

public class conContent {
//JSON: esta clase permite acceder a objetos que tengan un Content
    @SerializedName("content")
    String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
