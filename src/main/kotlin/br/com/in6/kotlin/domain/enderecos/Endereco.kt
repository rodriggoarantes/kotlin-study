package br.com.in6.kotlin.domain.enderecos

import javax.persistence.*

@Entity
@Table(name = "endereco")
data class Endereco (
        @Id
        @GeneratedValue
        val id: Long = 0,
        var descricao: String,
        var cep: Long,
        var logradouro: String,
        var numero: Long,
        var complemento: String,
        var bairro: String,
        var tipo: EnderecoTipo
) {
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "cidade_id", referencedColumnName = "id", nullable = false)
    var cidade: Cidade? = null
}
