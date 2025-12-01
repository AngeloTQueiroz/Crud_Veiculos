// Pega o ID da URL
const urlParams = new URLSearchParams(window.location.search);
const clienteId = urlParams.get('id');


// Busca os clientes, primeiramente tras todos
fetch('http://localhost:8080/clientes')
    .then(function(resposta) {
        return resposta.json();
    })
    .then(function(clientes) {
        // Filtra os clientes pelo ID, usando a função filter do javascrpit. como é uma aplicação pequena isso n sera problema
        var clientesFiltrados = clientes.filter(function(cliente) {
            return cliente.id == clienteId;
        });

        // Pega o primeiro cliente filtrado
        var cliente = clientesFiltrados[0];

        if (cliente) {
            document.getElementById('editarNome').value = cliente.nome;
            document.getElementById('editarEmail').value = cliente.email;
            document.getElementById('editarSaldo').value = cliente.saldo;

        }
    });


    function salvar() {
        var nome = document.getElementById('editarNome').value;
        var email = document.getElementById('editarEmail').value;
        var saldo = document.getElementById('editarSaldo').value;

        // Cria objeto com dados
        var dados = {
            nome: nome,
            email: email,
            saldo: Number(saldo)
        };

        // Envia para servidor
        fetch('http://localhost:8080/clientes/' + clienteId, {
            method: 'PUT',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(dados)
        })
        .then(function() {
            alert('Salvo!');
            window.location = 'admin.html';
        });
    }