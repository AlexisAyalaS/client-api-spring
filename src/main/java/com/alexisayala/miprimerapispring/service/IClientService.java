package com.alexisayala.miprimerapispring.service;

import com.alexisayala.miprimerapispring.model.dto.ClientDto;
import com.alexisayala.miprimerapispring.model.entity.Client;

import java.util.List;

public interface IClientService {
    List<Client> listAllClients();
    Client save(ClientDto client);
    Client findById(Integer id);
    void delete(Client client);
    boolean existsById(Integer id);
}
