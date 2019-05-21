package br.com.in6.kotlin.mvc.service

import br.com.in6.kotlin.mvc.repository.UsuarioRepository
import br.com.in6.kotlin.poo.Usuario

class UsuarioService {

    var identificador = 0
    private val repository = UsuarioRepository()

    fun obter(id: Int) : Usuario? {
        return repository.porId(id)
    }

    fun inserir(name: String) : Usuario {
        repository.create(++identificador, name)
        return checkNotNull( obter(identificador) )
    }

    fun deletar(id: Int) {
        repository.delete(id)
    }
}