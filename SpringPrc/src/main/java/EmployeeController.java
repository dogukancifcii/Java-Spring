public class EmployeeController {
    public static void main(String[] args) {
        //kullanıcıdan alınan bilgilerle employee oluşturalım
        Employee employee = new Employee(1, "Jack Sparrow");

        //employee i kaydetmeden once belki mantiksal islemler gerekli
        //service in kaydetme metodunu kullanacagiz
        //service objesine ihtiyac var.

//        EmployeeService service = new EmployeeService();//sıkı bağlı olmuş oluyor maliyetli oluyor...
//        service.saveEmployee(employee);

        Repo repo = new EmployeeRepo();
        EmployeeService service = new EmployeeService(repo); //dependancy injection
        service.saveEmployee(employee);

        //1-service/repo objelerini kendimiz olusturduk -->Spring olusturunca : Bean -->IoC
        //2-DI kendimiz yapmak zorunda kaldik:constructor --> Spring tarafindan otomatik yapilir
    }
}
