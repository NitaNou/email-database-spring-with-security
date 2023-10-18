package com.willywonka.dao;

import com.willywonka.exception.DaoException;
import com.willywonka.model.Department;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDepartmentDao implements DepartmentDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcDepartmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT id, dept_name FROM department";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Department department = mapRowToDepartment(results);
                departments.add(department);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return departments;
    }

    private Department mapRowToDepartment(SqlRowSet results) {
        Department department = new Department();
        department.setId(results.getInt("id"));
        department.setDept(results.getString("dept_name"));
        return department;
    }
}
