package br.com.in6.kotlin.domain.persons.repository

import br.com.in6.kotlin.domain.persons.Pessoa
import org.springframework.data.repository.CrudRepository

interface PessoaRepository : CrudRepository<Pessoa, Long> {
    fun findByNome(name: String): Pessoa
}