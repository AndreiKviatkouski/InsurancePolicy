package by.AndreiKviatkouski.controller;

import by.AndreiKviatkouski.model.Client;
import by.AndreiKviatkouski.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class ClientController {


    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @PostMapping(value = "/clients",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces =  {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<?> create(@Valid @RequestBody Client client) {
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/clients",
            produces =  {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<List<Client>> getAll() {
        final List<Client> clients = clientService.getAll();

        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/clients/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces =  {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<Client> getById(@Valid @PathVariable(name = "id") long id) {
        final Client client = clientService.getById(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/clients/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces =  {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<?> updateById(@Valid @PathVariable (name = "id") long id, @RequestBody Client client) {
        client.setId(id);
        final boolean updated = clientService.update(client);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "/clients/{id}{phone}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces =  {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<?> updateClientByPhone(@Valid @PathVariable (name = "id") long id, @PathVariable (name = "phone") String phone, @RequestBody Client client) {
        client.setId(id);
        client.setPhone(phone);
        final boolean updated = clientService.update(client);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    @DeleteMapping(value = "/clients/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces =  {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<?> deleteById(@Valid @PathVariable(name = "id") long id) {
        final boolean deleted = clientService.deleteById(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}