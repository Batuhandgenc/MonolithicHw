package com.batuhan.Java3Monolithic.service;

import com.batuhan.Java3Monolithic.repository.entity.User;
import com.batuhan.Java3Monolithic.dto.response.UserFindAllResponseDto;
import com.batuhan.Java3Monolithic.exception.MonolitikTekrarManagerException;
import com.batuhan.Java3Monolithic.dto.request.UserSaveRequestDto;
import com.batuhan.Java3Monolithic.exception.Error;
import com.batuhan.Java3Monolithic.mapper.UserMapper;
import com.batuhan.Java3Monolithic.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IUserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return  userRepository.findAll();
    }


    public Optional<User> login (String username, String password){
        Optional<User> user = userRepository.findOptionalByUsernameAndPassword(username, password);
        if (user.isEmpty()){
            System.out.println("User is not found!");
            return Optional.ofNullable(null);
        }
        return user;
    }
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public List<UserFindAllResponseDto> findAllDto() {
        return UserMapper.INSTANCE.toUserFindAllResponseDto(userRepository.findAll());
    }

    public User saveRequestDto(UserSaveRequestDto saveDto){

        try {
            User user = UserMapper.INSTANCE.toUser(saveDto);
            userRepository.save(user);
            return user;
        }catch (Exception e){
            throw new MonolitikTekrarManagerException(Error.USER_NOT_CREATED,"User is not created!");
        }
    }
}
