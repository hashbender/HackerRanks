package com.nick.amazon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author nickh
 *
 */
public class AmazonInterview {

	public AmazonInterview() {
		// TODO Auto-generated constructor stub
	}

	public static class Employee {

		private final int id;
		private final String name;
		private final List<Employee> reports;

		public Employee(int id, String name) {
			this.id = id;
			this.name = name;
			this.reports = new ArrayList<Employee>();
		}

		/**
		 * @return an integer ID for this employee, guaranteed to be unique.
		 */
		public int getId() {
			return id;
		}

		/**
		 * @return a String name for this employee, NOT guaranteed to be unique.
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return a List of employees which report to this employee. This list
		 *         may be empty, but will never be null.
		 */
		public List<Employee> getReports() {
			return reports;
		}

		/**
		 * Adds the provided employee as a report of this employee.
		 */
		public void addReport(Employee employee) {
			reports.add(employee);
		}
	}

	/*
	 * Complete the function below.
	 * 
	 * @param ceo - the CEO of the company
	 * 
	 * @param firstEmployee - one of the two target employees, guaranteed to
	 * report up to the CEO
	 * 
	 * @param secondEmployee - one of the two target employees, guaranteed to
	 * report up to the CEO
	 * 
	 * @return the employee which is the closest common manager of firstEmployee
	 * and secondEmployee
	 * 
	 * Assumptions I made: I assumed that there were no "dangling" employees
	 * Description of my approach: My approach was to recursively build a
	 * hierarchy for the given employee with the findEmployeeChain function. I
	 * would do this with both employees and then be able to find where the
	 * lists converge.
	 * 
	 * Runtime complexity of my approach: This has a O(log(n))) complexity
	 * 
	 * Justification of runtime complexity: This algorithm (if it worked) will
	 * only need to look through, on average, half of each managers direct
	 * reports. As this extrapolates, the complexity approaches O(log(n))
	 */
	static Employee closestCommonManager(Employee ceo, Employee firstEmployee,
			Employee secondEmployee) {
		List<Employee> firstManagementChain = new ArrayList<Employee>();
		List<Employee> chain1 = findEmployeeChain(ceo, firstEmployee,
				firstManagementChain);

		List<Employee> secondManagementChain = new ArrayList<Employee>();
		List<Employee> chain2 = findEmployeeChain(ceo, secondEmployee,
				secondManagementChain);

		if (chain1.size() > chain2.size()) {
			return chain2.get(chain2.size() - 1);
		} else {
			return chain1.get(chain1.size() - 1);
		}
	}

	static List<Employee> findEmployeeChain(Employee manager,
			Employee findEmployee, List<Employee> managementChain) {
		managementChain.add(manager);
		if (manager.getReports().contains(findEmployee)) {
			return managementChain;
		} else {
			for (Employee report : manager.getReports()) {
				List<Employee> tempList = findEmployeeChain(report,
						findEmployee, managementChain);
				if (tempList.size() > 0)
					return tempList;
			}
		}
		managementChain.remove(manager);
		return new ArrayList<>();
	}

	/**
	 * This is wrong, and where I spend most of my time before determining that
	 * I just need to build the chain, not the entire map. This function will
	 * map a manager to his/her direct reports. I was just mapping to the
	 * employee name for debugging purposes, but would have eventually mapped to
	 * employee ID for uniqueness;
	 * 
	 * @param mapToEmployeeb
	 * @param employeeMap
	 * @param employee
	 * @return
	 */
	static Map<String, List<Employee>> fillOutMap(
			Map<String, List<Employee>> mapToEmployee,
			List<Employee> employeeMap, Employee employee) {
		for (Employee report : employee.getReports()) {
			if (report.getReports().isEmpty()) {
				mapToEmployee.put(report.getName(), employeeMap);
			} else {
				fillOutMap(mapToEmployee, report.getReports(), report);
			}
		}
		return mapToEmployee;
	}

	public static void main(String[] args) throws IOException {

		final Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
		Employee ceo = null, firstEmployee = null, secondEmployee = null;

		final Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {

			final String type = in.next();
			if (type.equals("end"))
				break;

			if (type.equals("employee")) {
				final int id = in.nextInt();
				final String name = in.next();
				employeeMap.put(id, new Employee(id, name));
			} else if (type.equals("report")) {
				final Employee manager = employeeMap.get(in.nextInt());
				final Employee report = employeeMap.get(in.nextInt());
				manager.addReport(report);
			} else if (type.equals("params")) {
				ceo = employeeMap.get(in.nextInt());
				firstEmployee = employeeMap.get(in.nextInt());
				secondEmployee = employeeMap.get(in.nextInt());
			} else {
				// ignore comments and whitespace
			}
		}

		final Employee result = closestCommonManager(ceo, firstEmployee,
				secondEmployee);

		System.out.println("result "
				+ (result == null ? "<null>" : result.getId() + " "
						+ result.getName()));
	}
}
