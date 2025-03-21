# 📌 Board de Tarefas  

Uma aplicação inspirada nas aulas de integração de sistemas com bancos de dados, do bootcamp **DecolaTech** da **DIO**, desenvolvida com **Java** , que permite gerenciar um **board de tarefas**. 
---

## 🚀 Tecnologias Utilizadas  
- **Java 17**  
- **Spring Boot**
- **Lombok** 
- **Hibernate**
- **Jakarta Persistence API**
- **Banco de Dados H2**  
 
## 📌 Funcionalidades  
✅ Crud completo para a entidade **Board**  
✅ Crud completo para a entidade **Coluna** que vai estar dentro de um Board  
✅ Crud completo para a entidade **Card** que vai estar dentro de uma Coluna  
✅ Crud completo para a entidade **Block** que vai estar dentro de um Card  
✅ **Mover Cards** entre Colunas  

## 🔜 **Implementações Futuras**  
🔹 Implementar controle de permissões 
🔹 Refinar regras de negócios  
🔹 Criar tratamento preciso de erros

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

    class Block {
        - String blockCause
        - String unBlockCause
    }

    Board "1" --> "*" Columns 
    Columns "1" --> "*" Card 
    Card "1" --> "*" Block 
    Columns "*" --> "1" Board
    Card "*" --> "1" Columns
    Block "*" --> "1" Card
    
    Board --|> AuditableEntity
    Columns --|> AuditableEntity
    Card --|> AuditableEntity
    Block --|> AuditableEntity

```
---
feito com ❤️
