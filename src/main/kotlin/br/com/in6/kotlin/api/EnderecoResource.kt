package br.com.in6.kotlin.api

import br.com.in6.kotlin.domain.enderecos.Endereco
import br.com.in6.kotlin.domain.enderecos.service.EnderecoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("enderecos")
class EnderecoResource() {

    @Autowired
    lateinit var service: EnderecoService

    @GetMapping
    fun listar(): List<Endereco> {
        val list : Iterable<Endereco> = service.listar()
        return list.toList()
    }

    @GetMapping("/{id}")
    fun obter(@PathVariable id : Long): Endereco? {
        return service.obter(id)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id : Long) {
        service.deletar(id)
    }

    @PostMapping
    fun gravar(@RequestBody endereco: Endereco): Endereco {
        return service.inserir(endereco)
    }

    @PutMapping
    fun atualizar(@RequestBody end: Endereco): Endereco? {
        return service.atualizar(end)
    }

    @GetMapping("/cep/{cep}")
    fun listarEnderecoPorCep(@PathVariable cep : Long): List<Endereco> {
        val list : Iterable<Endereco> = service.listarEnderecoPorCep(cep)
        return list.toList()
    }
}