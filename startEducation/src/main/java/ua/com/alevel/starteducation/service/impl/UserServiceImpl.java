package ua.com.alevel.starteducation.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import ua.com.alevel.starteducation.dto.response.UserResponse;
import ua.com.alevel.starteducation.model.auth.EducationUser;
import ua.com.alevel.starteducation.model.auth.EducationUserDetails;
import ua.com.alevel.starteducation.repository.AuthorityRepository;
import ua.com.alevel.starteducation.repository.UserRepository;
import ua.com.alevel.starteducation.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           AuthorityRepository authorityRepository,
                           PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUserName(String email)throws NotFoundException {
        EducationUser user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Email " + email + " not found"));
        return new EducationUserDetails(user);
    }

    @Transactional(readOnly = true)
    public Page<UserResponse> list(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserResponse::fromUserWithBasicAttributes);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
