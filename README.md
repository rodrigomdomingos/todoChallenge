# todoChallenge
To Do list
IDE: Eclipse
Tecnologias: JSF, MYSql, Hibernate, JPA, Spring Boot, Spring MVC, BootStrap 4, Primefaces, React.

No projeto foi utilizado o Spring Initializr, que nada mais é do que uma forma mais fácil de configurar o Spring Boot.
O maven e java foram selecionados, versão 2.0.7 com as dependências WEB, JPA, Mysql, Devtools.
Após download pelo Spring Initializr foi feita a importação no Eclipse, onde a configuração do hibernate, jpa, mysql já foi facilitada pelo Spring Boot. Mas, foi necessário fazer a configuração do Primefaces, BootStrap, Spring MVC e JSF no Maven.
As importações dos frameworks são visualizadas no pom.xml
A ordem de desenvolvimento foi:
Spring Boot -> Spring MVC -> JSF -> MYSql -> JPA -> Hibernate -> Primefaces -> BootStrap 4.
O React foi feito em um outro projeto:

Funcionamento:
Existe um (input + button) e embaixo uma Lista. Ao digitar uma tarefa e apertar no botão a tarefa é adicionada na lista, que é atualizada consultando o banco de dados. Na lista, em cada tarefa é possivel clicar em um botão 'Check' que retirar ela da lista, ou no botão 'Editar' que abre a edição do campo da tarefa, e após confirmar é salvo no banco de dados.

O projeto em React consome por url gerenciada pelo Spring MVC a lista retornada em JSON de todas as tarefas e adiciona novas tarefas.
