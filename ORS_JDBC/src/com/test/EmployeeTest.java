package com.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.dto.EmployeeDTO;
import com.service.EmployeeService;

public class EmployeeTest {
	public static void main(String[] args) {
		EmployeeDTO dto = new EmployeeDTO();
		EmployeeService service = new EmployeeService();
		// service.add(dto);
		 service.update(dto);
		// service.delete(dto);
		/*
		 * EmployeeDTO dto1 = service.get(); System.out.println( dto1.getEmpId()
		 * + "\t" + dto1.getEmpName() + "\t" + dto1.getSalary() + "\t" +
		 * dto1.getEmpContactNo());
		 */

		/*
		 * ArrayList list = service.List(); Iterator it = list.iterator(); while
		 * (it.hasNext()) { EmployeeDTO obj = (EmployeeDTO) it.next();
		 * System.out.println( obj.getEmpId() + "\t" + obj.getEmpName() + "\t" +
		 * obj.getSalary() + "\t" + obj.getEmpContactNo()); }
		 */

		/*
		 * ArrayList list = service.search(); Iterator it = list.iterator();
		 * while (it.hasNext()) { EmployeeDTO obj = (EmployeeDTO) it.next();
		 * System.out.println( obj.getEmpId() + "\t" + obj.getEmpName() + "\t" +
		 * obj.getSalary() + "\t" + obj.getEmpContactNo()); }
		 */

	}

}
