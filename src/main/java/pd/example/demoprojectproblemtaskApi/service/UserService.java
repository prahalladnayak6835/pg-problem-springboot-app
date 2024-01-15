package pd.example.demoprojectproblemtaskApi.service;

import pd.example.demoprojectproblemtaskApi.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);

    User findById(Long id);

    void update(User user);

    void delete(Long id);

    User find(Long id);

    List<User> findUser();
}
