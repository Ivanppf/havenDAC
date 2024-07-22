package com.ippf.havendac.business.services;


import com.ippf.havendac.model.entities.User;

public interface UserService {

    User findById(Integer id);

    User save(User user);

    User update(Integer id, User user);

}
