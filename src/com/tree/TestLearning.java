package com.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestLearning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee e1 = new Employee("a", 12, 100);
		Employee e2 = new Employee("b", 14, 200);
		Employee e3 = new Employee("c", 15, 100);
		Employee e4 = new Employee("d", 16, 150);

		List<Employee> list = new ArrayList<>();
		Collections.addAll(list, e1, e2, e3, e4);

		Comparator<Employee> comparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				if (o2.getSalary() == o1.getSalary()) {
					return o1.getAge() - o2.getAge();
				} else {
					return (int) (o2.getSalary() - o1.getSalary());
				}
			}
		};

		Collections.sort(list, comparator);
		System.out.println(list);
	}

}
