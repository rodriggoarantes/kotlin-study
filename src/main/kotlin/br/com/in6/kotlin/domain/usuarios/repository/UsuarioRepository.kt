package br.com.in6.kotlin.domain.usuarios.repository

import br.com.in6.kotlin.domain.usuarios.Usuario
import org.springframework.data.repository.CrudRepository

interface UsuarioRepository : CrudRepository<Usuario, Long> {
    fun findByLogin(name: String): Usuario
}