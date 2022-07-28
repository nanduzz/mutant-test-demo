# Mutation Tests Demo

### Introdução

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


