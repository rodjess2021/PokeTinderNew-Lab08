package pe.edu.tecsup.poketindernew.domain.model

import pe.edu.tecsup.poketindernew.data.model.PokemonModel
import pe.edu.tecsup.poketindernew.util.getIdPokemonFromUrl
import java.io.Serializable


data class Pokemon(
    val name: String,
    val url: String
) : Serializable {
    fun getPokemonId() = getIdPokemonFromUrl(url)

    fun getPokemonImage(): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${getPokemonId()}.png"
}

fun PokemonModel.toDomain() = Pokemon(name = name, url = url)