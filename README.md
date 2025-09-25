# 📌 Board de Tarefas  

API Rest feita em java, que permite gerenciar um **board de tarefas**. 
---

## 🚀 Tecnologias Utilizadas  
- **Java 17**  
- **Spring Boot**
- **Lombok** 
- **Hibernate**
- **Jakarta Persistence API**
- **Banco de Dados H2**  
 
## 📌 Funcionalidades  
✅ Adicionar, ler, atualizar e excluir um **Board**  

✅ Adicionar, ler, atualizar e excluir uma **Coluna** 

✅ Adicionar, ler, mover, atualizar, excluir, bloquear e desbloquear um **Card**
  

## 🔜 **Implementações Futuras**  

🔹 Criar testes unitários  
🔹 Criar tratamento de erros <br>
🔹 fazer a documentação da api 

## 📄 Diagrama de Classes
```mermaid
classDiagram
    class AuditableEntity {
        <<abstract>>
        - Long id
        - LocalDate creationDate
        - LocalDate lastModifiedDate
    }

    class Board {
        - String name
        - List<Columns> columns
    }

    class Columns {
        - String name
        - List<Card> cards
    }

    class Card {
        - String title
        - String description
        - List<Block> blocks
    }

    Board "1" --> "*" Columns 
    Columns "1" --> "*" Card 
    Columns "*" --> "1" Board
    Card "*" --> "1" Columns
    
    Board --|> AuditableEntity
    Columns --|> AuditableEntity
    Card --|> AuditableEntity

```
---
feito com ❤️
