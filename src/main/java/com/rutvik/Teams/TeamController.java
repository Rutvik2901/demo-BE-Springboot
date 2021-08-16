package com.rutvik.Teams;

import com.rutvik.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

//
@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/teams")
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/teams/{id}")
    public Team getEmployeesId(@PathVariable Integer id) {
        return teamService.getTeamById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST,value="/teams")
    public void addTeam(@RequestBody Team team) {
        teamService.addTeam(team);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.PUT, value = "/teams/{id}")
    public void updateTeam(@PathVariable Integer id, @RequestBody Team team) {
        teamService.updateTeam(id,team);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.DELETE, value = "/teams/{id}")
    public void deleteTeam(@PathVariable Integer id) {
        teamService.deleteTeam(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST,value="/addMember/teams/{teamId}")
    public void addEmployeeToTeam(@RequestBody LinkedHashMap empId, @PathVariable String teamId) {
        System.out.println("herererererer");
        teamService.addEmployeeToTeam(empId, teamId);
    }
}
