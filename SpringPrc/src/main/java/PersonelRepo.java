public class PersonelRepo implements Repo {


    public void save(Employee employee) {
        System.out.println("Employee is saved. ID : " + employee.getId());
    }

}
