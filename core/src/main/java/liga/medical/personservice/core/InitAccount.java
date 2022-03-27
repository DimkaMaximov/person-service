package liga.medical.personservice.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

@Component
public class InitAccount {

    @Autowired
    JdbcTemplate template;

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @PostConstruct
    public void init() {

//        ContactEntity admin = new ContactEntity();
//        admin.setId(1L);
//        admin.setEmail("admin");
//        admin.setPassword("$2a$10$5m9GmJploLmx8VpbZI9FmOnIZGQA0Ougj9qY29k/eKDUprb7ygpKC");
//        admin.setRole(Role.ROLE_ADMIN);
//
//        ContactEntity contact = new ContactEntity();
//        contact.setId(2L);
//        contact.setEmail("contact");
//        contact.setPassword("$2a$10$qSpjCj6mmHQ8ojfWFy/osu.Z3YN6.UEN/NLVrwqdtZWELL4IJhG52");
//        contact.setRole(Role.ROLE_USER);
//        repository.insert(admin);
//        repository.insert(contact);

        template.execute("INSERT INTO contact VALUES ('200', '+788813818', 'admin', 'adminlink', '$2a$10$5m9GmJploLmx8VpbZI9FmOnIZGQA0Ougj9qY29k/eKDUprb7ygpKC', 'ROLE_ADMIN')");

        template.execute("INSERT INTO contact VALUES ('201', '+12378881381', 'user1', 'user1link', '$2a$10$FN.mn56y7wglnugSIE1IWOtU.R3E5g8PgzJOuxjKq1wlyv94l9Z5O', 'ROLE_USER')");
        template.execute("INSERT INTO contact VALUES ('202', '+4243781381', 'user2', 'user2link', '$2a$10$FN.mn56y7wglnugSIE1IWOtU.R3E5g8PgzJOuxjKq1wlyv94l9Z5O', 'ROLE_USER')");
        template.execute("INSERT INTO contact VALUES ('203', '+2433784381', 'user3', 'user3link', '$2a$10$FN.mn56y7wglnugSIE1IWOtU.R3E5g8PgzJOuxjKq1wlyv94l9Z5O', 'ROLE_USER')");
        template.execute("INSERT INTO contact VALUES ('204', '+65378881381', 'user4', 'user4link', '$2a$10$FN.mn56y7wglnugSIE1IWOtU.R3E5g8PgzJOuxjKq1wlyv94l9Z5O', 'ROLE_USER')");
        template.execute("INSERT INTO contact VALUES ('205', '+76378881381', 'user5', 'user5link', '$2a$10$FN.mn56y7wglnugSIE1IWOtU.R3E5g8PgzJOuxjKq1wlyv94l9Z5O', 'ROLE_USER')");

        template.execute("INSERT INTO medical_card VALUES ('201', 'health', 'B1', '24.03.2022','ads convfsfsdallis')");
        template.execute("INSERT INTO medical_card VALUES ('202', 'ill', 'C5', '12.06.2021','fsdfd safsdff')");
        template.execute("INSERT INTO medical_card VALUES ('203', 'health', 'B1', '01.05.2021','sffsddf dfsdffs')");
        template.execute("INSERT INTO medical_card VALUES ('204', 'health', 'B1', '23.06.2020','sdffsd dhffhg')");
        template.execute("INSERT INTO medical_card VALUES ('205', 'ill', 'C5', '07.10.2020','qweqwe convrgegerallis')");

        template.execute("INSERT INTO address VALUES ('201', '201', '75','Moscow','115189','Lenina','4','408')");
        template.execute("INSERT INTO address VALUES ('202', '202', '23','London','57823','Smith','32','45')");
        template.execute("INSERT INTO address VALUES ('203', '203', '45','Paris','642435','Victory','12','75')");
        template.execute("INSERT INTO address VALUES ('204', '204', '65','Berlin','15465','Freedom','65','87')");
        template.execute("INSERT INTO address VALUES ('205', '205', '34','Rome','116569','Colus','2','25')");

        template.execute("INSERT INTO person_data VALUES ('201', 'Alex', 'Ivanov', '27.07.2015','6','M','201','201','201')");
        template.execute("INSERT INTO person_data VALUES ('202', 'Jame', 'Bones', '27.07.2012','9','M','202','202','202')");
        template.execute("INSERT INTO person_data VALUES ('203', 'Irin', 'Tiane', '27.07.2011','10','F','203','203','203')");
        template.execute("INSERT INTO person_data VALUES ('204', 'Bob', 'Vane', '27.07.2018','3','M','204','204','204')");
        template.execute("INSERT INTO person_data VALUES ('205', 'Lin', 'Pist', '27.07.2014','7','F','205','205','205')");

        template.execute("INSERT INTO illness VALUES ('201', '201', '47', 'hard', '2009-04-16 10:07:20', '05.07.2021')");
        template.execute("INSERT INTO illness VALUES ('202', '202', '23', 'light', '2009-04-16 10:07:20', '10.07.2021')");
        template.execute("INSERT INTO illness VALUES ('203', '203', '87', 'hard', '2009-04-16 10:07:20', '12.10.2021')");
        template.execute("INSERT INTO illness VALUES ('204', '204', '54', 'medium', '2009-04-16 10:07:20', '21.05.2021')");
        template.execute("INSERT INTO illness VALUES ('205', '205', '63', 'hard', '2009-04-16 10:07:20', '17.03.2021')");

    }

    @PreDestroy
    public void delete() {
//        repository.deleteById(repository.findByEmail("admin").getId());
//        repository.deleteById(repository.findByEmail("contact").getId());

        template.execute("DELETE FROM illness WHERE id = 201");
        template.execute("DELETE FROM illness WHERE id = 202");
        template.execute("DELETE FROM illness WHERE id = 203");
        template.execute("DELETE FROM illness WHERE id = 204");
        template.execute("DELETE FROM illness WHERE id = 205");

        template.execute("DELETE FROM person_data WHERE id = 201");
        template.execute("DELETE FROM person_data WHERE id = 202");
        template.execute("DELETE FROM person_data WHERE id = 203");
        template.execute("DELETE FROM person_data WHERE id = 204");
        template.execute("DELETE FROM person_data WHERE id = 205");

        template.execute("DELETE FROM address WHERE id = 201");
        template.execute("DELETE FROM address WHERE id = 202");
        template.execute("DELETE FROM address WHERE id = 203");
        template.execute("DELETE FROM address WHERE id = 204");
        template.execute("DELETE FROM address WHERE id = 205");

        template.execute("DELETE FROM medical_card WHERE id = 201");
        template.execute("DELETE FROM medical_card WHERE id = 202");
        template.execute("DELETE FROM medical_card WHERE id = 203");
        template.execute("DELETE FROM medical_card WHERE id = 204");
        template.execute("DELETE FROM medical_card WHERE id = 205");

        template.execute("DELETE FROM contact WHERE id = 200");
        template.execute("DELETE FROM contact WHERE id = 201");
        template.execute("DELETE FROM contact WHERE id = 202");
        template.execute("DELETE FROM contact WHERE id = 203");
        template.execute("DELETE FROM contact WHERE id = 204");
        template.execute("DELETE FROM contact WHERE id = 205");
    }
}