package pe.edu.tecsup.poketindernew.data.network

import pe.edu.tecsup.poketindernew.data.model.PokemonListModel
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {

    @GET("?limit=20")
    suspend fun getPokemons() : Response<PokemonListModel>

}