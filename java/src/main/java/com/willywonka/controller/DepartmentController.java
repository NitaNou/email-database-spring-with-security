package com.willywonka.controller;

import com.willywonka.dao.DepartmentDao;
import com.willywonka.model.Department;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    private DepartmentDao departmentDao;

    public DepartmentController(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @RequestMapping(path = "/departments", method = RequestMethod.GET)
    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}
