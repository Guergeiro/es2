# O Padrão de Desenho Composite

O padrão [Composite](https://sourcemaking.com/design_patterns/composite) é um [padrão estrutural](https://sourcemaking.com/design_patterns/structural_patterns) que permite executar operações num objeto sem lidar diretamente com a hierarquia de objetos. Este padrão utiliza **composição recursiva numa estrutura em árvore de objetos relacionados hierarquicamente**. Esta estrutura permite processar objetivos primitivos e compósitos. Enquanto os objetos primitivos são indivisíveis, os objetos compósitos podem ser decompostos em outros compósitos ou objetivos primitivos.

Uma **escola** é um exemplo de um **compósito** que pode ser dividido em outros compósitos (e.g., departamentos). Um **departamento** pode ser outro **compósito** de **cursos**. O **curso** pode ser outro compósito de alunos, enquanto que um **aluno** é um elemento **primitivo** (indecomponível).

Na estrutura do Composite, o **Component é definido numa classe abstrata** para representar objetos primitivos e objetos compósitos. As **restantes classes são subclasses do objeto Component**. A **interface da classe abstrata representa o denominador comum** de ambas classes derivadas.

![composite](./composite.png)

## Exercicio

Aplique o padrão **Composite** à descrição de opções de um **menu HTML**. O menu pode ter **opções** e **subopções**, no entanto, apenas as **opções finais têm links para páginas**.
