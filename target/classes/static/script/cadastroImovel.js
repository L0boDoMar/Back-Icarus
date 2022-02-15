// PROGRESS TUTORIAL CADASTRO IMOVEL 
const progress = document.querySelector('.progress');
const step = document.getElementsByClassName('step');
const input = document.getElementsByClassName('input');
const next = document.querySelector('.btn-next');
const previous = document.querySelector('.btn-previous');
let contadoraImovel = 0;
let width = 0;

if (contadoraImovel === 0) {
        step[0].classList.add('active');
}


next.addEventListener('click', () => {

        
                if (width < 100) {
                        width = width + 12;
                        progress.style.width = `${width}%`
                }
                
                step[contadoraImovel].classList.remove('active');
                contadoraImovel++;
                if (contadoraImovel >= step.length) {
                        contadoraImovel--
                }
                step[contadoraImovel].classList.add('active');

                if(step[contadoraImovel]== step.length){
                        
                
                
        }
        else{
            input[contadoraImovel].style.borderBottom="1px solid red";
        }
})



previous.addEventListener('click', () => {                   
        
        if (width >= 0) {
                width = width - 14;
                progress.style.width = `${width}%`;
        }
       
        step[contadoraImovel].classList.remove('active');
        contadoraImovel--;
        if (contadoraImovel < 0) {
                contadoraImovel++
        }
        step[contadoraImovel].classList.add('active');

      
        input[contadoraImovel].style.borderBottom="1px solid black";

        
});

// CALCULAR PREÇO DO IMOVEL POR METRO QUADRADO 

function calcularMetro(){
        let preco = document.querySelector('#preco');
        let tamanho = document.querySelector('#area');
        let inputTotal = document.querySelector('#total');
        let button = document.getElementsByClassName('button');
        let total =0;
   
        button[1,2].addEventListener('click', () =>{
                total = preco.value/tamanho.value;
                inputTotal.value=total;
                console.log(inputTotal.value);
        });
}

     calcularMetro();

//API

function limpa_formulário_cep() {
        //Limpa valores do formulário de cep.
        document.getElementById('rua').value=("");
        document.getElementById('bairro').value=("");
        document.getElementById('cidade').value=("");
       
    }
    
    function meu_callback(conteudo) {
    if (!("erro" in conteudo)) {
        //Atualiza os campos com os valores.
        document.getElementById('rua').value=(conteudo.logradouro);
        document.getElementById('bairro').value=(conteudo.bairro);
        document.getElementById('cidade').value=(conteudo.localidade);
        
    } //end if.
    else {
        //CEP não Encontrado.
        limpa_formulário_cep();
        alert("CEP não encontrado.");
    }
    }
    
    function pesquisacep(valor) {
    
    //Nova variável "cep" somente com dígitos.
    var cep = valor.replace(/\D/g, '');
    
    //Verifica se campo cep possui valor informado.
    if (cep != "") {
    
        //Expressão regular para validar o CEP.
        var validacep = /^[0-9]{8}$/;
    
        //Valida o formato do CEP.
        if(validacep.test(cep)) {
    
            //Preenche os campos com "..." enquanto consulta webservice.
            document.getElementById('rua').value="...";
            document.getElementById('bairro').value="...";
            document.getElementById('cidade').value="...";
            
    
            //Cria um elemento javascript.
            var script = document.createElement('script');
    
            //Sincroniza com o callback.
            script.src = 'https://viacep.com.br/ws/'+ cep + '/json/?callback=meu_callback';
    
            //Insere script no documento e carrega o conteúdo.
            document.body.appendChild(script);
    
        } //end if.
        else {
            //cep é inválido.
            limpa_formulário_cep();
            alert("Formato de CEP inválido.");
        }
    } //end if.
    else {
        //cep sem valor, limpa formulário.
        limpa_formulário_cep();
    }
    };



