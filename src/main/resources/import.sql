-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;



INSERT INTO TB_USUARIOS (id, nome, email, login, senha, dat_ult_alteracao) VALUES (1, 'Dom Pedro de Bragança', 'pedro@imperio.br', 'pedro.braganca', 'senha123', CURRENT_TIMESTAMP);
INSERT INTO TB_USUARIOS (id, nome, email, login, senha, dat_ult_alteracao) VALUES (2, 'Maria Leopoldina', 'leopoldina@imperio.br', 'maria.leopoldina', 'senha456', CURRENT_TIMESTAMP);

INSERT INTO TB_ENDERECOS (id, logradouro, numero, complemento, bairro, cidade, estado, cep, usuario_id) VALUES (101, 'Avenida Paulista', '1000', 'Apto 101', 'Bela Vista', 'São Paulo', 'SP', '01310100', 1);
INSERT INTO TB_ENDERECOS (id, logradouro, numero, complemento, bairro, cidade, estado, cep, usuario_id) VALUES (102, 'Rua da Imperatriz', '50', 'Casa', 'Centro', 'Rio de Janeiro', 'RJ', '20001000', 1);
INSERT INTO TB_ENDERECOS (id, logradouro, numero, complemento, bairro, cidade, estado, cep, usuario_id) VALUES (103, 'Quinta da Boa Vista', 'S/N', 'Palácio', 'São Cristóvão', 'Rio de Janeiro', 'RJ', '20940040', 2);

ALTER TABLE TB_USUARIOS ALTER COLUMN id RESTART WITH 3;
ALTER TABLE TB_ENDERECOS ALTER COLUMN id RESTART WITH 104;
