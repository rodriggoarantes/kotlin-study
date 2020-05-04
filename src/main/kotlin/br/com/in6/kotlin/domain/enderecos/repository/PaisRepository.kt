package br.com.in6.kotlin.domain.enderecos.repository

import br.com.in6.kotlin.domain.enderecos.Endereco
import br.com.in6.kotlin.domain.enderecos.Pais
import org.springframework.data.repository.CrudRepository

interface PaisRepository : CrudRepository<Pais, Long> {
}