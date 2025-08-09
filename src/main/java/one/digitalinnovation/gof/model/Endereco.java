package one.digitalinnovation.gof.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import one.digitalinnovation.gof.service.dto.EnderecoDTO;

/**
 * Entidade Endereco persistida no banco de dados.
 * 
 * Padrões aplicados:
 * - Entity (JPA)
 * - Data Mapper (Hibernate mapeia para a tabela correspondente)
 * 
 * Observação:
 * - O mapeamento da API externa (ViaCEP) para esta entidade deve ser feito
 *   via DTO e Mapper, evitando acoplamento direto.
 */
@Entity
public class Endereco {

    @Id
    @NotBlank(message = "O CEP é obrigatório.")
    @Pattern(regexp = "\\d{8}", message = "O CEP deve conter exatamente 8 dígitos numéricos.")
    @Size(min = 8, max = 8)
    private String cep;

    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public Endereco() {
    }

    // Construtor de conveniência para conversão de DTO
    public Endereco(EnderecoDTO dto) {
        this.cep = dto.getCep();
        this.logradouro = dto.getLogradouro();
        this.complemento = dto.getComplemento();
        this.bairro = dto.getBairro();
        this.localidade = dto.getLocalidade();
        this.uf = dto.getUf();
        this.ibge = dto.getIbge();
        this.gia = dto.getGia();
        this.ddd = dto.getDdd();
        this.siafi = dto.getSiafi();
    }

    // Getters e Setters
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getLocalidade() { return localidade; }
    public void setLocalidade(String localidade) { this.localidade = localidade; }

    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }

    public String getIbge() { return ibge; }
    public void setIbge(String ibge) { this.ibge = ibge; }

    public String getGia() { return gia; }
    public void setGia(String gia) { this.gia = gia; }

    public String getDdd() { return ddd; }
    public void setDdd(String ddd) { this.ddd = ddd; }

    public String getSiafi() { return siafi; }
    public void setSiafi(String siafi) { this.siafi = siafi; }

    // Implementação de equals e hashCode com base no CEP (chave primária)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco)) return false;
        Endereco that = (Endereco) o;
        return cep != null && cep.equals(that.cep);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
