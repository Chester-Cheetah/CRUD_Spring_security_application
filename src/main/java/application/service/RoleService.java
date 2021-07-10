package application.service;

import application.entity.Role;

import java.util.List;

public interface RoleService {
    void add (Role role);
    List<Role> roleList();
    void saveRoleListIfNotSaved();
    Role getRole (String role);
}
