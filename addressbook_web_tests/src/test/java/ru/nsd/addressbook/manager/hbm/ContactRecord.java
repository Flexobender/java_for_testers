package ru.nsd.addressbook.manager.hbm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addressbook")
public class ContactRecord {
    @Id
    public int id;
    public String lastname;
    public String firstname;
    public String address;
    public String mobile;
    public String email;
    public String photo;
}
