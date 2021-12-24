package kg.it.academy.OnlineBank.controller;

import kg.it.academy.OnlineBank.entity.Client;
import kg.it.academy.OnlineBank.service.ClientService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientController {
    final ClientService clientService;

    @PostMapping("/save")
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }
}
