package com.techelevator.dao;

import com.willywonka.model.ProspectEmployee;

import java.util.List;

public interface ProspectEmployeeDao {

    List<ProspectEmployee> getAllProspectEmployees();
    ProspectEmployee getProspectEmployeeById(int prospectId);
    ProspectEmployee addProspectEmployee(ProspectEmployee prospectEmployee);
    void deleteProspectEmployee(int prospectId);



}
