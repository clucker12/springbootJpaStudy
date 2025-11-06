package springjpa01.reserve.app;

import springjpa01.reserve.domain.User;
import springjpa01.reserve.domain.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ChangeNameService {
    public ChangeNameService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserRepository userRepository;

    @Transactional
    public void changeName(String email, String newName) {
        Optional<User> userOpt = userRepository.findById(email);
        User user = userOpt.orElseThrow(() -> new NoUserException());
        user.changeName(newName);
    }
}
