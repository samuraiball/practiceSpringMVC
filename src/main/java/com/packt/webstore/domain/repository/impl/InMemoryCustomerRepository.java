package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;



    @Override
    public List<Customer> getAllCustomers() {


       Map<String,Object> params = new HashMap<>();
        List<Customer> result = jdbcTemplate.query("SELECT * FROM CUSTOMERS", params, new CustomerMapper());

        return result;
    }

    private static final class CustomerMapper implements RowMapper<Customer> {
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerId(rs.getLong("CUSTOMER_ID"));
            customer.setName(rs.getString("NAME"));
            //customer.setBillingAddress(rs.getClass("ADDRESS"));
            return customer;
        }
    }
}
