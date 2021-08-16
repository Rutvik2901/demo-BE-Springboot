package com.rutvik.Teams;

import com.rutvik.employee.Employee;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String teamNumber;
        private String teamName;
        private String projectName;

        @ManyToMany
        @OnDelete(action = OnDeleteAction.CASCADE)
        private List<Employee> employee;
//
        public Team() {

        }

        public Team(String teamNumber, String teamName, String projectName, Integer id){
            this.teamName = teamName;
            this.teamNumber = teamNumber;
            this.projectName = projectName;
            this.employee = new ArrayList<>();
            this.id = id;
//            this.id = id;
//            this.employee = new ArrayList<>();
        }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

//    public void setEmployee(ArrayList<Employee> Employee) {
//        employee = Employee;
//    }

    public List<Employee> getEmployee() {
        return employee;
    }

        public String getProjectName() {
            return projectName;
        }

        public String getTeamName() {
            return teamName;
        }

        public String getTeamNumber() {
            return teamNumber;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public void setTeamNumber(String teamNumber) {
            this.teamNumber = teamNumber;
        }

}
