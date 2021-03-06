package pers.dc.bean;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

  @Id
  private long id;
  private String name;
  private long type;
  private long fatherId;
  private String logo;
  private String slogan;
  private String catImage;
  private String bgColor;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public long getFatherId() {
    return fatherId;
  }

  public void setFatherId(long fatherId) {
    this.fatherId = fatherId;
  }


  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }


  public String getSlogan() {
    return slogan;
  }

  public void setSlogan(String slogan) {
    this.slogan = slogan;
  }


  public String getCatImage() {
    return catImage;
  }

  public void setCatImage(String catImage) {
    this.catImage = catImage;
  }


  public String getBgColor() {
    return bgColor;
  }

  public void setBgColor(String bgColor) {
    this.bgColor = bgColor;
  }

}
