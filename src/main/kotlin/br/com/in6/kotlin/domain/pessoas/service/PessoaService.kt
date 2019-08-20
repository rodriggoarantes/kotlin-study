package br.com.in6.kotlin.domain.pessoas.service

import br.com.in6.kotlin.domain.enderecos.Endereco
import br.com.in6.kotlin.domain.enderecos.service.EnderecoService
import br.com.in6.kotlin.domain.pessoas.Pessoa
import br.com.in6.kotlin.domain.pessoas.repository.PessoaRepository
import br.com.in6.kotlin.domain.usuarios.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PessoaService @Autowired constructor(
        val repository: PessoaRepository,
        val usuarioRepository: UsuarioRepository,
        val enderecoService: EnderecoService
) {

    fun obter(id: Long) : Pessoa? {
        return repository.findByIdOrNull(id)
    }

    @Transactional
    fun inserir(pessoa: Pessoa) : Pessoa {
        pessoa.usuario?.let {
            pessoa.usuario = usuarioRepository.findByIdOrNull(it.id)
        }
        pessoa.emails?.forEach { it.pessoa = pessoa }
        pessoa.telefones?.forEach { it.pessoa = pessoa }
        pessoa.redeSociais?.forEach { it.pessoa = pessoa }

        val enderecos : MutableList<Endereco> = mutableListOf()
        pessoa.enderecos?.let {
            it.forEach { end ->
                val founded: Endereco
                if (end.id > 0) {
                    founded = enderecoService.atualizar(end)
                } else {
                    founded = enderecoService.inserir(end)
                }
                enderecos.add(founded)
            }
        }
        pessoa.enderecos = enderecos
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