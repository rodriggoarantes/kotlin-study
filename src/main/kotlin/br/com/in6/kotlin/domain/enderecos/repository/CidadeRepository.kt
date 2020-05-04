package br.com.in6.kotlin.domain.enderecos.repository

import br.com.in6.kotlin.domain.enderecos.Cidade
import br.com.in6.kotlin.domain.enderecos.Endereco
import br.com.in6.kotlin.domain.enderecos.Estado
import br.com.in6.kotlin.domain.enderecos.Pais
import org.springframework.data.repository.CrudRepository

interface CidadeRepository : CrudRepository<Cidade, Long> {
    fun findByEstado(estado: Estado) : MutableList<Cidade>
}