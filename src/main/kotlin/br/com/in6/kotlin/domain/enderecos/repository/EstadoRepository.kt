package br.com.in6.kotlin.domain.enderecos.repository

import br.com.in6.kotlin.domain.enderecos.Estado
import br.com.in6.kotlin.domain.enderecos.Pais
import org.springframework.data.repository.CrudRepository

interface EstadoRepository : CrudRepository<Estado, Long> {
    fun findByPais(pais: Pais) : MutableList<Estado>
}