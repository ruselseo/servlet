package main.dto;

import java.util.Objects;

public class UserDto {

       private final Long id;
       private final String mail;

    private UserDto(Long id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }


    public String getMail() {
        return mail;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(getId(), userDto.getId()) && Objects.equals(getMail(), userDto.getMail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMail());
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                '}';
    }

    public static class UserDtoBuilder {
        private final Long id;
        private final String mail;//optional

        //constructor for required fields
        public UserDtoBuilder(Long id, String mail) {
            this.id = id;
            this.mail = mail;
        }

        //Build the Employee object
        public UserDto build() {
            return new UserDto(this.id, this.mail);
        }
    }
}

