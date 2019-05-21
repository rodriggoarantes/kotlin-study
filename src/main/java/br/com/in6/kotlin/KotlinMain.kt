package br.com.in6.kotlin

import br.com.in6.kotlin.mvc.controler.UsuarioResource
import br.com.in6.kotlin.poo.Administrador
import br.com.in6.kotlin.poo.Usuario

fun main() {
    println("------------------------------------")
    helloWorldTestes()
    println("------------------------------------")
    mvcTestes()
}


// ------

fun mvcTestes() {
    val usuarioResource = UsuarioResource()

    val usuario = usuarioResource.inserir("rodrigo.arantes")
    hello(usuario.toString())


    val evelin = usuarioResource.inserir("evelin")
    val well = usuarioResource.inserir("wevellen")

    hello(evelin.toString())
    hello(well.toString())

    hello("SwitchCase == When : ${transform("Green")}")
}

fun helloWorldTestes() {
    val usuario = Usuario(10, "Rodrigo")

    val (idLocal, nameLocal) = usuario

    hello()
    hello(usuario.name)
    hello(nameLocal + "LOCAL: " + idLocal)

    helloList(usuario)

    val adm = Administrador(2)
    adm.name = "Evangelista"

    hello(adm.name)

    val usrBuild = Usuario.Builder().id(2).name("Evelin").build()
    hello(usrBuild.name)
}

fun hello(mensagem: String = "padrao") {
    println("Hello World: $mensagem")
}

fun helloList(usr: Usuario) {
    val usuario = Usuario(11, "Arantes")
    val listOfGame: List<Usuario> = listOf(usr, usuario)

    for (u in listOfGame) {
        hello(u.name)
    }

    for (a in Usuario.generate()) {
        hello(a.name)
    }
}


fun transform(color: String): Int {
    return when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }
}