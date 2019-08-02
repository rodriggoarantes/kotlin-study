package br.com.in6.kotlin.domain.persons.service

import br.com.in6.kotlin.domain.persons.Pessoa
import br.com.in6.kotlin.domain.persons.repository.PessoaRepository
import br.com.in6.kotlin.domain.users.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PessoaService @Autowired constructor(
        val repository: PessoaRepository,
        val usuarioRepository: UsuarioRepository
) {

    fun obter(id: Long) : Pessoa? {
        return repository.findByIdOrNull(id)
    }

    fun inserir(pessoa: Pessoa) : Pessoa {
        pessoa.usuario?.let {
            pessoa.usuario = usuarioRepository.findByIdOrNull(it.id)
        }
        pessoa.emails?.forEach { it.pessoa = pessoa }
        pessoa.telefones?.forEach { it.pessoa = pessoa }
        pessoa.redeSociais?.forEach { it.pessoa = pessoa }

        return checkNotNull( repository.save(pessoa) )
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun listar() : Iterable<Pessoa> {
        return repository.findAll().toMutableList()
    }

    fun atualizar(usr: Pessoa) : Pessoa? {
        this.obter(usr.id!!) ?: throw IllegalArgumentException("PessoaResource nao encontrado para atualização")
        return repository.save(usr)
    }
}