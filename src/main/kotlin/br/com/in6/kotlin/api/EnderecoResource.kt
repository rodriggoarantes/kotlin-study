package br.com.in6.kotlin.api

import br.com.in6.kotlin.domain.enderecos.Endereco
import br.com.in6.kotlin.domain.enderecos.repository.EnderecoRepository
import br.com.in6.kotlin.domain.enderecos.service.EnderecoService
import br.com.in6.kotlin.domain.usuarios.Usuario
import br.com.in6.kotlin.domain.usuarios.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("enderecos")
class EnderecoResource() {

    @Autowired
    lateinit var repository: EnderecoService

    @GetMapping
    fun listar(): List<Endereco> {
        val list : Iterable<Endereco> = repository.listar()
        return list.toList()
    }

    @GetMapping("/{id}")
    fun obter(@PathVariable id : Long): Endereco? {
        return repository.obter(id)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id : Long) {
        repository.deletar(id)
    }

    @PostMapping
    fun gravar(@RequestBody endereco: Endereco): Endereco {
        return repository.inserir(endereco)
    }

    @PatchMapping
    fun atualizar(@RequestBody end: Endereco): Endereco? {
        return repository.atualizar(end)
    }
}