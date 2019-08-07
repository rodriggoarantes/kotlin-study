package br.com.in6.kotlin.domain.enderecos.service

import br.com.in6.kotlin.domain.enderecos.Endereco
import br.com.in6.kotlin.domain.enderecos.repository.EnderecoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class EnderecoService @Autowired constructor(
        val repository: EnderecoRepository
) {

    fun obter(id: Long) : Endereco? {
        return repository.findByIdOrNull(id)
    }

    fun inserir(endereco: Endereco) : Endereco {
        return checkNotNull( repository.save(endereco) )
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun listar() : Iterable<Endereco> {
        return repository.findAll().toMutableList()
    }

    fun atualizar(obj: Endereco) : Endereco? {
        this.obter(obj.id!!) ?: throw IllegalArgumentException("Endereco nao encontrado para atualização")
        return repository.save(obj)
    }
}