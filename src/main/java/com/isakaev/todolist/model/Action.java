package com.isakaev.todolist.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * Объект Action
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Action {

    /**
     * id объекта Action
     */
//    @ApiModelProperty(notes = "Id of the Action", name = "id", required = true, value = "123456")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Описание объекта Action
     */
    private String description;

    /**
     * Исполнитель Action
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Person person;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Action)) return false;
        Action action = (Action) o;
        return  Objects.equals(description, action.description) &&
                Objects.equals(person, action.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, person);
    }
}
