# 🏢 API CEP Java

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![GSON](https://img.shields.io/badge/GSON-Library-4CAF50?style=flat-square)
![API REST](https://img.shields.io/badge/API%20REST-ViaCEP-2196F3?style=flat-square)
![MVC](https://img.shields.io/badge/Pattern-MVC-FF9800?style=flat-square)
![Status](https://img.shields.io/badge/Status-Active-brightgreen?style=flat-square)

**Consumidor de API de CEP com histórico de buscas e padrão MVC**

[Sobre](#-sobre) • [Estrutura](#-estrutura-do-projeto) • [Como Usar](#-como-usar) • [Dependências](#-dependências) • [Exemplos](#-exemplos-de-uso)

</div>

---

## 📖 Sobre

Sistema console interativo que consome a **API ViaCEP** para buscar informações de endereços por CEP. Desenvolvido com **padrão MVC**, desserialização JSON via **GSON** e histórico de buscas persistido em **ArrayList**.

Projeto acadêmico para a disciplina de **Técnica de Programação II** no curso **Desenvolvimento de Software Multiplataforma (DSM)** da **FATEC Praia Grande**.

---

## 📂 Estrutura do Projeto

```
API_Cep_Java/
│
├── 📄 README.md
├── 📄 API_Cep_Java.iml
├── 📄 .gitignore
│
└── 📁 src/
    └── 📁 br/edu/fatecpg/tecprog2/api_cep/
        │
        ├── 📁 model/
        │   └── 🔹 Endereco.java              # Classe modelo com atributos e getters/setters
        │
        ├── 📁 service/
        │   └── 🔹 ConsomeApi.java            # Serviço que faz requisição HTTP para ViaCEP
        │
        └── 📁 view/
            └── 🔹 Main.java                  # Ponto de entrada com menu e histórico
```

### 📋 Descrição dos Componentes

#### **model/**
- **Endereco.java** - Classe modelo que mapeia os dados retornados pela API
  - Atributos: `cep`, `logradouro`, `bairro`, `localidade`, `estado`
  - Getters e setters para cada atributo
  - Método `toString()` para exibição formatada

#### **service/**
- **ConsomeApi.java** - Classe responsável pela comunicação com a API ViaCEP
  - Método `buscaEndereco(String cep)` que faz requisição HTTP
  - Usa `HttpClient` e `HttpRequest` da Java 11+
  - Retorna a resposta JSON em formato `String`

#### **view/**
- **Main.java** - Classe principal com interface de console
  - Menu interativo com 4 opções
  - Integração com `Gson` para desserialização
  - Histórico de buscas usando `ArrayList<Endereco>`
  - Scanner para entrada de dados do usuário

---

## 🚀 Como Usar

### 1️⃣ Pré-requisitos

- **Java 11+** instalado (para HttpClient nativo)
- **GSON** library (Google JSON)

### 2️⃣ Download da Biblioteca GSON

**Opção A: Download Manual**

Acesse: [Google Gson Releases](https://github.com/google/gson/releases)

Baixe a versão mais recente (ex: `gson-2.10.1.jar`)

**Opção B: Maven**

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```

**Opção C: Gradle**

```gradle
dependencies {
    implementation 'com.google.code.gson:gson:2.10.1'
}
```

### 3️⃣ Compilação e Execução

**Linha de comando (Windows, Linux, Mac):**

```bash
# Navegar para o diretório do projeto
cd API_Cep_Java

# Compilar com GSON no classpath
javac -cp gson-2.10.1.jar -d bin src/br/edu/fatecpg/tecprog2/api_cep/**/*.java

# Executar
java -cp gson-2.10.1.jar:bin br.edu.fatecpg.tecprog2.api_cep.view.Main
```

**No IDE (Eclipse/IntelliJ):**

1. Importar projeto como Java Project
2. Adicionar `gson-2.10.1.jar` ao Build Path / Project Structure
3. Executar `Main.java`

---

## 📋 Exemplos de Uso

### Menu Principal

```
*API DE CONSULTA DE CEP* 
1 - Consultar CEP 
2 - Ver Consultados 
3 - Limpar Histórico 
4 - Sair 
Digite sua opção:
```

### Consultando um CEP

```
Digite sua opção: 1
Digite seu CEP: 01310100

CEP: 01310-100
Logradouro: Avenida Paulista
Bairro: Bela Vista
Localidade: São Paulo
Estado: SP

Endereco{cep='01310-100', logradouro='Avenida Paulista', bairro='Bela Vista', 
localidade='São Paulo', estado='SP'}
```

### Ver Histórico

```
Digite sua opção: 2

HISTÓRICO
Endereco{cep='01310-100', logradouro='Avenida Paulista', bairro='Bela Vista', localidade='São Paulo', estado='SP'}
Endereco{cep='02154-000', logradouro='Avenida Brasil', bairro='Pari', localidade='São Paulo', estado='SP'}
```

### Limpar Histórico

```
Digite sua opção: 3
Histórico limpo!
```

---

## 🛠 Tecnologias

| Tecnologia | Descrição |
|------------|-----------|
| **Java 11+** | Linguagem de programação |
| **GSON 2.10.1** | Desserialização JSON |
| **HttpClient** | Cliente HTTP nativo do Java |
| **ViaCEP API** | Dados de CEP (REST) |
| **MVC** | Padrão arquitetural |
| **ArrayList** | Histórico de buscas em memória |

---

## 📦 Dependências

### Obrigatória

- **GSON 2.10.1+**
  - 📥 Download: [github.com/google/gson](https://github.com/google/gson/releases)
  - 📚 Documentação: [gson.readthedocs.io](https://gson.readthedocs.io/)

### Java Runtime

- Java JDK 11 ou superior

---

## 🌐 API Utilizada

### ViaCEP

- **Base URL:** `http://viacep.com.br/ws/`
- **Endpoint:** `{CEP}/json/`
- **Exemplo:** `http://viacep.com.br/ws/01310100/json/`
- **Documentação:** [viacep.com.br](https://viacep.com.br/)

**Resposta JSON:**

```json
{
  "cep": "01310-100",
  "logradouro": "Avenida Paulista",
  "complemento": "",
  "bairro": "Bela Vista",
  "localidade": "São Paulo",
  "uf": "SP",
  "ibge": "3550308",
  "gia": "",
  "ddd": "11",
  "siafi": "7107"
}
```

---

## 🔧 Fluxo da Aplicação

```
┌─────────────┐
│   Main      │  (view) - Menu e interação com usuário
│  (Console)  │
└──────┬──────┘
       │ 1. Usuário digita CEP
       ▼
┌──────────────────┐
│  ConsomeApi      │  (service) - Busca dados na API
│  .buscaEndereco()│
└──────┬───────────┘
       │ 2. Retorna JSON
       ▼
┌──────────────────┐
│   Gson           │  Desserializa JSON
│  .fromJson()     │
└──────┬───────────┘
       │ 3. Retorna objeto Endereco
       ▼
┌──────────────────┐
│   Endereco       │  (model) - Objeto com dados
│   (Objeto)       │
└──────┬───────────┘
       │ 4. Adiciona ao ArrayList historico
       ▼
┌──────────────────┐
│  Exibe resultado │  (view) - Mostra dados formatados
│  no console      │
└──────────────────┘
```

---

## 💡 Funcionalidades

✅ Buscar CEP com validação  
✅ Histórico de buscas em ArrayList  
✅ Desserialização automática com GSON  
✅ Interface amigável no console  
✅ Tratamento básico de erros  
✅ Formatação de respostas  
✅ Menu interativo com 4 opções

---

## ⚙️ Requisitos de Sistema

| Requisito | Mínimo | Recomendado |
|-----------|--------|-------------|
| Java | 11 | 17+ |
| RAM | 128 MB | 512 MB+ |
| Disco | 50 MB | 100 MB+ |
| Conexão | Internet | Internet |

---

## 🐛 Troubleshooting

### ❌ "Class not found: com.google.gson.Gson"

**Solução:** Verifique se o GSON está no classpath
```bash
javac -cp gson-2.10.1.jar -d bin src/br/edu/fatecpg/tecprog2/api_cep/**/*.java
```

### ❌ "Main not found"

**Solução:** Certifique-se de usar o pacote completo
```bash
java -cp gson-2.10.1.jar:bin br.edu.fatecpg.tecprog2.api_cep.view.Main
```

### ❌ "CEP não encontrado"

**Solução:** Verifique se o CEP é válido (8 dígitos numéricos)

### ❌ "Erro de conexão"

**Solução:** Verifique sua conexão com a internet

---

## 📚 Referências

- [Google Gson GitHub](https://github.com/google/gson)
- [ViaCEP Documentação](https://viacep.com.br/)
- [Java 11+ HttpClient](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html)
- [RESTful API Best Practices](https://restfulapi.net/)

---

## 👩‍💻 Autor

**Carolina Ribeiro**

- 🔗 GitHub: [@caroldvlribeiro](https://github.com/caroldvlribeiro)
- 💼 FATEC Praia Grande - DSM

---

## 📄 Licença

Este projeto é de código aberto e pode ser utilizado livremente para fins educacionais.

---

<div align="center">

**Desenvolvido com ☕ Java e ❤️ para FATEC Praia Grande**

*DSM - Desenvolvimento de Software Multiplataforma*

*Técnica de Programação II*

</div>