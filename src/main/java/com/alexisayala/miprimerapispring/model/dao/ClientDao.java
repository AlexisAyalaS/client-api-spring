package com.alexisayala.miprimerapispring.model.dao;

import com.alexisayala.miprimerapispring.model.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientDao extends CrudRepository<Client, Integer> {

}
