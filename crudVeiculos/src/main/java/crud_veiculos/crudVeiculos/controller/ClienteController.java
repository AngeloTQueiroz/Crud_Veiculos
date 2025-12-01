package crud_veiculos.crudVeiculos.controller;


import crud_veiculos.crudVeiculos.model.Cliente;
import crud_veiculos.crudVeiculos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// esta anotação quer dize que a classe vai receber requisições HTTP e retornar JSON
@RestController
// todas as URL desse controler serão /clientes, assim como os outros controlers suas proprias URL
@RequestMapping("/clientes")
public class ClienteController {

        // o Spring instancia pra mim o objeto, no caso esta instanciando um Cliente com as implementações do Cliente repository
        // como se fosse uma classe com as implemententações de uma interface, é literalmente isso.
        @Autowired
        private ClienteRepository clienteRepository;

        // CRIAR CLIENTE

        //Este metodo só sera acionando quando receber uma requisão POST, postar algo, criar algo. No caso criar o Cliente
    @PostMapping
        // @RequestBody = Corpo da requisição, ou seja ele le a requisicão que chega em JSON
        // e traduz de uma forma que o Java entenda oque é cada atributo
        // e ja cria o objeto com os parametros atribuidos
        public Cliente criarCliente(@RequestBody Cliente cliente) {
        // aqui fica visivel a funcao do repository, como ele implementa na classe(model) cliente,
        // chamamos ele diretamente agora pra salvar o cliente e assim sera feito com as outras funções
        return clienteRepository.save(cliente);
}
    // LISTAR CLIENTE

    // auto descritivo, vai ser chamado pra resquisições GET
    @GetMapping
            public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }


    // esse parametro de ID faz ele buscar o cliente certo, como se fosse um where no sql
    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable int id) {
        return clienteRepository.findById(id).orElse(null);
    }


    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable int id, @RequestBody Cliente novoCliente){
        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);

        // verica se exite cliente
        if (clienteExistente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteExistente.setNome(novoCliente.getNome());
        clienteExistente.setEmail(novoCliente.getEmail());
        clienteExistente.setSaldo(novoCliente.getSaldo());

        return clienteRepository.save(clienteExistente);
    }





}





