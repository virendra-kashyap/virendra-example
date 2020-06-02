package com.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.dto.MarksheetDTO;
import com.service.MarksheetService;

public class MarksheetTest {
	public static void main(String[] args) {

		MarksheetDTO dto = new MarksheetDTO();
		MarksheetService service = new MarksheetService();
		dto.setRollNo("DS102");
		dto.setName("Virendra");
		service.update(dto);

		/*
		 * MarksheetDTO dto1 = service.getMarksheet("DS104");
		 * System.out.println(dto1.getName() + "\t" + dto1.getPhysics() + "\t" +
		 * dto1.getChemistry() + "\t" + dto1.getMaths() + "\t" +
		 * dto1.getTotal());
		 */

		/*
		 * ArrayList list = service.marksheetList(); Iterator it =
		 * list.iterator(); while (it.hasNext()) { MarksheetDTO obj =
		 * (MarksheetDTO) it.next(); System.out.println(obj.getRollNo() + "\t" +
		 * obj.getName() + "\t" + obj.getPhysics() + "\t" + obj.getChemistry() +
		 * "\t" + obj.getMaths()); }
		 */

		// service.delete(dto);

		// dto.setName("An");
		ArrayList list = service.searchMarksheet("A");
		Iterator it = list.iterator();
		while (it.hasNext()) {
			MarksheetDTO obj = (MarksheetDTO) it.next();
			System.out.println(obj.getRollNo() + "\t" + obj.getName() + "\t" + obj.getPhysics() + "\t"
					+ obj.getChemistry() + "\t" + obj.getMaths());
		}
	}

}
