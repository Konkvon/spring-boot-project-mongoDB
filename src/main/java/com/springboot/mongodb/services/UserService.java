package com.springboot.mongodb.services;

import com.springboot.mongodb.dto.UserDTO;
import com.springboot.mongodb.entities.User;
import com.springboot.mongodb.repositories.UserRepository;
import com.springboot.mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(String id, UserDTO dto){
        User entity = findById(id);
        updateData(entity, dto);
        return repository.save(entity);
    }

    private void updateData(User entity, UserDTO dto){
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
