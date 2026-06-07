# 💰 Controle de Gastos

**Desenvolvedor:** Raí da Silva Rodrigues  
**E-mail:** rairodrigues@alu.ufc.br  
**Data de Entrega:** 07 de Junho de 2026  

---

## 📌 Sobre o Projeto

### Justificativa da Escolha do Tema
A educação financeira e o controle de despesas diárias são desafios comuns na vida da maioria das pessoas, especialmente na rotina de estudantes universitários. A escolha do tema "Controle de Gastos" se deu pela utilidade prática e real do aplicativo, além de ser um excelente cenário para aplicar operações de banco de dados (CRUD) de forma visual e interativa.

### Descrição do Funcionamento
O aplicativo é um gerenciador financeiro simples e direto, desenhado para registrar despesas de forma ágil. Suas principais funcionalidades incluem:
* **Dashboard (Home):** Exibe o valor total gasto e a contagem de despesas.
* **Filtros por Categoria:** O usuário pode visualizar "Todos" os gastos ou filtrar rapidamente pelas categorias "Lazer", "Transporte" e "Alimentação".
* **Adição de Despesas:** Uma tela dedicada para inserir a descrição, o valor monetário e selecionar a categoria do gasto.
* **Exclusão de Despesas:** Possibilidade de deletar um registro com um simples clique no ícone de lixeira, com atualização do saldo em tempo real.
* **Persistência Offline:** Todos os dados são salvos no banco de dados local do dispositivo.

---

## 📱 Demonstração

### Vídeo de Funcionamento
*(Clique na imagem abaixo para assistir ao vídeo demonstrando o fluxo completo de adição, filtragem e exclusão de gastos no YouTube)*

[![Demonstração do Aplicativo](https://img.youtube.com/vi/-QhgwStyaKc/0.jpg)](https://youtube.com/shorts/-QhgwStyaKc?feature=share)

### Telas do Aplicativo

<div align="center">
  <img width="335" height="685" alt="Captura de tela 2026-06-07 185055" src="https://github.com/user-attachments/assets/29235ad7-074a-4ab5-8886-cc31842ed563" />
  <img width="337" height="679" alt="Captura de tela 2026-06-07 185106" src="https://github.com/user-attachments/assets/36057383-9079-49ee-a09b-110c62d00496" />
  <img width="339" height="686" alt="Captura de tela 2026-06-07 185132" src="https://github.com/user-attachments/assets/67e5574e-becd-4a80-ab9c-f569c47351fd" />
  <img width="336" height="691" alt="Captura de tela 2026-06-07 185140" src="https://github.com/user-attachments/assets/ea562eba-3a42-4fe7-a625-f259e821a1d4" />
  <img width="333" height="679" alt="Captura de tela 2026-06-07 185206" src="https://github.com/user-attachments/assets/6b9fafe2-6ea9-4b86-bc30-72547ef5f84c" />
  <img width="332" height="694" alt="Captura de tela 2026-06-07 185211" src="https://github.com/user-attachments/assets/3831d8b7-3312-4dc5-9a1e-5d247d9e8916" />
  <img width="337" height="681" alt="Captura de tela 2026-06-07 185219" src="https://github.com/user-attachments/assets/47db9389-7ff7-454b-9239-4662190c6629" />
  <img width="333" height="695" alt="Captura de tela 2026-06-07 185225" src="https://github.com/user-attachments/assets/bd17ded5-7910-48b5-92a6-1ab6e0e0cb3a" />
  <img width="370" height="754" alt="Captura de tela 2026-06-07 185036" src="https://github.com/user-attachments/assets/5da2ba8d-2e31-4ab2-9fd6-05ec91f6b85c" />

</div>

> **Nota:** *Para visualizar as imagens no repositório local, certifique-se de que os arquivos estão salvos na pasta `assets/`.*

---

## ✅ Requisitos Técnicos Obrigatórios (Atendidos)

O aplicativo foi desenvolvido seguindo todos os requisitos mínimos exigidos para a entrega:

- [x] **Interface (UI):** Foram desenvolvidas 2 telas em Jetpack Compose (`HomeScreen` e `AdicionarDespesaScreen`).
- [x] **Navegação:** Implementada navegação fluida entre as telas utilizando o `Navigation Compose` (`AppNavHost`).
- [x] **Persistência Local:** Banco de dados construído com `Room Database`, contendo tabelas (entidades) interligadas para `Despesas` e `Categorias`.
- [x] **Arquitetura:** Padrão **MVVM** (Model-View-ViewModel) aplicado com rigor, separando responsabilidades.
- [x] **Linguagem:** 100% desenvolvido em **Kotlin**.

---

## 🏗️ Arquitetura e Organização do Código

O projeto foi refatorado para seguir as melhores práticas do desenvolvimento Android moderno, agrupando arquivos por *features* (funcionalidades) e separando a interface da lógica de negócios e dados.

```text
com.rai.gasto
├── data/               # Camada de Dados
│   ├── local/          # Banco de Dados Room (AppDatabase, DAOs, Entities)
│   ├── model/          # Modelos de domínio puros (Despesa, Categoria)
│   └── repository/     # Repositório (DespesaRepository - Fonte única da verdade)
├── rotas/              # Configuração do Navigation Compose
└── ui/                 # Camada de Apresentação (View)
    ├── componente/     # Componentes reutilizáveis (Card, Chips, Itens de Lista)
    ├── feature/
    │   ├── home/       # Agrupamento da Home (Screen, ViewModel, Factory, UiState)
    │   └── adicionar/  # Agrupamento da Adição (Screen, ViewModel, Factory, UiState)
    └── theme/          # Tipografia, Cores e Tema do Compose
