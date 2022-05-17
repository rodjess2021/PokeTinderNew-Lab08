package pe.edu.tecsup.poketindernew.data.model

import com.google.gson.annotations.SerializedName
import pe.edu.tecsup.poketindernew.util.getIdPokemonFromUrl
import java.io.Serializable

data class PokemonListModel(

    @SerializedName("count") val count: Int,

    @SerializedName("results") val results: List<PokemonModel>

)