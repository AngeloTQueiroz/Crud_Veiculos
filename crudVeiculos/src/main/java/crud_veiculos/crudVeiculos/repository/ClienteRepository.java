package crud_veiculos.crudVeiculos.repository;

import crud_veiculos.crudVeiculos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // com essa extensão da jpa, ele ja cria pra mim todas as implementações de criar, ler, atualizar e excluir. Como se fosse um pseudo SQL


}
