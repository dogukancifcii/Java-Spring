package practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeController {
    public static void main(String[] args) {
        //kullanıcıdan alınan bilgilerle employee oluşturalım
        Employee employee = new Employee(1, "Jack Sparrow");

        //employee i kaydetmeden once belki mantiksal islemler gerekli
        //service in kaydetme metodunu kullanacagiz
        //service objesine ihtiyac var.

//        practice.EmployeeService service = new practice.EmployeeService();//sıkı bağlı olmuş oluyor maliyetli oluyor...
//        service.saveEmployee(employee);

//        practice.Repo repo = new practice.EmployeeRepo();
//        practice.EmployeeService service = new practice.EmployeeService(repo); //dependancy injection
//        service.saveEmployee(employee);

        //1-service/repo objelerini kendimiz olusturduk -->Spring olusturunca : Bean -->IoC
        //2-DI kendimiz yapmak zorunda kaldik:constructor --> Spring tarafindan otomatik yapilir


        AnnotationConfigApplicationContext contex = new AnnotationConfigApplicationContext(AppConfig.class);

        EmployeeService service = contex.getBean(EmployeeService.class);
        service.saveEmployee(employee);

        //biz
        //service icin obje uretmedik
        //repo icin obje uretmedik
        //DI yapmakdik
    }
}
