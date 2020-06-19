package pers.dc.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
public class Users {

  @Id
  private String id;
  private String username;
  private String password;
  private String nickname;
  private String realname;
  private String face;
  private String mobile;
  private String email;
  private long sex;
  private java.sql.Date birthday;
  private java.sql.Timestamp createdTime;
  private java.sql.Timestamp updatedTime;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public String getRealname() {
    return realname;
  }

  public void setRealname(String realname) {
    this.realname = realname;
  }


  public String getFace() {
    return face;
  }

  public void setFace(String face) {
    this.face = face;
  }


  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public long getSex() {
    return sex;
  }

  public void setSex(long sex) {
    this.sex = sex;
  }


  public java.sql.Date getBirthday() {
    return birthday;
  }

  public void setBirthday(java.sql.Date birthday) {
    this.birthday = birthday;
  }


  public java.sql.Timestamp getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(java.sql.Timestamp createdTime) {
    this.createdTime = createdTime;
  }


  public java.sql.Timestamp getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(java.sql.Timestamp updatedTime) {
    this.updatedTime = updatedTime;
  }

}
