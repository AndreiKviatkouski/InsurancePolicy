
CREATE TABLE IF NOT EXISTS clients
(
    id    BIGSERIAL PRIMARY KEY ,
    firstName TEXT NOT NULL ,
    lastName VARCHAR(200) NOT NULL ,
    birthDate VARCHAR(200) NOT NULL ,
    email VARCHAR(254) NOT NULL ,
    phone VARCHAR(20)  NOT NULL
    passport VARCHAR(200)  NOT NULL
    address VARCHAR(200)  NOT NULL
);


INSERT INTO clients VALUES
(1, 'Vassily','Petrov',"10/10/2010", 'vpetrov@jr.com', '+375 (29) 322-22-33)',"MP123456","Minsk Platonova,10-56")
