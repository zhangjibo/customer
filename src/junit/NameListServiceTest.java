package junit;

import org.junit.Test;

import domain.Employee;
import service.NameListService;
import service.TeamException;

public class NameListServiceTest {
  @Test
  public void testGetAllEmployees() {
      NameListService service = new NameListService();
      Employee[] allEmployees = service.getAllEmployees();
      for (int i = 0; i < allEmployees.length; i++) {
	System.out.println(allEmployees[i]);
    }
  }
  @Test
  public void testGetEmployee() {
      NameListService service = new NameListService();
      int id = 10;
      try {
	Employee employee = service.getEmployee(id);
	System.out.println(employee);
    } catch (TeamException e) {
	// TODO Auto-generated catch block
	System.out.println(e.getMessage());
    }
  }
}
