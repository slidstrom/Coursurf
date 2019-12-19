
package com.example.accessingdatamysql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //This tells hibernate to make a table out of thi class
public class Course {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String name;

  private String email;

// lost change, i made every set method below private , previously: public

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

  public String getEmail(){
    return email;
  }

  public void setEmail(String email){
    this.email = email;
  }


}
