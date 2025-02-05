# Sistema da Bilioteca

As classes separadas de gerenciamento de dados da bilbioteca tem como objetivo fazer com que o código obedeça ao princípio da responsabilidade única. Além disso, ao criarmos classes as quais possuem função de gerenciamento, promovemos a terceirização de interações com classes de forma direta. Isso está diretamente relacionado ao baixo acoplamento, pois temos o encadeamento de classes para realização de tarefas. Além disso, o padrão creator é obedcido no sentido de que as classes gerenciadoras irão criar novas instâncias das classes sobre as quais possuem conhecimento. 

As classes de gerenciamento de dados da biblioteca são as seguintes:

## 1. GerenciadorDeComandos
- Adiciona comandos: Responsável por adicionar comandos ao sistema.
- Executa comandos: Executa os comandos inseridos pelo usuário e realiza as validações necessárias.

## 2. GerenciadorDeEmprestimos
- Realiza empréstimo: Valida e executa a operação de empréstimo de exemplares.
- Realiza devolução: Valida e executa a operação de devolução de exemplares.

## 3. GerenciadorDeReservas
- Realiza reserva: Valida e executa a operação de reserva de exemplares.
- Observa reservas de livro: Permite que um usuário se torne observador de reservas de um livro.

## 4. GerenciadorDeExibicao
- Mostra todos os dados do banco: Exibe todos os dados armazenados no banco de dados.
- Mostra dados do livro: Exibe os dados de um livro específico.
- Mostra dados do usuário: Exibe os dados de um usuário específico.
- Mostra notificações do usuário: Exibe as notificações de um usuário específico.

## SistemaBiblioteca
- Obtem instância: Garante que apenas uma instância do sistema seja criada (singleton).
- Adiciona comandos: Adiciona os comandos iniciais ao sistema.
- Executa comandos: Coordena a execução de comandos através do gerenciadorDeComandos.
- Realiza empréstimo: Coordena a operação de empréstimo através do gerenciadorDeEmprestimos.
- Realiza devolução: Coordena a operação de devolução através do gerenciadorDeEmprestimos.
- Realiza reserva: Coordena a operação de reserva através do gerenciadorDeReservas.
- Observa reservas de livro: Coordena a operação de observação de reservas através do gerenciadorDeReservas.
- Mostra todos os dados do banco: Coordena a exibição de todos os dados do banco através do gerenciadorDeExibicao.
- Mostra dados do livro: Coordena a exibição de dados de um livro específico através do gerenciadorDeExibicao.
- Mostra dados do usuário: Coordena a exibição de dados de um usuário específico através do gerenciadorDeExibicao.
- Mostra notificações do usuário: Coordena a exibição de notificações de um usuário específico através do gerenciadorDeExibicao.
