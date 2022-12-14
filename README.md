
# Sistema de reserva de consultas

Implementamos um sistema que permite administrar a reserva/marcação
de consultas para uma clínica odontológica.


## Funcionalidades:

### 01. Paciente

    Cadastrar um paciente e seu respectivo endereço.
    Atualizar o cadastro de um paciente.
    Deletar o cadastro de um paciente

### 02. Dentista

    Cadastrar um dentista.
    Atualizar o cadastro de um dentista.

### 03. Consulta

    Permite que um paciente seja atribuído a uma consulta com um dentista em uma determinada data e hora.
    
### 04. Login

    Valida a entrada no sistema por meio de um login com nome de usuário e senha.
    Permite que qualquer pessoa logada registre uma consulta.
    Permite apenas aqueles que têm uma função de administração pode gerenciar dentistas e pacientes.

## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente.
Essas variáveis são para conectar ao banco de dados, no projeto usamos o MySQL.

`DB_MYSQL_USER`

`DB_MYSQL_PASSWORD`


## Dados:
- SQL que popula o banco;
- Arquivos JSON Postman => clinica_odontologica/src/main/resources/postman

## Stack utilizada

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![JUnit](https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Spring framework](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)


## Autores

- [@tatianegardin](https://github.com/tatianegardin)
- [@eddgh](https://github.com/eddgh)
- [@MicheliPinheiro](https://github.com/MicheliPinheiro)
- [@AmandaD-Reis](https://github.com/AmandaD-Reis)
- [@andre92am](https://github.com/andre92am)
- [@estudio7](https://github.com/estudio7)
