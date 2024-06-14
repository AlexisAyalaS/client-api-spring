package com.alexisayala.miprimerapispring.service.implementations;

import com.alexisayala.miprimerapispring.model.dao.ClientDao;
import com.alexisayala.miprimerapispring.model.dto.ClientDto;
import com.alexisayala.miprimerapispring.model.entity.Client;
import com.alexisayala.miprimerapispring.service.IClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImp implements IClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public List<Client> listAllClients() {
        return (List) clientDao.findAll();
    }

    @Transactional
    @Override
    public Client save(ClientDto clientDto) {
        Client client = Client.builder()
                .idClient(clientDto.getIdClient())
                .name(clientDto.getName())
                .lastName(clientDto.getLastName())
                .email(clientDto.getEmail())
                .createdAt(clientDto.getCreatedAt())
                .build();
        return clientDao.save(client);
    }

    @Transactional(readOnly=true)
    @Override
    public Client findById(Integer id) {
        return clientDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Client client) {
        clientDao.delete(client);
    }

    @Override
    public boolean existsById(Integer id) {
        return clientDao.existsById(id);
    }
}
