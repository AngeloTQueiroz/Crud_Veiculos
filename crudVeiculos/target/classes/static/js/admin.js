async function listarClientes() {
    const url = "http://localhost:8080/clientes";

    const resposta = await fetch(url);
    const clientes = await resposta.json();

    const divLista = document.getElementById("listaClientes");

    <!-- aqui todo conteudo dinamico sera incrementado ->
    divLista.innerHTML = "";

    if (clientes.length === 0) {
        divLista.innerHTML = "<p>Nenhum cliente cadastrado.</p>";
        return;
    }

    let html = `
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Saldo</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
    `;

    clientes.forEach(c => {
        html += `
            <tr>
                <td>${c.id}</td>
                <td>${c.nome}</td>
                <td>${c.email}</td>
                <td>R$ ${c.saldo.toFixed(2)}</td>
                <td>
                   <a href="editarcliente.html?id=${c.id}"><button onclick="editarCliente(${c.id})">✏ Editar</button></a>
                    <button onclick="excluirCliente(${c.id})">🗑 Excluir</button>
                </td>
            </tr>
        `;
    });

    html += `</tbody></table>`;
    divLista.innerHTML = html;
}
