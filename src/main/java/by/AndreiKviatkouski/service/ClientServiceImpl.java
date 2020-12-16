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
        if (!clientRepository.existsByPhone(client.getPhone())) {
            clientRepository.save(client);
        }
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
    public boolean update(Client client) {
        Client existClient = clientRepository.getOne(client.getId());

        if (clientRepository.existsById(client.getId())) {
            existClient.setId(client.getId());
            clientRepository.save(client);
            return true;
        }
        if (clientRepository.existsByPhone(client.getPhone())){
            existClient.setPhone(client.getPhone());
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

