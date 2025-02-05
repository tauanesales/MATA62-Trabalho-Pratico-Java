# Classes de console

As classes desta pasta tem como objetivo gerenciar a interação entre usuários e o sistema. A classe _Interaction_ gerencia de forma geral esta interação. A classe _LimpezaTela_ tem como objetivo limpar a tela. As demais classes são relacionadas ao gerenciamento de mensagens, cada um com funcionalidades específicas. O objetivo desta segmentação é, principalmente, fazer com que o código se adeque ao princípio de responsabilidade única. Em relação às classes de gerenciamento de mensagens, temos as seguintes:

Entendi! Aqui estão as funcionalidades gerais de cada uma das classes:

### Mensagens
- Gerenciar todas as mensagens (ajuda, erro, sucesso, exibição de dados, etc.).

### MensagensAjuda
- Exibe a mensagem de ajuda com os comandos disponíveis.

### MensagensErro
- Exibe mensagens de erro com detalhes do usuário e do livro, se disponíveis.

### MensagensSucesso
- Exibe mensagens de sucesso com detalhes do usuário e do livro, se disponíveis.
- Exibe mensagens de sucesso com informações adicionais de empréstimo.

### ExibicaoDados
- Exibe todos os dados armazenados no banco de dados.
- Exibe as notificações de um usuário específico.
- Exibe os dados de um usuário específico, incluindo empréstimos e reservas.
- Exibe os dados de um livro específico, incluindo reservas e informações dos exemplares.
