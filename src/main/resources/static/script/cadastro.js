// Formulário

const etapa = document.getElementsByClassName('etapa');
const proximaEtapa = document.getElementsByClassName('botao-proximo');
const voltarEtapa = document.getElementsByClassName ('botao-voltar');
let etapaAtual = 0;

proximaEtapa[0].addEventListener('click', () => {
    
    etapa[etapaAtual].classList.remove('active');
    
    etapaAtual ++;

    etapa[etapaAtual].classList.add('active');
});

proximaEtapa[1].addEventListener('click', () => {
    
    etapa[etapaAtual].classList.remove('active');
    
    etapaAtual ++;

    etapa[etapaAtual].classList.add('active');
});

proximaEtapa[2].addEventListener('click', () => {
    
    etapa[etapaAtual].classList.remove('active');
    
    etapaAtual ++;

    etapa[etapaAtual].classList.add('active');
});

voltarEtapa[0].addEventListener('click', () => {
    
    etapa[etapaAtual].classList.remove('active');

    etapaAtual --;

    etapa[etapaAtual].classList.add('active');
});

voltarEtapa[1].addEventListener('click', () => {
    
    etapa[etapaAtual].classList.remove('active');

    etapaAtual --;

    etapa[etapaAtual].classList.add('active');
});