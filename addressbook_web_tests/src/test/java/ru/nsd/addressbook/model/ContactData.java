package ru.nsd.addressbook.model;

import static ru.nsd.addressbook.common.CommonFunctions.randomString;

public record ContactData(String id, String lastname, String firstname, String address, String mobile, String email, String file) {
    public ContactData(){
        this("","", "","","","","src/test/resources/images/avatar.png");
    }



    public ContactData withId(String id){ return new ContactData(id, this.lastname, this.firstname, this.address, this.mobile, this.email, this.file);}
    public ContactData withLastAndFirstNames(String lastname, String firstname){ return new ContactData(this.id, lastname,firstname, this.address, this.mobile, this.email, this.file);}
    public ContactData withAddress(String address){return new ContactData(this.id, this.lastname, this.firstname, address, this.mobile, this.email, this.file);}
    public ContactData withPhoto(String file){return new ContactData(this.id, this.lastname, this.firstname, this.address, this.mobile, this.email, file);}


}