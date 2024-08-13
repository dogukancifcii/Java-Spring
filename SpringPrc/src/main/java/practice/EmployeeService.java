package practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

    //service: bazi mantiksal islemler burada yapilabilir.

    //reponun save metodunu kullanmak icin
    //repo objesi gerekli

    //public practice.EmployeeRepo repo = new practice.EmployeeRepo(); //maliyetli,sıkı sıkıya bağımlı

    //public practice.PersonelRepo repo=new practice.PersonelRepo();

    @Autowired
    @Qualifier("personelRepo")
    public Repo repo;//null

//    public EmployeeService(Repo repo) {
//        this.repo = repo;
//    }

    //kadetme
    public void saveEmployee(Employee employee) {
        System.out.println("practice.Employee is saving...");
        repo.save(employee);
    }
}
