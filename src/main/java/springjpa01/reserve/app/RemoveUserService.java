package springjpa01.reserve.app;

import springjpa01.reserve.domain.User;
import springjpa01.reserve.domain.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RemoveUserService {
    private UserRepository userRepository;

    public RemoveUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void removeUser(String email) {
        Optional<User> userOpt = userRepository.findById(email);
        User user = userOpt.orElseThrow(() -> new NoUserException());
        userRepository.delete(user);
    }
}
