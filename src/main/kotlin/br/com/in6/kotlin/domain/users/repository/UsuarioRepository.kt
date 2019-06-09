package br.com.in6.kotlin.domain.users.repository

import br.com.in6.kotlin.domain.users.Usuario
import org.springframework.data.repository.CrudRepository

interface UsuarioRepository : CrudRepository<Usuario, Long> {
    fun findByLogin(name: String): Usuario
}