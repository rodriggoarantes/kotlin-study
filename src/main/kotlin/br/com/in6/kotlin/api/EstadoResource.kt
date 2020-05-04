package br.com.in6.kotlin.api

import br.com.in6.kotlin.domain.enderecos.Estado
import br.com.in6.kotlin.domain.enderecos.Pais
import br.com.in6.kotlin.domain.enderecos.repository.EstadoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("estados")
class EstadoResource() {

    @Autowired
    lateinit var repository: EstadoRepository

    @GetMapping
    fun listar(): List<Estado> {
        val list : Iterable<Estado> = repository.findAll()
        return list.toList()
    }

    @GetMapping("/paises/{id}")
    fun listarPorPais(@PathVariable id : Long): List<Estado>? {
        val pais : Pais = Pais(id = id, nome = "")
        val list : Iterable<Estado> = repository.findByPais(pais)
        return list.toList()
    }
}