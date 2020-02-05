package com.innovecture.agentsforJapan.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "agency")
public class Agency implements Serializable {

  @Id
  @Column (name = "agency_code")
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer agency_code;

  @Column (name = "agency_name")
  private String name;

  @Column (name = "contact")
  private String contact;

  @Column (name = "email")
  private String email;

  @Embedded
  @Column (name = "current_address")
  @AttributeOverrides({
  @AttributeOverride (name = "addressLine1", column = @Column (name = "cur_address_line1")),
  @AttributeOverride (name = "city", column = @Column (name = "current_city")),
  @AttributeOverride (name = "state", column = @Column (name = "current_state")),
  @AttributeOverride (name = "zipCode", column = @Column (name = "current_zip_code")),
  @AttributeOverride (name = "country", column = @Column (name = "current_country")),
  })
  private Address currentAddress;

  @OneToMany (cascade = {CascadeType.ALL})
  @JoinColumn (name = "agency_code")
  @JsonManagedReference
  private List<User> users = new ArrayList<>();

  @OneToMany (cascade = {CascadeType.ALL})
  @JoinColumn (name = "agency_code")
  @JsonManagedReference
  private List<Company> companies = new ArrayList<>();


  public Agency() {

  }

  public Agency(String name, String contact, String email, Address currentAddress) {

    this.name = name;
    this.contact = contact;
    this.email = email;
    this.currentAddress = currentAddress;
  }

  public Integer getAgency_code() {
    return agency_code;
  }

  public void setAgency_code(Integer agency_code) {
    this.agency_code = agency_code;
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

  public List<User> getUsers() { return users; }

  public void setUsers(List<User> users) { this.users = users; }

  public List<Company> getCompanies() { return companies; }

  public void setCompanies(List<Company> companies) { this.companies = companies; }
}
