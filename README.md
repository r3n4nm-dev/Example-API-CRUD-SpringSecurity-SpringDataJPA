# Example-API-CRUD-SpringSecurity-SpringDataJPA
API simples de sistema de cadastro de funcionários com controle de acesso a recursos.  
É necessário adicionar o usuário, senha e datasource do seu Banco de dados.  
Neste exemplo 2 usuários em mémoria foram criados.  

- User: renan  
Password: renan  
Role: ADMIN  

- User: aline  
Password: aline  
Role: USER  
  
Para determinados recursos apenas o usuário de Role ADMIN tem acesso.
  
Autenticação não obrigatória  
- Listando funcionários:  
GET /funcionarios/ HTTP/1.1  
Host: localhost:8080  
  
Autenticação obrigatória com Role USER ou ADMIN 
- Cadastrando funcionários:  
POST /funcionarios HTTP/1.1  
Host: localhost:8080  
Authorization: Basic YWxpbmU6YWxpbmU=  
Content-Type: application/json  
  
{  
"nomeCompleto":"R3n4nm",  
"idade":60,  
"funcao":"ADM"  
}  
  
- Buscando funcionários por ID:  
GET /funcionarios/4 HTTP/1.1  
Host: localhost:8080  
Authorization: Basic YWxpbmU6YWxpbmU=  
  
Autenticação obrigatória com Role ADMIN 

- Atualizando funcionários:  
PUT /funcionarios/4 HTTP/1.1  
Host: localhost:8080  
Authorization: Basic cmVuYW46cmVuYW4=  
Content-Type: application/json  
  
{  
"nomeCompleto":"R3n4nm",  
"idade":60,  
"funcao":"ADM"  
}  

- Deletando funcionários:  
DELETE /funcionarios/1 HTTP/1.1  
Host: localhost:8080  
Authorization: Basic cmVuYW46cmVuYW4=  


