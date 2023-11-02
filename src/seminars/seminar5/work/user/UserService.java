package seminars.seminar5.work.user;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserName(int id) {
        return userRepository.getUserById(id);
    }
}
