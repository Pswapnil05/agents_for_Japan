package com.innovecture.agentsforJapan.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "user")
public class User implements Serializable {

  @Id
  @Column (name = "user_id")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer user_id;

  @Column (name = "user_name")
  private String name;

  @Column (name = "user_contact")
  private String contact;

  @Column (name = "user_email_id")
  private String email;

  @Embedded
  @Column(name = "current_address")
  @AttributeOverrides({
      @AttributeOverride (name = "addressLine1", column = @Column (name = "cur_address_line1")),
      @AttributeOverride (name = "city", column = @Column (name = "current_city")),
      @AttributeOverride (name = "state", column = @Column (name = "current_state")),
      @AttributeOverride (name = "zipCode", column = @Column (name = "current_zip_code")),
      @AttributeOverride (name = "country", column = @Column (name = "current_country")),
  })
  private Address currentAddress;

  @ManyToOne (cascade = {CascadeType.ALL})
  @JoinColumn (name = "agency_code")
  @JsonBackReference
  private Agency agency;

  public User() {    }

  public User(String name, String contact, String email, Address currentAddress) {

    this.name = name;
    this.contact = contact;
    this.email = email;
    this.currentAddress = currentAddress;
  }

  public Integer getUser_id() {
    return user_id;
  }

  public void setUser_id(Integer user_id) {
    this.user_id = user_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Address getCurrentAddress() {
    return currentAddress;
  }

  public void setCurrentAddress(Address currentAddress) {
    this.currentAddress = currentAddress;
  }

  public Agency getAgency() { return agency; }

  public void setAgency(Agency agency) { this.agency = agency; }
}
