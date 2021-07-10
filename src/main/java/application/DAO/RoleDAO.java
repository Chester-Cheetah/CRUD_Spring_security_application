package application.DAO;

import application.entity.Role;

import java.util.List;

public interface RoleDAO {

    void add(Role role);
    List<Role> roleList();
    Role getRole (String role);
}
