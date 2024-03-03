# Pipeline com databricks e Azure Dataa Factory

O projeto tem o intuito de criar um pipeline de dados utilizando o data factory e o databricks

O datalake foi criado seguindo a estrutura em medalhão
* Inbound;
* Bronze;
* Silver.

A camada Inboud é a camada de entrada de dados (ingestão), foi utilizado o Sacala e o Databricks para as transfoirmações bronze e silver e os dados foram salvos no formato Delta.

Foi utilizado o Data Fractory para orquestrar o fluxo de dados baseando-se em gatilhos de entrada de dados e intervalo de tempo.


## Tecnologias usadas:

* Azure Data Lake Storage Gen 2;
* Azure Databricks;
* Azure Data Factory;
* Scala.
