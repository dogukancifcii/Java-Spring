package practice;

import org.springframework.stereotype.Component;

@Component
public class EmployeeRepo implements Repo {

    //repo:DB ile islemler

    public void save(Employee employee) {
        System.out.println("practice.Employee is saved ID : " + employee.getId());
    }

}
