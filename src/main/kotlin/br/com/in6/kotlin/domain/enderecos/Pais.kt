package br.com.in6.kotlin.domain.enderecos

import javax.persistence.*

@Entity
@Table(name = "pais")
data class Pais (
        @Id
        @GeneratedValue
        val id: Long = 0,
        val codigo: String,
        val nome: String,
        val sigla: String
)
