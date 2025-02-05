# Classes e interfaces relacionados aos usuários

No momento, o sistema da biblioteca possui três tipos de usuário: Aluno de graduação, aluno de pós-graduação e professor. Nesse sentido, 3 classes são criadas, cada uma representando um tipo de usuário e fazendo com que o código obedeça ao princípio de responsabilidade única, pois cada classe promove o gerenciamento de usuários diferentes de acordo com suas especificidades. Além disso, a criação de interfaces as quais são estendidades pelas clases permite que o algoritmo obedeça o padrão Aberto/Fechado e promove a Segregação de Interfaces. 

O princípio Aberto/Fechado está relacionado ao fato de as interfaces diminuírem a dependência entre classes e a Segregação de Interfaces é obedecida pelo fato de cada interface ter métodos específicos às classes que as estendem.

Além disso, o padrão Creator é aplicado no sentido de que as interfaces e, consequentemente, as classes que as herdam, criam instâmcias das classes _Reserva_ e _Empréstimo_, as quais são ativamente utilizadas noos métodos relacionados.
