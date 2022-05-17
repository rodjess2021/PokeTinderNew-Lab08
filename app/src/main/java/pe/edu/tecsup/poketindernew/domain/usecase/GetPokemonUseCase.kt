package pe.edu.tecsup.poketindernew.domain.usecase

import pe.edu.tecsup.poketindernew.data.PokemonRepository
import pe.edu.tecsup.poketindernew.domain.model.Pokemon
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(private val repository: PokemonRepository) {
    suspend operator fun invoke():List<Pokemon> {
        return repository.getAllPokemonFromApi()
    }
}