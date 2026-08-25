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

Sistema console interativo que consome a **API ViaCEP** para buscar informações completas de endereços. Desenvolvido com **padrão MVC**, desserialização JSON via **GSON** e histórico de buscas persistido em **ArrayList**.

Projeto acadêmico para a disciplina de **Técnica de Programação** no curso **Desenvolvimento de Software Multiplataforma (DSM)** da **FATEC Praia Grande**.

---

## 📂 Estrutura do Projeto

```
API_Cep_Java/
│
├── 📄 README.md
├── 📄 .gitignore
│
├── 📁 src/
│   ├── 📁 model/
│   │   └── 🔹 Endereco.java              # Modelo da resposta da API
│   │
│   ├── 📁 view/
│   │   ├── 🔹 MenuView.java              # Interface de menu principal
│   │   └── 🔹 ResultadoView.java         # Exibição de resultados
│   │
│   ├── 📁 controller/
│   │   └── 🔹 BuscaCepController.java    # Lógica de requisição à API
│   │
│   ├── 📁 service/
│   │   └── 🔹 ViaCepService.java         # Integração com ViaCEP
│   │
│   ├── 📁 util/
│   │   └── 🔹 GsonUtil.java              # Configuração GSON
│   │
│   └── 🔹 Main.java                      # Ponto de entrada
│
└── 📁 lib/
    └── 📦 gson-2.10.1.jar                # Dependência GSON
```

---

## 🚀 Como Usar

### 1️⃣ Pré-requisitos

- **Java 8+** instalado
- **GSON** library (inclusa ou para download)

### 2️⃣ Download da Biblioteca GSON

**Opção A: Download Manual**

Acesse: [Google Gson Releases](https://github.com/google/gson/releases)

Baixe a versão mais recente (ex: `gson-2.10.1.jar`) e coloque na pasta `/lib` do projeto.

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

**No terminal:**

```bash
# Navegar para o diretório do projeto
cd API_Cep_Java

# Compilar com GSON no classpath
javac -cp lib/gson-2.10.1.jar:src -d bin src/**/*.java

# Executar
java -cp lib/gson-2.10.1.jar:bin Main
```

**No IDE (Eclipse/IntelliJ):**

1. Importar projeto como Java Project
2. Adicionar `gson-2.10.1.jar` ao Build Path
3. Executar `Main.java`

---

## 📋 Exemplos de Uso

### Buscar CEP

```
╔════════════════════════════════╗
║   BUSCADOR DE CEP - ViaCEP    ║
╚════════════════════════════════╝

Digite um CEP (sem hífen):
> 01310100

✅ Resultado encontrado:

Logradouro: Avenida Paulista
Bairro:     Bela Vista
Cidade:     São Paulo
UF:         SP
CEP:        01310-100

```

### Menu Principal

```
[1] Buscar CEP
[2] Ver Histórico
[3] Limpar Histórico
[4] Sair

Escolha uma opção:
```

---

## 🛠 Tecnologias

| Tecnologia | Descrição |
|------------|-----------|
| **Java** | Linguagem de programação |
| **GSON** | Desserialização JSON |
| **ViaCEP API** | Dados de CEP (REST) |
| **MVC** | Padrão arquitetural |
| **ArrayList** | Histórico de buscas |

---

## 📦 Dependências

### Obrigatória

- **GSON 2.10.1+**
    - 📥 Download: [github.com/google/gson](https://github.com/google/gson/releases)
    - 📚 Documentação: [gson.readthedocs.io](https://gson.readthedocs.io/)
    - 🔗 Repositório: [github.com/google/gson](https://github.com/google/gson)

### Java Runtime

- Java JDK 8 ou superior

---

## 🌐 API Utilizada

### ViaCEP

- **Base URL:** `https://viacep.com.br/ws/`
- **Endpoint:** `{CEP}/json/`
- **Exemplo:** `https://viacep.com.br/ws/01310100/json/`
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

## 🔧 Configuração Avançada

### Adicionar GSON ao classpath permanentemente (Linux/Mac)

```bash
export CLASSPATH=$CLASSPATH:/caminho/para/gson-2.10.1.jar
```

### Windows

Adicionar ao `CLASSPATH` nas variáveis de ambiente:

```
C:\caminho\para\gson-2.10.1.jar
```

---

## 📝 Padrão MVC

```
MODEL          CONTROLLER          VIEW
─────────      ──────────          ────
Endereco.java  BuscaCepController  MenuView.java
              ↓                     ↓
              Consome API ────────→ Exibe Resultado
              ↑                     ↑
              └─────────────────────┘
                 ViaCepService
```

---

## 💡 Funcionalidades

✅ Buscar CEP com validação  
✅ Histórico de buscas em ArrayList  
✅ Desserialização automática com GSON  
✅ Interface amigável no console  
✅ Tratamento de erros  
✅ Formatação de respostas

---

## ⚙️ Requisitos de Sistema

| Requisito | Mínimo | Recomendado |
|-----------|--------|-------------|
| Java | 8 | 11+ |
| RAM | 128 MB | 512 MB+ |
| Disco | 50 MB | 100 MB+ |
| Conexão | Internet | Internet |

---

## 🐛 Troubleshooting

### ❌ "Class not found: com.google.gson.Gson"

**Solução:** Verifique se o GSON está no classpath
```bash
javac -cp gson-2.10.1.jar -d bin src/**/*.java
```

### ❌ "CEP não encontrado"

**Solução:** Verifique se o CEP é válido (formato: 8 dígitos)

### ❌ "Erro de conexão"

**Solução:** Verifique sua conexão com a internet

---

## 📚 Referências

- [Google Gson GitHub](https://github.com/google/gson)
- [ViaCEP Documentação](https://viacep.com.br/)
- [Java Documentation](https://docs.oracle.com/en/java/)
- [RESTful API Best Practices](https://restfulapi.net/)

---

## 👩‍💻 Autor

**Carolina Ribeiro**

- 🔗 GitHub: [@caroldvlribeiro](https://github.com/caroldvlribeiro)
- 💼 FATEC Praia Grande

---

## 📄 Licença

Este projeto é de código aberto e pode ser utilizado livremente para fins educacionais.

---

<div align="center">

**Desenvolvido com ☕ Java e ❤️ para FATEC Praia Grande**

*DSM - Desenvolvimento de Software Multiplataforma*

</div>