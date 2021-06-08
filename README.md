# Example-API-CRUD-SpringSecurity-SpringDataJPA
API simples de sistema de cadastro de funcionários com controle de acesso a recursos.  
É necessário adicionar o usuário, senha e datasource do seu Banco de dados.  
Neste exemplos 2 usuários em mémoria foram criados.
-User: renan  
Password: renan  
Role: ADMIN  



- Listando funcionários:  
GET /funcionarios/ HTTP/1.1  
Host: localhost:8080  

- Cadastrando produtos:  
POST /produtos/ HTTP/1.1  
Host: localhost:8080  
Content-Type: application/json  

{  
"nome":"lápis",   
"valor":1,  
"quantidade":20  
}

- Buscando produtos por ID:  
GET /produtos/1 HTTP/1.1  
Host: localhost:8080  

- Buscando produtos por nome:  
GET /produtos/por-nome?nome=a HTTP/1.1  
Host: localhost:8080  

- Atualizando produtos:  
PUT /produtos/1 HTTP/1.1  
Host: localhost:8080  
Content-Type: application/json  

{  
"nome":"caneta",  
"valor": 1  
}

- Deletando produtos:  
DELETE /produtos/1 HTTP/1.1  
Host: localhost:8080  




