package seminars.seminar3.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    private User user;

    @BeforeEach
    void setUP() {
        user = new User( "log123", "pass123", false );
    }

    // 3.6.

    /**
     * Разработайте класс User с методом аутентификации по логину и паролю. Метод должен возвращать true, если
     * введенные логин и пароль корректны, иначе false. Протестируйте все методы
     */

    @Test
    void authenticateTrue() {
        assertTrue( user.authenticate( "log123", "pass123" ) );
    }

    @Test
    void authenticateFalse() {
        assertFalse( user.authenticate( "l_o_g_false", "p_a_s_s_false" ) );
    }

    // 3.7

    /**
     * Добавьте класс UserRepository для управления пользователями. В этот класс должен быть включен метод
     * addUser, который добавляет пользователя в систему, если он прошел аутентификацию. Покройте тестами новую функциональность
     */

    @Test
    void addUserFindByNameTrue() {
        user.authenticate( "log123", "pass123" );
        UserRepository userRepository = new UserRepository();
        userRepository.addUser( user );
        assertTrue( userRepository.findByName( "log123" ) );
    }

    @Test
    void addUserTrue() {
        user.authenticate( "log123", "pass123" );
        UserRepository userRepository = new UserRepository();
        userRepository.addUser( user );
        assertThat( userRepository.data ).contains( user );
    }

    @Test
    void addUserFalse() {
        user.authenticate( "l_o_g_false", "p_a_s_s_false" );
        UserRepository userRepository = new UserRepository();
        userRepository.addUser( user );
        assertThat( userRepository.data ).doesNotContain( user );
    }
}
