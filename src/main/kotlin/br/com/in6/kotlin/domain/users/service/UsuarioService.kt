package br.com.in6.kotlin.domain.users.service

import br.com.in6.kotlin.domain.users.Usuario
import br.com.in6.kotlin.domain.users.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
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