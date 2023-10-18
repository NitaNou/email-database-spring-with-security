package com.willywonka.controller;

import com.willywonka.dao.ProspectEmployeeDao;
import com.willywonka.model.ProspectEmployee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProspectEmployeeController {
    private ProspectEmployeeDao prospectEmployeeDao;

    public ProspectEmployeeController(ProspectEmployeeDao prospectEmployeeDao) {
        this.prospectEmployeeDao = prospectEmployeeDao;
    }

    @RequestMapping (path = "/prospects", method = RequestMethod.GET)
    public List<ProspectEmployee> getAllProspectEmployees() {
        return prospectEmployeeDao.getAllProspectEmployees();
    }

    @RequestMapping (path = "/prospects/{id}", method = RequestMethod.GET)
    public ProspectEmployee getProspectEmployeeById(@PathVariable("id") int id) {
        return prospectEmployeeDao.getProspectEmployeeById(id);
    }

    //@ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping (path = "/prospects/{id}", method = RequestMethod.DELETE)
    public void deleteProspectEmployeeById(@PathVariable("id") int id) {
        prospectEmployeeDao.deleteProspectEmployee(id);
    }

    @RequestMapping (path = "/prospects", method = RequestMethod.POST)
    public ProspectEmployee addProspectEmployee(@RequestBody ProspectEmployee prospectEmployee) {
        return prospectEmployeeDao.addProspectEmployee(prospectEmployee);
    }


}
