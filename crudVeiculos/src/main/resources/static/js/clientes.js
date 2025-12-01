function cadastrarCliente(event) {
    event.preventDefault(); // Só isso: não recarrega a página


    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const saldo = document.getElementById('saldo').value;

    //  objeto cliente
    const cliente = {
        nome: nome,
        email: email,
        saldo: saldo
    };

    // Enviar para API
    fetch('http://localhost:8080/clientes', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(cliente)
    })
    .then(response => response.json())
    .then(clienteSalvo => {
        console.log('Cliente salvo:', clienteSalvo);
        alert('Cliente cadastrado! ID: ' + clienteSalvo.id);
    });
}

// conecta ao formulário
document.getElementById('formCliente').addEventListener('submit', cadastrarCliente);