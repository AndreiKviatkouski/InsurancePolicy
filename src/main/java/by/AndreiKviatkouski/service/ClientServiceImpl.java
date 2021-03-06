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
    public boolean update(Client client, long id) {
        Client existClient = clientRepository.getOne(id);
       boolean checkParam= false;
        if (client.getFirstName() != null) {
            existClient.setFirstName(client.getFirstName());
            checkParam= true;
        }
        if (client.getLastName() != null) {
            existClient.setLastName(client.getLastName());
            checkParam = true;
        }
        if (client.getPhone() != null) {
            existClient.setPhone(client.getPhone());
            checkParam = true;
        }
        if (checkParam){
            clientRepository.save(existClient);
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

