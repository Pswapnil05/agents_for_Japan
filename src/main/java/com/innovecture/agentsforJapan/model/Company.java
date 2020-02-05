package com.innovecture.agentsforJapan.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "company")
public class Company implements Serializable {

  @Id
  @Column (name = "company_id")
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Integer company_id;

  @Column (name = "company_name")
  private String name;

  @Column (name = "company_contact")
  private String contact;

  @Column (name = "company_email_id")
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

  public Company() {      }

  public Company(String name, String contact, String email, Address currentAddress) {
    this.name = name;
    this.contact = contact;
    this.email = email;
    this.currentAddress = currentAddress;
  }

  public Integer getCompany_id() {
    return company_id;
  }

  public void setCompany_id(Integer company_id) {
    this.company_id = company_id;
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

  public Agency getAgency() {
    return agency;
  }

  public void setAgency(Agency agency) {
    this.agency = agency;
  }
}
