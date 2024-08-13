package practice;

import org.springframework.stereotype.Component;

@Component
public class PersonelRepo implements Repo {


    public void save(Employee employee) {
        System.out.println("practice.Employee is saved. ID : " + employee.getId());
    }

}
