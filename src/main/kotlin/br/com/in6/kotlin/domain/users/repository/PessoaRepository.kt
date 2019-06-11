package br.com.in6.kotlin.domain.users.repository

import br.com.in6.kotlin.domain.users.Pessoa
import br.com.in6.kotlin.domain.users.Usuario
import org.springframework.data.repository.CrudRepository

interface PessoaRepository : CrudRepository<Pessoa, Long> {
    fun findByNome(name: String): Pessoa
}