package br.com.in6.kotlin.api

import br.com.in6.kotlin.domain.usuarios.Usuario
import br.com.in6.kotlin.domain.usuarios.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("usuarios")
class UsuarioResource() {

    @Autowired
    lateinit var service: UsuarioService

    @GetMapping
    fun listar(): List<Usuario> {
        val list : Iterable<Usuario> = service.listar()
        return list.toList()
    }

    @GetMapping("/{id}")
    fun obter(@PathVariable id : Long): Usuario? {
        return service.obter(id)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id : Long) {
        service.deletar(id)
    }

    @PostMapping
    fun gravar(@RequestBody usuario: Usuario): Usuario {
        return service.inserir(usuario)
    }

    @PatchMapping
    fun atualizar(@RequestBody usuario: Usuario): Usuario? {
        return service.atualizar(usuario)
    }

}