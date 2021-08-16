package com.rutvik.Teams;

import com.rutvik.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    public List<Team> getTeams() {
        return (List<Team>) teamRepository.findAll();
    }

    public Team getTeamById(Integer id) {
        return (Team) teamRepository.findById(id).get();
    }

    public void addTeam(Team team){
        teamRepository.save(team);
    }

    public  void updateTeam(Integer id, Team team) {
        if(teamRepository.findById(id).isPresent()) {
            teamRepository.save(team);
        }
    }

    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }

    public void addEmployeeToTeam(LinkedHashMap empId, String id) {

        Team tempTeam = (Team) teamRepository.findById(Integer.parseInt(id)).get();

        List<Employee> temp = tempTeam.getEmployee();

        for (Object add : ((ArrayList) empId.get("addEmployeeList"))) {
            temp.add(new Employee(Integer.parseInt(add.toString()),"","",""));
        }
        for (Object add : ((ArrayList) empId.get("removeEmployeeList"))) {
            temp.stream().forEach(e -> System.out.println(e.getId() == Integer.parseInt(add.toString())));
            temp.remove(temp.stream().filter(e -> e.getId() == Integer.parseInt(add.toString())).findFirst().get());
        }
        tempTeam.setEmployee(temp);
        teamRepository.save(tempTeam);

    }
}
