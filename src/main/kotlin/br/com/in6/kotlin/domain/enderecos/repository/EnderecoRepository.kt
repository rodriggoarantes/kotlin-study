package br.com.in6.kotlin.domain.enderecos.repository

import br.com.in6.kotlin.domain.enderecos.Endereco
import org.springframework.data.repository.CrudRepository

interface EnderecoRepository : CrudRepository<Endereco, Long> {
    fun findByCep(cep: Long): List<Endereco>
}