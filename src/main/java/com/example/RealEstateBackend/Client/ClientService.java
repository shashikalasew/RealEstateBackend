package com.example.RealEstateBackend.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client addClient(ClientDTO clientDTO) {
        Client client = new Client();

        client.setName(clientDTO.getName());
        client.setPhone(clientDTO.getPhone());
        client.setEmail(clientDTO.getEmail());
        client.setAddress(clientDTO.getAddress());

        client.setCreatedAt(java.time.LocalDateTime.now());

        return clientRepository.save(client);
    }

    public Client updateClient(int id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client != null) {
            client.setName(clientDTO.getName());
            client.setPhone(clientDTO.getPhone());
            client.setEmail(clientDTO.getEmail());
            client.setAddress(clientDTO.getAddress());

            client.setCreatedAt(java.time.LocalDateTime.now());

            return clientRepository.save(client);
        }
        return null;
    }

    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }
}
