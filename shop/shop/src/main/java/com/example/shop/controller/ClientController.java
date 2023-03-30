package com.example.shop.controller;

import com.example.shop.entity.Client;
import com.example.shop.service.intfs.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAll(){
        return clientService.findAll();
    }

    @PutMapping("/{clientId}/discount")
    public void changeClientDiscount(@PathVariable Long clientId,
                                     @RequestParam Integer discount1,
                                     @RequestParam Integer discount2) {

        clientService.editClientDiscounts(clientId, discount1, discount2);
    }

}
