# Classes e interfaces dos bancos de dados

A nova implementação do sistema de banco de dados para a biblioteca foi projetada para seguir os princípios de design e padrões de projeto estabelecidos. Abaixo, destacamos as funcionalidades gerais das interfaces e classes, e como o código se adequa aos padrões e princípios de design mencionados.

## Funcionalidades das Interfaces e Classes

### Interfaces:

1. _IBancoDeDados_: Define operações básicas de banco de dados, como `reset`, `insert`, `getAll`, `getFirstById` e `getAllById`.
2. _ILivroBancoDeDados_: Gerencia operações relacionadas a livros e exemplares, como `getLivro`, `livroExiste`, `getExemplares`, `getExemplaresDisponiveis`, `getExemplar`, `getExemplarDisponivelPorCodigoLivro`, `getExemplarEmprestado` e `temExemplarDisponivel`.
3. _IUsuarioBancoDeDados_: Define operações de gerenciamento de usuários, como `getUsuario`.
4. _IEmprestimoBancoDeDados_: Lida com operações de empréstimo, como `getEmprestimos`.
5. _IReservaBancoDeDados_: Gerencia operações de reserva, como `getReservasPorCodigoUsuario`, `getReservaAtiva` e `getReservasPorCodigoLivro`.

### Classes:

1. _BancoDeDados_: Implementa a interface `IBancoDeDados` e fornece uma instância singleton do banco de dados. Gerencia a inicialização e o reset do banco de dados, além das operações básicas de inserção e recuperação de dados.
2. _LivroBancoDeDados_: Implementa a interface `ILivroBancoDeDados` e gerencia operações relacionadas a livros e exemplares, utilizando o banco de dados fornecido.
3. _UsuarioBancoDeDados_: Implementa a interface `IUsuarioBancoDeDados` e gerencia operações de recuperação de usuários.
4. _EmprestimoBancoDeDados_: Implementa a interface `IEmprestimoBancoDeDados` e gerencia operações de empréstimos.
5. _ReservaBancoDeDados_: Implementa a interface `IReservaBancoDeDados` e gerencia operações de reservas.

## Adequação aos Padrões de Projeto

### 1. Padrões GRASP:

- Expert: As responsabilidades são atribuídas a classes que possuem a informação necessária para cumprir suas funções. Por exemplo, as classes _LivroBancoDeDados_, _UsuarioBancoDeDados_, _EmprestimoBancoDeDados_ e _ReservaBancoDeDados_ gerenciam as operações específicas de suas entidades porque têm acesso ao banco de dados centralizado.

- Creator: As classes que criam instâncias de outras classes são aquelas que agregam essas instâncias. Por exemplo, a classe _BancoDeDados_ cria instâncias das entidades do sistema (livros, usuários, empréstimos, reservas) e as armazena.

- Baixo Acoplamento: As responsabilidades são divididas entre várias interfaces e classes para reduzir o acoplamento. Cada classe gerencia uma responsabilidade específica, resultando em baixo acoplamento entre componentes.

### 2. Princípios de Projeto:

- Responsabilidade Única (SRP): Cada classe tem uma única responsabilidade. Por exemplo, _LivroBancoDeDados_ gerencia operações de livros, enquanto _UsuarioBancoDeDados_ lida com usuários.

- Inversão de Dependências (DIP): As classes dependem de abstrações (interfaces), não de implementações concretas. Isso permite que as classes sejam facilmente testadas e substituídas por diferentes implementações.

- Aberto/Fechado (OCP): O código é aberto para extensão, mas fechado para modificação. Novas funcionalidades podem ser adicionadas implementando novas classes ou interfaces, sem alterar o código existente.

- Segregação de Interface (ISP): As interfaces são específicas e não forçam os clientes a dependerem de métodos que não utilizam. Por exemplo, interfaces separadas para operações de livros, usuários, empréstimos e reservas.

## 3. Padrões de Projeto:

- Singleton: A classe _BancoDeDados_ segue o padrão Singleton, garantindo que apenas uma instância do banco de dados exista.

- Command: Embora o padrão Command não esteja explicitamente implementado, a separação de responsabilidades em diferentes classes e interfaces permite a execução de comandos específicos de forma encapsulada.

- Observer: O padrão Observer pode ser implementado no futuro para notificar as classes interessadas sobre mudanças no estado do banco de dados, como atualização de reservas ou empréstimos.

### Conclusão

A nova implementação segue os princípios de design e padrões de projeto modernos para criar um sistema modular, de fácil manutenção e extensível. Cada classe e interface tem uma responsabilidade clara, o que facilita a leitura e o entendimento do código, além de permitir futuras expansões e manutenções com menos risco de introdução de erros.
