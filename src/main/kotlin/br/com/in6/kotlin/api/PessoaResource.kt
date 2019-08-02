package br.com.in6.kotlin.api

import br.com.in6.kotlin.domain.persons.Pessoa
import br.com.in6.kotlin.domain.persons.service.PessoaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("pessoas")
class PessoaResource() {

    @Autowired
    lateinit var service: PessoaService

    @GetMapping
    fun listar(): List<Pessoa> {
        val list : Iterable<Pessoa> = service.listar()
        return list.toList()
    }

    @GetMapping("/{id}")
    fun obter(@PathVariable id : Long): Pessoa? {
        return service.obter(id)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id : Long) {
        service.deletar(id)
    }

    @PostMapping
    fun gravar(@RequestBody obj: Pessoa): Pessoa {
        return service.inserir(obj)
    }

    @PatchMapping
    fun atualizar(@RequestBody obj: Pessoa): Pessoa? {
        return service.atualizar(obj)
    }

}