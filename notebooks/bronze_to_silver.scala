// Databricks notebook source
// MAGIC %md 
// MAGIC
// MAGIC **Conferindo se os dados foram montados e se temos acesso a pasta bronze**

// COMMAND ----------

// MAGIC %python 
// MAGIC
// MAGIC dbutils.fs.ls("/mnt/dados/bronze")

// COMMAND ----------

// MAGIC %md 
// MAGIC
// MAGIC ## Lendo os dados na camada bronze

// COMMAND ----------

val path = "dbfs:/mnt/dados/bronze/dataset_imoveis/"
val df = spark.read.format("delta").load(path)
display(df)


// COMMAND ----------

// MAGIC %md 
// MAGIC
// MAGIC ## Transformando os campos do json em colunas

// COMMAND ----------

display(df.select("anuncio.*"))

// COMMAND ----------

display(
  df.select("anuncio.*", "anuncio.endereco.*")
)

// COMMAND ----------

val dados_detalhados = df.select("anuncio.*", "anuncio.endereco.*")
display(dados_detalhados)

// COMMAND ----------

// MAGIC %md 
// MAGIC
// MAGIC ## Removendo colunas

// COMMAND ----------

val df_silver = dados_detalhados.drop("caracteristicas", "endereco")
display(df_silver)

// COMMAND ----------

// MAGIC %md 
// MAGIC
// MAGIC ## Salvando na camada silver

// COMMAND ----------

val path = "dbfs:/mnt/dados/silver/dataset_imoveis"
df_silver.write.format("delta").mode("overwrite").save(path)

// COMMAND ----------

// MAGIC %python
// MAGIC
// MAGIC display(dbutils.fs.ls("dbfs:/mnt/dados/silver/"))

// COMMAND ----------


