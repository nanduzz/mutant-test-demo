# Mutation Tests Demo

## Introdução

Este projeto visa mostrar alguns problemas que podemos encontrar durante o desenvolvimento
de testes de software ao focarmos apenas na cobertura de testes e não na qualidade deles.

A cobertura e testes apesar de ser um bom indicador da qualidade do software ainda 
pode ser enganosa. Geralmente plugins como o JaCoCo detectam se o teste passa por certo
ponto do código, porém, isso não é suficiente para garantir um teste de qualidade. Um teste
pode passar por certo ponto sem realmente testar os processos realziados.

O plugin [PiTest](https://pitest.org) existe para tentar solucionar este problema. Para isso
o plugin adiciona "mutações" nos testes em tempo de execução, tendo como objetivo que os testes 
falhem. Se após as mutações o resultado do teste for de sucesso, isso é um indicador de que 
alterações indesejadas no código podem passar despercebidas ao executarmos os testes unitários.

Ainda no meu ponto de vista pessoal, se alterarmos em algum ponto a regra de negócio os testes
devem começar a falhar, de modo que devam ser corrigidos para refletir a nova regra.

## Compilação e geração dos relatórios

Para a compilação e geração dos relatório acredito que seja necessário apenas possuir o 
Java JDK em versão maior ou igual a 11, e o Maven.
A compilaũão do projeto gerando os relatórios pode ser feita usando o seguinte comando na 
pasta raiz do projeto:

    $ mvn clean install

Isto deve limpar os arquivos compilados preexistentes, baixar dependencias ( se necessário )
compilar, gerar os relatórios e também irá instalar o .jar na pasta ~/.m2 . É possivel
alterar a phase do mavem em que os relatórios são gerados, porém, mantive nas configurações 
básicas do JaCoCo.

Após executar o comando o relatório do JaCoCo pode ser observado abrindo o arquivo:
    
    ./target/site/jacoco/index.html

Para gerar as mutações nos testes, e um relatório contendo os problemas encontrados ao executar
os testes bata executar o comando:
    
     mvn test-compile org.pitest:pitest-maven:mutationCoverage

Sempre que executado o comando gerará um novo relatório que pode ser visto em:

    ./target/pit-reports/[data-hora-invertida]/index.html

