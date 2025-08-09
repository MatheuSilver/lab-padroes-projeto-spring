package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Cliente;
import java.util.Optional;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author falvojr
 */
public interface ClienteService {

    /**
     * Retorna todos os clientes cadastrados.
     *
     * @return Iterable com todos os clientes.
     */
    Iterable<Cliente> buscarTodos();

    /**
     * Busca um cliente pelo seu ID.
     *
     * @param id identificador único do cliente
     * @return Optional contendo o cliente, se encontrado.
     */
    Optional<Cliente> buscarPorId(Long id);

    /**
     * Insere um novo cliente no sistema.
     * Caso o endereço não exista no banco, será buscado na API ViaCEP.
     *
     * @param cliente dados do cliente a ser inserido.
     */
    void inserir(Cliente cliente);

    /**
     * Atualiza um cliente existente.
     * Caso o endereço seja diferente, será atualizado também.
     *
     * @param id identificador do cliente a ser atualizado.
     * @param cliente dados atualizados do cliente.
     */
    void atualizar(Long id, Cliente cliente);

    /**
     * Remove um cliente pelo ID.
     *
     * @param id identificador do cliente a ser removido.
     */
    void deletar(Long id);
}