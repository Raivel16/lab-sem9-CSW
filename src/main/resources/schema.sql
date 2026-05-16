create table if not exists documento (
    id_documento int generated always as identity primary key,
    nombre_documento varchar(200) not null,
    activo boolean not null default true
);



