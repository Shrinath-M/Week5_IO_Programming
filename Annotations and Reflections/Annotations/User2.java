public class User2 {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "user_email")
    private String email;

    public User(String username, int age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }
}
