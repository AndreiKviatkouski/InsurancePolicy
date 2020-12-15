package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.model.Client;

import java.util.List;

public interface ClientService {
    void create(Client client);

    List<Client> getAll();

    Client getById(long id);

    boolean updateById(Client client, long id);

    boolean deleteById(long id);
}
