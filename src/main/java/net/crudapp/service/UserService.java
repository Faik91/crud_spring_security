package net.crudapp.service;

import net.crudapp.model.User;

import java.util.List;

public interface UserService {
    //    @Override
//    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    User getUserByName(String name);

    List<User> allUsers();

    void addUser(User user);

    void deleteUser(long id);

    void editUser(User user);

    User getUserById(long id);
}
