create table if not exists task(
    id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    titulo VARCHAR(200) not null,
    fecha_creacion date  null
);
