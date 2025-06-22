package ru.nsd.addressbook.model;

public record ContactData(String id, String lastname, String firstname, String address, String mobile, String email) {
    public ContactData(){
        this("","", "","","","");
    }
    public ContactData withId(String id){ return new ContactData(id, this.lastname, this.firstname, this.address, this.mobile, this.email);}
    public ContactData withLastAndFirstNames(String lastname, String firstname){ return new ContactData(this.id, lastname,firstname, this.address, this.mobile, this.email);}
}