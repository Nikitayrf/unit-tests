package seminars.seminar3.tdd;

public class User {

    String name;
    String password;
    boolean isAdmin = false;

    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.

    /**
     * Метод аутентификации принимает на вход 2 строки (String login, String password). Нужно вернуть true если login и password корректны, иначе false.
     */

    public boolean authenticate(String name, String password) {
        isAuthenticate = name == this.name && password == this.password;
        return isAuthenticate;
    }

}
