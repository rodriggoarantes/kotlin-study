package br.com.in6.kotlin.api

import br.com.in6.kotlin.domain.users.service.UsuarioService
import br.com.in6.kotlin.domain.users.Usuario
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UsuarioResource(val service: UsuarioService) {

    fun inserir(nome: String) : Usuario {
        return this.service.inserir(nome)
    }

    @GetMapping("/user")
    fun user(): Usuario {
        return this.inserir("Hello World")
    }
}