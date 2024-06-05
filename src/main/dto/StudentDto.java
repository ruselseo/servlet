package main.dto;

import java.util.Objects;

public class StudentDto {

       private final Long id;
       private final String mail;

    private StudentDto(Long id, String mail) {
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
        StudentDto studentDto = (StudentDto) o;
        return Objects.equals(getId(), studentDto.getId()) && Objects.equals(getMail(), studentDto.getMail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMail());
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                '}';
    }

}

