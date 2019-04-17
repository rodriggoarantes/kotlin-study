package br.com.in6.kotlin

import br.com.in6.kotlin.poo.Administrador
import br.com.in6.kotlin.poo.Usuario

fun main() {
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