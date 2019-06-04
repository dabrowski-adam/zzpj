package backend.security;

import static java.util.Collections.emptyList;

import backend.repositories.UsersRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private UsersRepository applicationUserRepository;

  public UserDetailsServiceImpl(UsersRepository applicationUserRepository) {
    this.applicationUserRepository = applicationUserRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var applicationUser = applicationUserRepository
        .findByIndexNumber(username).get();
    if (applicationUser == null) {
      throw new UsernameNotFoundException(username);
    }
    return new User(applicationUser.getIndexNumber(), applicationUser.getPassword(), emptyList());
  }
}
