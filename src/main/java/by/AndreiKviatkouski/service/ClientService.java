package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.model.Client;

import java.util.List;

public interface ClientService {
    void create(Client client);

    List<Client> getAll();

    Client getById(long id);

    boolean update(Client client);

    boolean deleteById(long id);
}
