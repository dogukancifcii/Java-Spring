public class EmployeeService {

    //service: bazi mantiksal islemler burada yapilabilir.

    //reponun save metodunu kullanmak icin
    //repo objesi gerekli

    //public EmployeeRepo repo = new EmployeeRepo(); //maliyetli,sıkı sıkıya bağımlı

    //public PersonelRepo repo=new PersonelRepo();

    public final Repo repo;//null

    public EmployeeService(Repo repo) {
        this.repo = repo;
    }

    //kadetme
    public void saveEmployee(Employee employee) {
        System.out.println("Employee is saving...");
        repo.save(employee);
    }
}
