package pe.edu.tecsup.poketindernew.data

import pe.edu.tecsup.poketindernew.data.database.PokemonDao
import pe.edu.tecsup.poketindernew.data.model.PokemonListModel
import pe.edu.tecsup.poketindernew.data.model.PokemonModel
import pe.edu.tecsup.poketindernew.data.network.PokemonService
import pe.edu.tecsup.poketindernew.domain.model.Pokemon
import pe.edu.tecsup.poketindernew.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon> {
        val listResponse: PokemonListModel = pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map { it.toDomain() }
    }
}