INSERT INTO bank(idBank) values ('0000');

INSERT INTO Office(name,street,phone,zip,bank_idbank,idOffice) values('Encina', 'Paseo San Antonio', 987401250, 24401, '0000', '1111');
INSERT INTO Office(name,street,phone,zip,bank_idbank,idOffice) values('Ladreda', 'Calle San Mames', 987001122, 24007, '0000', '1234');

INSERT INTO Employee(name, surname, address, salary, office_idoffice, idemployee) values('Alberto', 'Castro Delgado', 'Calle Angustias', 1500, '1111', '71517234E');
INSERT INTO Employee(name, surname, address, salary, office_idoffice, idemployee) values('Pablo', 'Carrasco Jorreto', 'Calle Filipino', 800, '1111', '70876871W');
INSERT INTO Employee(name, surname, address, salary, office_idoffice, idemployee) values('Jesus', 'Fernandez Carro', 'Calle Burguer', 1000, '1234', '71519821X');