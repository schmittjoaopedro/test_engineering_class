CREATE TABLE IF NOT EXISTS LEILAO (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NOME_PRODUTO VARCHAR,
    ENCERRADO BOOLEAN,
    DATA DATE
);

CREATE TABLE IF NOT EXISTS PAGAMENTO (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    LEILAO_ID INT,
    LEILAO_NOME_PRODUTO VARCHAR
);