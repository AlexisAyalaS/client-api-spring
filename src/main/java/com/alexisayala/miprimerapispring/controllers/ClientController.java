package com.alexisayala.miprimerapispring.controllers;

import com.alexisayala.miprimerapispring.model.dto.ClientDto;
import com.alexisayala.miprimerapispring.model.entity.Client;
import com.alexisayala.miprimerapispring.model.payload.MessageResponse;
import com.alexisayala.miprimerapispring.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @GetMapping("clients")
    public ResponseEntity<?> showAll(){
        List<Client> getList = clientService.listAllClients();
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Clients found")
                .object(getList)
                .build(), HttpStatus.OK);
    }

    @PostMapping("client")
    public ResponseEntity<?> create(@RequestBody ClientDto clientDto){
        Client clientSave = null;
        try{
            clientSave = clientService.save(clientDto);
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Client saved successfully")
                    .object(ClientDto.builder()
                            .idClient(clientSave.getIdClient())
                            .name(clientSave.getName())
                            .lastName(clientSave.getLastName())
                            .email(clientSave.getEmail())
                            .createdAt(clientSave.getCreatedAt())
                            .build())
                    .build(), HttpStatus.CREATED);
        }catch(DataAccessException exDt){
            return new ResponseEntity<>(MessageResponse.builder()
                    .message(exDt.getMessage())
                    .object(null)
                    .build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("client/{idClient}")
    public ResponseEntity<?> update(@RequestBody ClientDto clientDto, @PathVariable Integer idClient){
        Client clientUpdate = null;
        try{
            if(clientService.existsById(idClient)){
                clientDto.setIdClient(idClient);
                clientUpdate = clientService.save(clientDto);
                return new ResponseEntity<>(MessageResponse.builder()
                        .message("Client updated Successfully")
                        .object(ClientDto.builder()
                                .idClient(clientUpdate.getIdClient())
                                .name(clientUpdate.getName())
                                .lastName(clientUpdate.getLastName())
                                .email(clientUpdate.getEmail())
                                .createdAt(clientUpdate.getCreatedAt())
                                .build())
                        .build(), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(MessageResponse.builder()
                        .message("the updated register is not found on DB")
                        .object(null)
                        .build(), HttpStatus.NOT_FOUND);
            }
        }catch(DataAccessException exDt){
            return new ResponseEntity<>(MessageResponse.builder()
                    .message(exDt.getMessage())
                    .object(null)
                    .build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @DeleteMapping("client/{idClient}")
    public ResponseEntity<?> delete(@PathVariable Integer idClient){
        try{
            Client clientDelete = clientService.findById(idClient);
            clientService.delete(clientDelete);
            return new ResponseEntity<>(clientDelete, HttpStatus.NO_CONTENT);
        }catch(DataAccessException exDt){
            return new ResponseEntity<>(MessageResponse.builder()
                    .message(exDt.getMessage())
                    .object(null)
                    .build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("client/{idClient}")
    public ResponseEntity<?> showById(@PathVariable Integer idClient){
        Client client =  clientService.findById(idClient);
        if(client == null){
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Client not exist")
                    .object(null)
                    .build(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Client found Successfully")
                .object(ClientDto.builder()
                        .idClient(client.getIdClient())
                        .name(client.getName())
                        .lastName(client.getLastName())
                        .email(client.getEmail())
                        .createdAt(client.getCreatedAt())
                        .build())
                .build(), HttpStatus.OK);
    }
}
