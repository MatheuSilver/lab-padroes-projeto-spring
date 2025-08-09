package one.digitalinnovation.gof.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    // Busca clientes pela cidade (localidade) do endereço
    List<Cliente> findByEnderecoLocalidade(String localidade);

    // Busca clientes pelo bairro
    List<Cliente> findByEnderecoBairro(String bairro);
}