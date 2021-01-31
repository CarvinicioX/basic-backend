package com.sinch.backend.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "extendedUser", types = { User.class })
public interface ExtendedUser {

    @Value("#{target.id}")
    Long getId();

    String getName();

    String getUserName();

    String getPhoneNumber();

    List<Sale> getSales();

}
