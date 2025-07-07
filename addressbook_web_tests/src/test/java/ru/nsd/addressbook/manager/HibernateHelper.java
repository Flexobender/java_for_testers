package ru.nsd.addressbook.manager;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceConfiguration;
import ru.nsd.addressbook.manager.hbm.ContactRecord;
import ru.nsd.addressbook.manager.hbm.GroupRecord;
import ru.nsd.addressbook.model.ContactData;
import ru.nsd.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;

    public HibernateHelper(ApplicationManager manager) {
        super(manager);

        sessionFactory =
                new HibernatePersistenceConfiguration("Addressbook")
                        .managedClass(ContactRecord.class)
                        .managedClass(GroupRecord.class)

                        .jdbcUrl("jdbc:mysql://localhost/addressbook")
                        // Credentials
                        .jdbcCredentials("root", "")
                        .createEntityManagerFactory();
    }

// Создает список объектов ГрупДата из списка объектоа ГрупРекорд
    static List<GroupData> converList(List<GroupRecord> records) {
        List<GroupData> result = new ArrayList<>();
        for (var record : records) {
            result.add(convert(record));
        }
        return  result;
    }
    private static GroupData convert(GroupRecord record) {
        return new GroupData("" + record.id, record.name, record.header, record.footer);
    }

    private static GroupRecord convert(GroupData data) {
        var id = data.id();
        if ("".equals(id)){
            id = "0";
        }
        return new GroupRecord(Integer.parseInt(id), data.name(), data.header(), data.footer());
    }

    public List<GroupData> getGroupList() {
        return sessionFactory.fromSession(session -> {
            return converList(session.createQuery("from GroupRecord", GroupRecord.class).list());
        });
    }

    public long getGroupCount() {
        return sessionFactory.fromSession(session -> {

            return (session.createQuery("select count (*) from GroupRecord", Long.class).getSingleResult());

        });
    }

    public void groupCreation(GroupData groupData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(groupData));
            session.getTransaction().commit();
        });

    }
    private static ContactData convert(ContactRecord record) {
        return new ContactData("" + record.id, record.firstname, record.lastname, record.address, record.mobile,record.email,record.photo);
    }

    // Создает список объектов КонтактДата из списка объектоа КонтактРекорд
    static List<ContactData> convertList(List<ContactRecord> records) {
        List<ContactData> result = new ArrayList<>();
        for (var record : records) {
            result.add(convert(record));
        }
        return  result;
    }
    public List<ContactData> getContactList() {
        return convertList(sessionFactory.fromSession(session -> {
            return session.createQuery("from ContactRecord", ContactRecord.class).list();
        }));
    }
}
