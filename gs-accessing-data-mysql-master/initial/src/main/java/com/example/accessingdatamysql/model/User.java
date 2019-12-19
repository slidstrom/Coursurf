
package com.example.accessingdatamysql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity //This tells hibernate to make a table out of thi class
public class User {

  //added- role of user (Student=1, Teacher=2, Administrator=3)
  //need to create new database field (Integer role) in table (User)

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String name;
  private String password;
  private Integer role;

  public User() {}

  public User(String name, String password, Integer role) {
    this.name = name;
    this.password = password;
    this.role = role;
  }

  //added- getter setter for role
  public Integer getRole(){
    return role;
  }
  public void setRole(Integer role){
    this.role = role;
  }

  //lost change, i made every set method below private , previously: public
  public Integer getId(){
    return id;
  }
  public void setId(Integer id){
    this.id = id;
  }
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
  public String getPassword(){
    return password;
  }
  public void setPassword(String password){
    this.password = password;
  }



  @Override
  public boolean equals(Object o) {

    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id) &&
            Objects.equals(name, user.name) &&
            Objects.equals(password, user.password) &&
            Objects.equals(role, user.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, password, role);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("User{");
    sb.append("id=").append(id);
    sb.append(", firstName='").append(name).append('\'');
    sb.append(", lastName='").append(role).append('\'');
    sb.append('}');
    return sb.toString();
  }


}
