package br.com.in6.kotlin.api

import br.com.in6.kotlin.domain.enderecos.Endereco
import br.com.in6.kotlin.domain.enderecos.Pais
import br.com.in6.kotlin.domain.enderecos.repository.EnderecoRepository
import br.com.in6.kotlin.domain.enderecos.repository.PaisRepository
import br.com.in6.kotlin.domain.enderecos.service.EnderecoService
import br.com.in6.kotlin.domain.usuarios.Usuario
import br.com.in6.kotlin.domain.usuarios.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("paises")
class PaisResource() {

    @Autowired
    lateinit var repository: PaisRepository

    @GetMapping
    fun listar(): List<Pais> {
        val list : Iterable<Pais> = repository.findAll()
        return list.toList()
    }
}