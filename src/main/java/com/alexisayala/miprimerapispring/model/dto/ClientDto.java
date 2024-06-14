package com.alexisayala.miprimerapispring.model.dto;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder

public class ClientDto implements Serializable {

    public Integer idClient;
    public String name;
    public String lastName;
    public String email;
    public Date createdAt;

}
