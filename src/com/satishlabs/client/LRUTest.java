package com.satishlabs.client;

import java.security.KeyStore.Entry;
import java.util.Map;
import java.util.Set;

import com.satishlabs.cache.LRUCache;
import com.satishlabs.model.Department;
import com.satishlabs.model.Employee;

public class LRUTest {
	public static void main(String[] args) {
		Employee e1 = new Employee(1001, "Satish", 10000.00, "satish@gmail");
		Employee e2 = new Employee(2001, "Amrish", 80000.00, "amrish@gmail");
		Employee e3 = new Employee(3001, "Kumar", 50000.00, "kumar@gmail");
		Employee e4 = new Employee(4001, "Dharam", 70000.00, "dharm@gmail");
		Employee e5 = new Employee(5001, "Srikant", 90000.00, "srikant@gmail");

		Department d1 = new Department(1001, "CS", "Ranchi");
		Department d2 = new Department(1002, "HR", "Bangalore");
		
		LRUCache<Employee, Department> cache = LRUCache.newInstance(2);
		
		cache.put(e1, d1);
		cache.put(e2, d1);
		cache.put(e3, d1);
		
		cache.put(e4, d2);
		cache.put(e5, d2);
		
		Set<Map.Entry<Employee, Department>> entrySet = cache.entrySet();
		for(Map.Entry<Employee, Department> entry: entrySet) {
			Employee employee = entry.getKey();
			Department department = entry.getValue();
			System.out.println(employee+" "+department);
		}
	}
}
