package br.com.in6.kotlin.mvc.controler

import br.com.in6.kotlin.mvc.service.UsuarioService
import br.com.in6.kotlin.poo.Usuario

class UsuarioResource {

    val service = UsuarioService()

    fun inserir(nome: String) : Usuario {
        return this.service.inserir(nome)
    }
}