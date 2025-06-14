# 📚 Sistema de Gerenciamento de Biblioteca

Este projeto foi desenvolvido como parte da **Terceira Avaliação da Nota 1** da disciplina **Orientação a Objetos**, ministrada pelo professor **Me. Jonas Pontes**. O objetivo principal é aplicar os conceitos de programação orientada a objetos na construção de um sistema para gerenciamento de uma biblioteca.

## 🧑‍💻 Equipe

- Mychelle Ketlen ([@falk-dev](https://github.com/falk-dev))
- Rubens Neto ([@RUBENSNETO0001](https://github.com/RUBENSNETO0001))

## 🎯 Objetivo

Criar uma aplicação em Java, com interface de texto, que possibilite o cadastro, consulta, empréstimo e devolução de livros, bem como o gerenciamento dos usuários (leitores), utilizando os principais conceitos de orientação a objetos.

## 🛠️ Funcionalidades

### 📖 Livros
- Cadastrar novo livro
- Consultar livro por ISBN
- Listar todos os livros
- Remover livro
- Buscar livros por autor

### 👤 Usuários
- Cadastrar novo usuário
- Consultar usuário por CPF
- Listar todos os usuários
- Remover usuário

### 🔄 Empréstimos
- Realizar empréstimo de livro (verifica disponibilidade)
- Registrar devolução
- Listar livros emprestados
- Verificar livros disponíveis
- Histórico de empréstimos

## 🧱 Estrutura de Pacotes
biblioteca/  
├── aplicacao/ # Classe principal com o método main e interação com o usuário  
├── modelo/ # Classes de domínio: Livro, Usuario, Emprestimo  
├── repositorio/ # Simulação do banco de dados com Map  
├── servico/ # Casos de uso: cadastro, empréstimo, etc.  

## 📌 Conceitos Aplicados

- Sintaxe da linguagem Java
- Modelagem orientada a objetos
- Abstração e encapsulamento
- Métodos acessores e modificadores (getters e setters)
- Construtores e sobrecarga
- Métodos e atributos estáticos
- Organização em pacotes
- Diagrama de classes (UML)

## 📁 Entregáveis

- Código-fonte completo da aplicação
- Diagrama UML em formato de imagem ou PDF
