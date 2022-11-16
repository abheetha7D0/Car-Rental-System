package lk.carrental.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class SystemUser {
    @Id
    private String id;
    @Size(min = 3, max = 25, message = "userName Invalid")
    private String userName;
    @Size(min = 3, max = 25, message = "password Invalid")
    private String password;
}
