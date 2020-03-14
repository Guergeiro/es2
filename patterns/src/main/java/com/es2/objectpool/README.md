# O Padrão de Desenho Object Pool

A criação de pools de objetos é uma prática popular para aumentar a eficiência de aplicações onde o custo e a frequência de instanciação de classes são elevados e o número de objetos a ser utilizados é pequeno. A **eficiência** do processo de **criação de objetos** é assegurada pela **reutilização de objetos já existentes na pool**.

O padrão de desenho [Object Pool](https://sourcemaking.com/design_patterns/object_pool) é um [padrão estrutural](https://sourcemaking.com/design_patterns/structural_patterns) que define o design de uma pool de objetos. Um processo pode reutilizar objetos da pool quando estes já não forem utilizados por nenhum outro processo.

![objectpool](./objectpool.png)

De forma a evitar que um processo fique à espera de um objeto, a **pool pode criar novos objetos**. Para evitar desperdício de recursos do sistema, a pool deve implementar um mecanismo de **eliminação periódica de objetos**.

Para garantir uma política de criação de objetos coerente, a classe que implementa a pool deve ser [Singleton](../singleton).

## Exercicio

Aplique o padrão Object Pool à criação de uma **pool de conexões para a página do IPV**, utilizando objetos do tipo **HttpURLConnection**.

A pool é inicializada para não permitir mais do que **10 conexões por defeito**. De forma a evitar problemas de concorrência, esta classe deve ser desenhada para ser **thread-safe**.
