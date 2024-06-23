# Hibernate
## Introdução ao Hibernate e JPA

O Hibernate é um framework de persistência de objetos para Java. Ele fornece uma maneira muito direta de mapear objetos Java para tabelas de banco de dados, e vice-versa.
Com o Hibernate, você pode trabalhar com dados de banco de dados em um nível mais abstrato do que comparado ao JDBC, utilizando objetos Java. Ele se encarrega de lidar com a comunicação com o banco de dados, fazendo o mapeamento entre os objetos e a estrutura e tabelas do banco de dados.

## O que é o Hibernate?
O Hibernate é um framework de mapeamento *objeto/relacional* (ORM)* para Java. Ele facilita a interação entre objetos Java e bancos de dados relacionais, automatizando tarefas complexas como mapeamento de objetos para tabelas, gerenciamento de transações e consultas.
O Hibernate oferece uma camada de abstração sobre o JDBC, permitindo que os desenvolvedores trabalhem com objetos Java ao invés de SQL puro. Isso simplifica o desenvolvimento, aumenta a produtividade e torna o código mais fácil de manter.

* *ORM* (Object/Relational Mapping) ou em português Mapeamento Objeto/Relacional.

  Arquitetura
  O Hibernate é um framework que fica entra a camada de acesso de dados e o banco relacional. Os dados são manipulados no banco de dados através das APIs do Hibernate.


  ![image](https://github.com/lschlestein/hibernate/assets/103784532/b95ef724-0b6f-4dda-a6d1-9989ab5c5496)

  Através de um  provedor *Jakarta Pesistence*, o framework implementas as especificações da API Java Persistence e suas associações, conforme o diagrama a seguir:
  ![image](https://github.com/lschlestein/hibernate/assets/103784532/7f8e86f0-8dd0-412f-9073-7e8a30eea826)

SessionFactory (org.hibernate.SessionFactory)
Uma representação thread-safe (e imutável) do mapeamento do modelo de domínio do aplicativo para um banco de dados. Atua como uma fábrica de instâncias da *org.hibernate.Session* . O *EntityManagerFactory* é o equivalente a uma SessionFactory do Jakarta Persistence e basicamente, e suaus implementações são similares SessionFactory.

A criação da fábrica SessionFactory utiliza muitos recursos computacionais, portanto, para qualquer banco de dados, o aplicativo deve ter apenas um arquivo SessionFactory. A fábrica SessionFactory mantém os serviços que o Hibernate usa em todos Session(s), como caches de segundo nível, pools de conexões, integrações de sistemas de transações, etc.

Sessão (org.hibernate.Session)
Um objeto de thread único e de curta duração que modela conceitualmente uma "Unidade de Trabalho" ( PoEAA ). Na nomenclatura Jakarta Persistence, o Session é representado por um EntityManager.

Uma Session, por baixo dos panos envolve um JDBC java.sql.Connection e atua como uma fábrica de instâncias da org.hibernate.Transaction . Ela mantém um contexto de persistência geralmente de "leitura repetível" (cache de primeiro nível) do modelo de domínio do aplicativo.

Transação ( org.hibernate.Transaction)
Um objeto de thread único e de curta duração usado pelo aplicativo para demarcar limites de transações físicas individuais. A EntityTransaction é o equivalente do Jakarta Persistence e ambos atuam como uma API de abstração para isolar o aplicativo do sistema de transação subjacente em uso (JDBC ou JTA).



Mas o que faz que é ORM?
![image](https://github.com/lschlestein/hibernate/assets/103784532/113a22ec-b013-4b2e-839b-22a857f842dd)

Por que utilizar Hibernate?

- O Hibernate simplifica o acesso a dados, reduzindo o código *boiler plate* podendo assim o desenvolvedoR se focar na regra de negócios. Isso permite que você construa aplicações com mais rapidez e eficiência.
- O Hibernate oferece recursos avançados como transações, gerenciamento de cache e otimização de consultas, que contribuem para a criação de aplicações mais robustas e performáticas, se comparadas ao JDBC.
- O Hibernate é superior ao JDBC, seja pela redução no tempo de desenvolvimento, bem como em perfomance nas operações de persistência de dadaos.

Operações CRUD com Hibernate

O Hibernate simplifica a realização de operações CRUD (Create, Read, Update, Delete) em bases de dados. Com o framework, você pode executar essas operações em objetos Java, sem a necessidade de escrever código SQL.
Para criar um novo registro, use o método *save()*. Para ler um registro, use o método *get()*. Para atualizar um registro, use o método *update()*. E para deletar um registro, use o método *delete()*.
Fontes:

## Mapeamento de objetos para tabelas

Com o Hibernate a interação entre objetos Java e tabelas de banco de dados fica mais transparente. Ele abstrai a complexidade do mapeamento manual de objetos, permitindo que você trabalhe com seus objetos Java como se o banco de dados também fosse orientado a objetos.

1 - Definição de entidades
Você define suas entidades Java, representando as tabelas do seu banco de dados. Cada classe Java corresponde a uma tabela, e seus atributos correspondem às colunas.

2 - Mapeamento de atributos
O Hibernate utiliza anotações ou arquivos XML para mapear os atributos de suas entidades com as colunas correspondentes nas tabelas do banco de dados.

3 - Gerenciamento de relacionamentos
Ele suporta diferentes tipos de relacionamentos entre entidades, como um-para-um, um-para-muitos e muitos-para-muitos, permitindo que você modele relacionamentos complexos entre suas tabelas.
Essa capacidade de mapeamento facilita o desenvolvimento e a manutenção de aplicações, pois você pode se concentrar na regra do negócio sem se preocupar com os detalhes do mapeamento entre objetos e tabelas. Com o Hibernate, você terá um código mais legível, mais fácil de manter e com menos chances de erros.

## Hibernate Query Language (HQL)

HQL é uma linguagem de consulta orientada a objetos, que permite aos desenvolvedores consultar e manipular dados persistidos no banco de dados de forma mais intuitiva e independente da estrutura do banco de dados. É uma linguagem poderosa e flexível, semelhante ao SQL, mas com sintaxes e funcionalidades específicas para a manipulação de objetos. 
A grande vantagem em se utilizar HQL, é que por exemplo, em caso de troca da base dados em utilização, não há necessidade de reescrita das consultas SQL, pois isso é feito pelo próprio Framework, ao se configurar o novo dialeto.
https://thorben-janssen.com/jpql/
https://www.tutorialspoint.com/jpa/jpa_jpql.htm

## Transações e gerenciamento de sessão

O Hibernate fornece mecanismos para gerenciar transações e sessões, garantindo a integridade e a consistência dos dados. Transações encapsulam um conjunto de operações que devem ser executadas como uma unidade atômica, ou seja, todas as operações devem ser concluídas com sucesso ou nenhuma delas é efetivada. O gerenciamento de sessões é crucial para controlar o ciclo de vida dos objetos e a interação com o banco de dados.

O Hibernate oferece diferentes abordagens para lidar com transações, como gerenciamento de transações por meio da API JTA (Java Transaction API) ou usando transações programadas. O gerenciamento de sessões é normalmente feito por meio de um padrão de fábrica, permitindo a criação e o fechamento de sessões conforme necessário.


[Getting Started with Hibernate](https://docs.jboss.org/hibernate/orm/6.3/quickstart/html_single/])
