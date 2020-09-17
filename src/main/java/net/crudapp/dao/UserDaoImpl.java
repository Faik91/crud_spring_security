package net.crudapp.dao;

import net.crudapp.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserByName(String username) {
//        Role role = new Role();
//        role.setRole("ROLE_ADMIN");
//        Set<Role> set = new HashSet<>();
//        set.add(role);
//        User user = new User();
//        user.setName("Faik");
//        user.setPassword("0000");
//        user.setRoles(set);
//        return user;

        return (User) entityManager.createQuery("FROM User WHERE name =:name").setParameter("name", username).getSingleResult();


    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        return this.entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void addUser(User user) {
        this.entityManager.persist(user);
    }

    @Override
    public void deleteUser(long id) {
        User user = (User) this.entityManager.find(User.class, id);
        this.entityManager.remove(user);
    }

    @Override
    public void editUser(User user) {
        this.entityManager.merge(user);
    }

    @Override
    public User getUserById(long id) {
        return (User) this.entityManager.find(User.class, id);

    }
}
