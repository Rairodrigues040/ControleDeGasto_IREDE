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
  <img src="assets/Captura_home_vazia.png" width="200" alt="Home Vazia"/>
  <img src="assets/Captura_nova_despesa.png" width="200" alt="Nova Despesa"/>
  <img src="assets/Captura_home_cheia.png" width="200" alt="Home com Gastos"/>
  <img src="assets/Captura_home_filtrada.png" width="200" alt="Home Filtrada"/>
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
