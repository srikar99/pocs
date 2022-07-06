package shreekar.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import shreekar.entities.Country;
import shreekar.entities.Employee;

public class Operations {

	/**
	 * Given a list of Country objects, modify names to upper case, and print names
	 * whose codes begin with A and sorted in alphabetical order
	 */
	public static List<String> sortCountries(List<Country> countries) {

		var result = countries.stream().map(country -> country.getName().toUpperCase())
				.filter(name -> name.startsWith("A")).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		return result;
	}

	/**
	 * Given a list of employees, sort all the employee based on age? Use java 8 APIs only 
	 * @param employees
	 * @return
	 */
	public static List<Employee> sortEmployees(List<Employee> employees) {

		var result = employees.stream().sorted(Comparator.comparing(Employee::getAge, Comparator.reverseOrder())).collect(Collectors.toList());

		return result;
	}

	public static void main(String[] args) {
		
		System.out.println(1%10);

		var countries = countriesUtil();
		var result = sortCountries(countries);

		result.forEach(System.out::println);
		
		var employees = employeeUtil();
		var employeeSort = sortEmployees(employees);
		
		employeeSort.forEach(employee -> System.out.println(employee.getAge()));
	}

	public static List<Employee> employeeUtil() {
		List<Employee> employees = new ArrayList<>();

		employees.add(getEmployee(29, "Shreekar"));
		employees.add(getEmployee(27, "Vidushi"));
		employees.add(getEmployee(54, "Sujata"));
		employees.add(getEmployee(34, "Shreepad"));

		return employees;
	}

	public static Employee getEmployee(int age, String name) {
		Employee employee = new Employee();
		employee.setAge(age);
		employee.setName(name);

		return employee;
	}

	public static List<Country> countriesUtil() {
		List<Country> countries = new ArrayList<>();

		countries.add(getCountry(0, "India"));
		countries.add(getCountry(1, "Australia"));
		countries.add(getCountry(2, "USA"));
		countries.add(getCountry(3, "argetina"));
		countries.add(getCountry(4, "brazil"));
		countries.add(getCountry(5, "RUssiA"));
		countries.add(getCountry(6, "ANGola"));
		countries.add(getCountry(7, "SA"));
		countries.add(getCountry(8, "new Zealand"));
		countries.add(getCountry(9, "aUstria"));

		return countries;
	}

	public static Country getCountry(int id, String name) {
		Country country = new Country();
		country.setId(id);
		country.setName(name);

		return country;
	}
}
