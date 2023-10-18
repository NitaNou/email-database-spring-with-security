package com.willywonka.dao;

import com.willywonka.exception.DaoException;
import com.willywonka.model.ProspectEmployee;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProspectEmployeeDao implements ProspectEmployeeDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcProspectEmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ProspectEmployee> getAllProspectEmployees() {
        List<ProspectEmployee> prospectEmployees = new ArrayList<>();
        String sql = "SELECT id, first_name, last_name, prospect_dept_id FROM prospect_employee";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                ProspectEmployee prospectEmployee = mapRowToUser(results);
                prospectEmployees.add(prospectEmployee);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e); //created custom exception to display specific message while also displaying root cause of exception
        }
        return prospectEmployees;
    }

    @Override
    public ProspectEmployee getProspectEmployeeById(int prospectId) {
        ProspectEmployee prospectEmployee = null;
        String sql = "SELECT id, first_name, last_name, prospect_dept_id FROM prospect_employee WHERE id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, prospectId);
        if (result.next()) {
            prospectEmployee = mapRowToUser(result);
        }
        return prospectEmployee;
    }

    @Override
    public ProspectEmployee addProspectEmployee(ProspectEmployee prospectEmployee) {
        ProspectEmployee prospectEmp = null;
        String sql = "INSERT into prospect_employee (id, first_name, last_name, prospect_dept_id) VALUES (default, ?, ?, ?)";
        jdbcTemplate.update(sql, prospectEmployee.getFirstName(), prospectEmployee.getLastName(), prospectEmployee.getProspect_dept());
        return prospectEmp;
    }

    @Override
    public void deleteProspectEmployee(int prospectId) {
        String sql = "DELETE FROM prospect_employee WHERE id = ?";
        jdbcTemplate.update(sql, prospectId);
    }


    private ProspectEmployee mapRowToUser(SqlRowSet results) {
        ProspectEmployee prospectEmployee = new ProspectEmployee();
        prospectEmployee.setId(results.getInt("id"));
        prospectEmployee.setFirstName(results.getString("first_name"));
        prospectEmployee.setLastName(results.getString("last_name"));
        prospectEmployee.setProspect_dept(results.getInt("prospect_dept_id"));
        return prospectEmployee;
    }

}
