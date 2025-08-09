package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.service.dto.EnderecoDTO;
import org.springframework.stereotype.Component;

@Component
public class ViaCepServiceFallback implements ViaCepService {
    @Override
    public EnderecoDTO consultarCep(String cep) {
        // Retorna um endereço vazio ou um valor padrão
        EnderecoDTO endereco = new EnderecoDTO();
        endereco.setCep(cep);
        endereco.setLocalidade("Indisponível");
        return endereco;
    }
}
