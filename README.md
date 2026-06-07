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
 <img width="200" height="400" alt="Captura de tela 2026-06-07 185132" src="https://github.com/user-attachments/assets/d4abb798-e08a-46dd-b5ef-e9c7e272d021" />
 <img width="200" height="400" alt="Captura de tela 2026-06-07 185140" src="https://github.com/user-attachments/assets/571b633a-ea3c-46a7-9d89-7e35c4220f61" />
 <img width="200" height="400" alt="Captura de tela 2026-06-07 185055" src="https://github.com/user-attachments/assets/118375e9-961c-4401-94bd-f446a63d6f11" />


</div>

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
    ├── home/       # Agrupamento da Home (Screen, ViewModel, Factory, UiState)
    ├── adicionar/  # Agrupamento da Adição (Screen, ViewModel, Factory, UiState)
    └── theme/          # Tipografia, Cores e Tema do Compose
````

🧠 Uso de Inteligência Artificial

Durante o ciclo de desenvolvimento, ferramentas de Inteligência Artificial generativa, especificamente ChatGPT e Google Gemini, foram utilizadas como assistentes de codificação com os seguintes propósitos:

Estruturação de Boilerplate: Auxílio na criação rápida das estruturas de classes de dados (Entidades e DAOs).
Resolução de Bugs no Room: Suporte na implementação correta da leitura assíncrona do Room Database utilizando Kotlin Flows e Coroutines, garantindo que a tela (UI) fosse atualizada em tempo real sempre que uma nova despesa fosse inserida ou deletada.
Refatoração de Arquitetura: Orientação na reorganização final de pastas, isolando estados de UI e Views em pacotes separados da camada de dados (data), aderindo de forma estrita ao padrão MVVM.

🚀 Implementações Futuras

Embora o aplicativo cumpra seu objetivo principal para esta entrega, diversas funcionalidades estão planejadas para escalar o projeto futuramente:

Edição de Gastos (Update): Adicionar a funcionalidade de alterar o valor, a categoria ou a descrição de uma despesa já registrada, completando o ciclo CRUD.
Gestão de Categorias Personalizadas: Permitir que o usuário crie, edite e escolha as cores e os ícones de suas próprias categorias.
Gráficos e Relatórios Visuais: Inserir gráficos (como gráficos de pizza ou barras) no Dashboard para ilustrar a porcentagem de gastos em cada categoria.
Definição de Limites (Budgets): Possibilidade de estipular um teto de gastos mensal e receber alertas visuais ao se aproximar dele.
Exportação de Dados: Funcionalidade para exportar o histórico de despesas para formatos como PDF ou CSV para controle externo.
