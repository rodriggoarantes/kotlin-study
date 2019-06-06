package br.com.in6.kotlin.domain.users

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Usuario constructor(
        @Id
        @GeneratedValue
        val id: Long = 0,

        @Column(nullable = false)
        val name: String)

data class UsuarioDto(val id: Long, val name: String)

fun Usuario.toDTO() = UsuarioDto(
        id = id,
        name = name
)