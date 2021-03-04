package com.isakaev.todolist.service.Impl;


import com.isakaev.todolist.model.security.User;
import com.isakaev.todolist.repository.UserRepository;
import com.isakaev.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

//    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository
//            , RoleRepository roleRepository
    ) {
        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
    }

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Override
//    public void save(com.isakaev.todolist.model.security.User user) {
//        user.setPassword(user.getPassword());
//        userRepository.save(user);
//    }

    @Override
    public void save(User user) {
        user.setPassword(user.getPassword());
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleRepository.getOne(1L));
//        user.setRoles(roles);

//        user.setRoles(Collections.singleton(Role.USER));
//        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
