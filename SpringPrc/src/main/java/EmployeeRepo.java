public class EmployeeRepo implements Repo {

    //repo:DB ile islemler

    public void save(Employee employee) {
        System.out.println("Employee is saved ID : " + employee.getId());
    }

}
