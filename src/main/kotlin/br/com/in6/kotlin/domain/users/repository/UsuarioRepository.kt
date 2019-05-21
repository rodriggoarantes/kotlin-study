package br.com.in6.kotlin.domain.users.repository

import br.com.in6.kotlin.domain.users.Usuario

class UsuarioRepository {

    private val listaUsuarios: MutableList<Usuario> = ArrayList(0)

    fun porId(id: Int) : Usuario? {
        return listaUsuarios.filter { it.id == id }.firstOrNull()
    }

    fun create(id: Int, name: String) : Usuario {
        val usr = Usuario(id, name)
        listaUsuarios.add(usr)
        return usr
    }

    fun delete(id: Int) {
        val index : Int? = listaUsuarios.indexOfFirst { usuario -> usuario.id == id }
        index?.let {
            listaUsuarios.removeAt(index)
        }
    }
}