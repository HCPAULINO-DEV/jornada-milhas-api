CREATE TABLE depoimento(
    id BIGSERIAL PRIMARY KEY,
    foto VARCHAR(255) NOT NULL,
    depoimento TEXT NOT NULL,
    nome_pessoa VARCHAR(50) NOT NULL
    );