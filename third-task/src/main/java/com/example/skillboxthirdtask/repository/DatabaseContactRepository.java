package com.example.skillboxthirdtask.repository;

import com.example.skillboxthirdtask.entity.Contact;
import com.example.skillboxthirdtask.repository.mapper.ContactRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
@Slf4j
@RequiredArgsConstructor
public class DatabaseContactRepository implements ContactRepository
{
    private final JdbcTemplate jdbcTemplate;

    @Override
    public String listContacts() {
        log.info("listContacts");
        String sql = "SELECT * FROM contact";
        jdbcTemplate.query(sql, new ContactRowMapper());
        return "";
    }

    @Override
    public String addContact(Contact contact) {
        log.info("addContact");
        contact.setId(System.currentTimeMillis());
        String sql = "INSERT INTO contact (id,first_name,last_name,email,phone) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone());
        return "";
    }

    @Override
    public String updateContact(Long id, Contact contact) {
        log.info("updateContact");
        Contact existContact = findById(id);
        if (existContact != null) {
            String sql = "UPDATE contact SET first_name = ?, last_name = ?, email = ?, phone = ? WHERE id = ?";
            jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone(), id );
            return "success";
        }
        return "";
    }

    @Override
    public String deleteContact(Long id) {
        log.info("deleteContact");
        String sql = "DELETE FROM contact WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return "";
    }

    @Override
    public Contact findById(Long id) {
        log.info("findById");
        String sql = "SELECT * FROM contact WHERE id = ?";
        Contact contact = DataAccessUtils.singleResult(
                jdbcTemplate.query(
                        sql,
                        new ArgumentPreparedStatementSetter(new Object[]{id}),
                        new RowMapperResultSetExtractor<>(new ContactRowMapper(), 1)
                )
        );
        return Optional.ofNullable(contact).orElse(null);
    }
}
