# Define a imagem base
FROM maven:3.6.3-openjdk-11

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia os arquivos necessários para o diretório de trabalho
COPY . .

# Executa o comando para construir o projeto (por exemplo, usando o Maven)
RUN mvn clean package

# Define o comando de inicialização do aplicativo
CMD ["java", "-jar", "target/meuapp.jar"]