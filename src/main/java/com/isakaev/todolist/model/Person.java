package com.isakaev.todolist.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Объект Person
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    /**
     * id объекта Person
     */
//  @ApiModelProperty(notes = "Id of the Action", name = "id", required = true, value = "123456")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Имя объекта Person
     */
    private String name;

    /**
     * Имя объекта Person
     */
    private String phone;

    /**
     * Имя объекта Person
     */
    private String address;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return  Objects.equals(name, person.name) &&
                Objects.equals(phone, person.phone) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, address);
    }
}
