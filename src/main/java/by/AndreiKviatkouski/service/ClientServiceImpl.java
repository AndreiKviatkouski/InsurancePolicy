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

        if (client.getLastName() != null) {
            existClient.setLastName(client.getLastName());
            clientRepository.save(existClient);
            return true;
        }
        if (client.getPhone() != null) {
            existClient.setPhone(client.getPhone());
            clientRepository.save(existClient);
            return true;
        }

        return false;
    }
//        if (clientRepository.existsById(id)) {
//            Client client1 = clientRepository.getOne(id);
//            client1.setId(id);
//            client1.setLastName(client.getLastName());
//            clientRepository.save(client1);
//            return true;
//        }
//
//        return false;
//    }

    @Override
    public boolean deleteById(long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

