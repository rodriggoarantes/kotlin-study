package br.com.in6.kotlin.domain.users.service

import br.com.in6.kotlin.domain.users.Usuario
import br.com.in6.kotlin.domain.users.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UsuarioService @Autowired constructor(
        val repository: UsuarioRepository) {

    fun obter(id: Long) : Usuario? {
        return repository.findByIdOrNull(id)
    }

    fun inserir(usr: Usuario) : Usuario {
        return checkNotNull( repository.save(usr) )
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun listar() : Iterable<Usuario> {
        return repository.findAll().toMutableList()
    }

    fun atualizar(usr: Usuario) : Usuario? {
        usr.id ?: throw IllegalArgumentException("Código do usuario é inválido")
        this.obter(usr.id!!) ?: throw IllegalArgumentException("Usuário nao encontrado para atualização")
        return repository.save(usr)
    }
}