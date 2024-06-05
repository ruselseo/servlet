package main.dto;

import java.util.Objects;

public class CreateUserDto {
    private final String name;
    private final String birthday;
    private final String email;
    private final String password;
    private final String role;
    private final String gender;

    private CreateUserDto(String name, String birthday, String email, String password, String role, String gender) {
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.role = role;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateUserDto that = (CreateUserDto) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getBirthday(), that.getBirthday()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getRole(), that.getRole()) && Objects.equals(getGender(), that.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBirthday(), getEmail(), getPassword(), getRole(), getGender());
    }

    @Override
    public String toString() {
        return "CreateUserDto{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static class CreateUserDtoBuilder {
        private final String name;
        private final String birthday;
        private final String email;
        private final String password;
        private final String role;
        private final String gender;//optional

        //constructor for required fields

        public CreateUserDtoBuilder(String name, String birthday, String email, String password, String role, String gender) {
            this.name = name;
            this.birthday = birthday;
            this.email = email;
            this.password = password;
            this.role = role;
            this.gender = gender;
        }

        //Build the Employee object
        public CreateUserDto build() {
            return new CreateUserDto(this.name, this.birthday, this.email, this.password, this.role, this.gender);
        }
    }
}
