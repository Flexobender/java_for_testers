package ru.nsd.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import ru.nsd.addressbook.common.CommonFunctions;
import ru.nsd.addressbook.model.ContactData;
import ru.nsd.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static ru.nsd.addressbook.common.CommonFunctions.randomString;

public class Generator {
    @Parameter(names={"--type", "-t"})
    String type;
    @Parameter(names={"--output", "-o"})
    String output;
    @Parameter(names={"--format", "-f"})
    String format;
    @Parameter(names={"--count", "-n"})
    int count;
    private Properties properties ;
    public static void main(String[] args) throws IOException {
       var generator = new Generator();
        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);
        generator.run();

    }
    private void run() throws IOException {

        var data = generate();
        save(data);
    }
    private  Object generate(){
        if ("groups".equals(type)){
            return generateGroups();
        }else if ("contacts".equals(type)){
            return generateContacts();
        }else {
            throw new IllegalArgumentException("Неизвестный тип данных "  + type);
        }
    }

    private Object generateContacts() {
        var result = new ArrayList<ContactData>();
        for(int i=0; i < 5; i++){
            result.add(new ContactData()
                    .withId(randomString( i * 10))
                    .withLastAndFirstNames(randomString( i * 10), randomString( i * 10))
//                    .withPhoto(CommonFunctions.randomFile(properties.getProperty("paths.images")))
                  );
        }
        return result;

    }

    private List<GroupData> generateGroups() {
        var result = new ArrayList<GroupData>();
//        for (var name : List.of("group name","")){
//            for(var header : List.of("header name","")){
//                for(var footer : List.of("footer name","")){
//                    result.add(new GroupData()
//                            .withName(name)
//                            .withHeader(header)
//                            .withFooter(footer));
//                }
//            }
//        }
        for(int i=0; i < 5; i++){
            result.add(new GroupData()
                    .withName(randomString( i * 10))
                    .withHeader(randomString( i * 10))
                    .withFooter(randomString( i * 10)));
        }
         return result;
    }

    private  void save(Object data) throws IOException {
        if ("json".equals(format)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
//            mapper.writeValue(new File(output), data);
            var json = mapper.writeValueAsString(data);

            try (var writer = new FileWriter(output);){
                writer.write(json);
            }

        }else if ("yaml".equals(format)) {
            var mapper = new YAMLMapper();
            var yaml = mapper.writeValueAsString(data);
            try (var writer = new FileWriter(output);){
                writer.write(yaml);
            }
        }else if ("xml".equals(format)) {
        var mapper = new XmlMapper();
        mapper.writeValue(new File(output), data);
        }else {
        throw new IllegalArgumentException("Неизвестный формат данных "  + format);
    }
    }
}
