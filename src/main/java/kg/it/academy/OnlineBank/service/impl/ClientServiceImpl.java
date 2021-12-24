package kg.it.academy.OnlineBank.service.impl;

import kg.it.academy.OnlineBank.entity.Client;
import kg.it.academy.OnlineBank.repository.ClientRepository;
import kg.it.academy.OnlineBank.service.ClientService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientServiceImpl implements ClientService {
    final ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }
}
