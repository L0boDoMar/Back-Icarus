function opcoesConta() {
    const botaoConta = document.querySelector('.botao-conta');
    const opcoesConta = document.querySelector('.opcoes-conta');

    botaoConta.addEventListener('click', () => {
            opcoesConta.classList.toggle("active");
    });
}

opcoesConta();