insert into produto(id, nome) values(1, 'Teste');
insert into produto(id, nome) values(2, 'Teste Novo 1');

insert into municipio(id, nome, idUF) values(1, 'Maceió', 1);
insert into municipio(id, nome, idUF) values(2, 'Barra de são Miguel', 1);
insert into municipio(id, nome, idUF) values(3, 'Brasília', 2);
insert into municipio(id, nome, idUF) values(4, 'Cidade Com Estado -1', -1);
insert into municipio(id, nome, idUF) values(5, 'Cidade Com Estado -2', -2);

insert into autor(id, nome, sobrenomes) values(1, 'Carlos', 'Drummond de Andrade');
insert into autor(id, nome, sobrenomes) values(2, 'Clarice', 'Lispector');

insert into livro(id, titulo, conteudo, autor) values (1, 'A Rosa do Povo', 'Em 1945, Drummond deixa o gabinete do Ministério. Nesse mesmo anos, publica o livro de poemas, A Rosa do Povo onde condena a vida mecanizada e desumana de nossos dias e espelha uma carência de um mundo certo, pautado na justiça, que venha substituir a falta de solidariedade de seu momento...', 1);
insert into livro(id, titulo, conteudo, autor) values (2, 'No Meio do Caminho', 'No meio do caminho tinha uma pedra tinha uma pedra no meio do caminho tinha uma pedra no meio do caminho tinha uma pedra.', 1);
insert into livro(id, titulo, conteudo, autor) values (3, 'Perto do Coração Selvagem', 'Conteúdo qualquer do livro...', 2);
