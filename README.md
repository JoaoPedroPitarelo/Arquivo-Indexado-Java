# Trabalho 2°ADS - Arquivos Indexados - Aplicação de Gerenciamento Hospitalar 🏥📋


## Descrição


Esta aplicação simula arquivos indexados dentro de um gerenciamento hospitalar. A aplicação possuí as seguintes classes:

- *Cidade* : código_cidade, nome, UF

- *Especialidades Médicas* : código_especialidade, descrição

- *Médicos* : código_médico, nome, codigo_especialidade, endereço, telefone, codigo_cidade

- *Pacientes* : código_paciente, nome, endereço, codigo_cidade

- *CID* : código_CID, descrição

- *Medicamentos* : código_medicamento, descrição, quant_estoque, estoque_minimo, estoque_maximo, preço_unitario

- *Consultas* : código_consulta, código_paciente, código_médico, data, horario, cod_CID, cod_medicamento, qtde_medicamento

------------------------------------------------------------------------------------------------------------------------
### Instruções:

- [x] 1) Escreva funções específicas para a leitura dos dados das estruturas: Cidades, Especialidades, CID, Medicamentos.
																						                     
- [x] 2) Escreva uma função para permitir a inclusão de novos registros na tabela de Médicos.
																					 
- [x] 2.1) O programa deverá garantir que o código do médico a ser inserido não existe na tabela de Médicos.

- [x] 2.2) Quando o usuário digitar o código da especialidade, o programa deverá buscar este código na tabela de Especialidades e exibir a descrição.

- [x] 2.3) Quando o usuário digitar o código da cidade, o programa deverá buscar este código na tabela de Cidades e exibir o nome da cidade e UF.


- [x] 3) Escreva uma função para permitir a inclusão de novos registros na tabela de Pacientes.

- [x] 3.1) O programa deverá garantir que o código do paciente a ser inserido não existe na tabela de pacientes.

- [x] 3.2) Quando o usuário digitar o código da cidade, o programa deverá buscar este código na tabela de Cidades e exibir o nome da cidade e UF.


- [x] 4) Escreva uma função para permitir a exclusão de registros na tabela de Pacientes.

- [x] 4.1) O programa não deverá permitir a exclusão de pacientes que possuam consultas agendadas


- [x] 5) Escreva uma função para permitir a exclusão de registros na tabela de Médicos.

- [x] 5.1) O programa não deverá permitir a exclusão de médicos que possuam registros na tabela de consultas


- [x] 6) Escreva uma função para permitir o agendamento de uma consulta.

- [x] 6.1) Quando o usuário digitar o código do paciente, o programa deverá buscar este código na tabela de Pacientes e exibir o nome do paciente e o nome da cidade e UF.

- [x] 6.2) Quando o usuário digitar o código do médico, o programa deverá buscar este código na tabela de Médicos e exibir o nome do médico e a descrição da especialidade.

- [x] 6.3) Quando o usuário digitar o código CID, o programa deverá buscar este código na tabela de CID e exibir a descrição.

- [x] 6.4) Quando o usuário digitar o código do medicamento, o programa deverá buscar este código na tabela de Medicamentos e exibir a descrição.

- [x] 6.5) Quando o usuário digitar a qtde_medicamento, o programa deverá acessar a tabela de Medicamentos e verificar se a quantidade em estoque é suficiente para atender a quantidade receitada na consulta.

- [x] 6.5.1) O programa não deverá permitir a digitação de uma quantidade maior do que a quantidade disponível em estoque.

- [x] 6.6) A quantidade do medicamento receitada deverá ser subtraída da quantidade em estoque do medicamento.


- [x] 7) Escreva uma função para permitir ao usuário consultar os dados de determinado medicamento.

- [x] 7.1) Para cada medicamento consultado, exibir: todos os seus dados e o valor total em estoque do medicamento (quant_estoque * preço_unitário).


- [x] 8) Escreva uma função para exibir todos os registros da tabela de medicamentos que estejam com a quantidade em estoque abaixo do estoque mínimo.

- [x] 8.1) As seguintes informações devem ser exibidas: código, descrição, qtde estoque, estoque máximo, qtde a ser comprada, valor da compra.

- [x] 8.1.1) A quantidade a ser comprada é calculada subtraindo o estoque máximo da quantidade em estoque.

- [x] 8.2) Ao final, a função deverá exibir o valor total a ser comprado.


- [x] 9) Escreva uma função para exibir o valor total arrecadado com todas as consultas, que deve ser calculado pelo valor de cada consulta (R$100) acrescido do valor do medicamento receitado para cada consulta.

- [x] 9.1) O valor do medicamento receitado para cada consulta deve ser calculado multiplicando a quantidade de medicamento receitada pelo preço unitário do medicamento.


- [x] 10) Escreva uma função para reorganização da tabela de Pacientes.
