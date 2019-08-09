package br.com.in6.kotlin.api

import br.com.in6.kotlin.domain.enderecos.Cidade
import br.com.in6.kotlin.domain.enderecos.Estado
import br.com.in6.kotlin.domain.enderecos.Pais
import br.com.in6.kotlin.domain.enderecos.repository.CidadeRepository
import br.com.in6.kotlin.domain.enderecos.repository.EstadoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("cidades")
class CidadeResource() {

    @Autowired
    lateinit var repository: CidadeRepository

    @GetMapping
    fun listar(): List<Cidade> {
        val list : Iterable<Cidade> = repository.findAll()
        return list.toList()
    }

    @GetMapping("/estados/{id}")
    fun listarPorPais(@PathVariable id : Long): List<Cidade>? {
        val param : Estado = Estado(id = id)
        val list : Iterable<Cidade> = repository.findByEstado(param)
        return list.toList()
    }
}