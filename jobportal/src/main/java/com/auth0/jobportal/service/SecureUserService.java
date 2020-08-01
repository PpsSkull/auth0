package com.auth0.jobportal.service;

import static java.util.Collections.emptyList;
import static java.util.UUID.fromString;

import com.auth0.jobportal.model.UserDto;
import com.auth0.jobportal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecureUserService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    UserDto userDto = userRepository.findUserById(fromString(userName));
    return new User(userDto.getMobileNumber(), userDto.getPassword(), emptyList());
  }
}
