drop database db_pedido2;
Create database if not exists db_pedido2;
use db_pedido2;

create table CLIENTE_01 (
	A01_codigo int auto_increment primary key,
    A01_nome varchar(50) not null,
    A01_endereco varchar(50) not null,
    A01_telefone char(11) not null,
    A01_cpf char(11) not null,
    A01_credito decimal(10,2) not null
);

DELIMITER $$
CREATE DEFINER= 'root'@'localhost' PROCEDURE Proc_InsCliente (
	in V_A01_nome varchar(50),
	in V_A01_endereco varchar(50),
	in V_A01_telefone char(11),
	in V_A01_cpf char(11),
	in V_A01_credito decimal(10,2)
)

BEGIN
	insert into CLIENTE_01 (A01_nome, A01_endereco, A01_telefone, A01_cpf, A01_credito)
	values (V_A01_nome, V_A01_endereco, V_A01_telefone, V_A01_cpf, V_A01_credito);
COMMIT;
END$$
DELIMITER ;

create table PEDIDO_02(
	A02_codigo int auto_increment primary key,
    A02_data date not null,
    A02_valor_total decimal(10,2),
    A01_codigo int not null,
    foreign key (A01_codigo) references CLIENTE_01(A01_codigo)
);

DELIMITER $$
CREATE DEFINER= 'root'@'localhost' PROCEDURE Proc_InsPedido(
	in V_A02_data date,
	in V_A02_valor_total decimal(10,2),
    in V_A01_codigo int
)

BEGIN
	insert into PEDIDO_02 (A02_data, A02_valor_total, A01_codigo)
	values (V_A02_data, V_A02_valor_total, V_A01_codigo);
COMMIT;
END$$
DELIMITER ;

create table PRODUTO_03(
	A03_codigo int auto_increment primary key,
    A03_descricao varchar(50) not null,
    A03_valor_unitario decimal(10,2) not null,
    A03_estoque int not null
);

DELIMITER $$
CREATE DEFINER= 'root'@'localhost' PROCEDURE Proc_InsProduto(
	in V_A03_descricao varchar(50),
	in V_A03_valor_unitario decimal(10,2),
	in V_A03_estoque int
)

BEGIN
	insert into PRODUTO_03 (A03_descricao, A03_valor_unitario, A03_estoque)
	values (V_A03_descricao, V_A03_valor_unitario, V_A03_estoque);
COMMIT;
END$$
DELIMITER ;

create table ItemProduto_04(
	A04_codigo int,
    A02_codigo int,
    A03_codigo int,
    A04_quantidade int not null,
    A04_valor_item decimal(10,2) not null,
    foreign key (A02_codigo) references PEDIDO_02 (A02_codigo),
    foreign key (A03_codigo) references PRODUTO_03 (A03_codigo),
    primary key(A04_codigo, A02_codigo, A03_codigo)
)

DELIMITER $$
CREATE DEFINER= 'root'@'localhost' PROCEDURE Proc_InsItemProduto(
	in V_A04_codigo int,
    in V_A02_codigo int,
    in V_A03_codigo int,
    in V_A04_quantidade int,
	in V_A04_valor_item decimal(10,2)
)

BEGIN
	insert into ItemProduto_04 (A04_codigo, A02_codigo, A03_codigo, A04_quantidade, A04_valor_item)
	values (A04_codigo, A02_codigo, A03_codigo, V_A04_quantidade, V_A04_valor_item);
COMMIT;
END$$
DELIMITER ;