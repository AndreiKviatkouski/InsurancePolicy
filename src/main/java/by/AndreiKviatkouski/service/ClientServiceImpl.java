package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.model.Client;
import by.AndreiKviatkouski.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {


    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void create(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(long id) {
        return clientRepository.getOne(id);
    }

    @Override
    public boolean updateById(Client client, long id) {
        if (clientRepository.existsById(id)) {
            client.setId(id);
            clientRepository.save(client);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteById(long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

