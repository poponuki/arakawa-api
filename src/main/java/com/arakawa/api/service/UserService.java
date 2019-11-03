package com.arakawa.api.service;

import com.arakawa.api.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
//@Transactional
@AllArgsConstructor
public class UserService {

    /**
     * ユーザー情報の取得
     *
     * @param userId ユーザーID
     * @return ユーザー情報
     */
    public Optional<User> findById(Long userId) {
        return null;
//        return userRepository.findById(userId);
    }
}
