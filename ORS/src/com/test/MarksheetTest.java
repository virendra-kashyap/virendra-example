package com.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.dto.MarksheetDTO;
import com.service.MarksheetService;

public class MarksheetTest {
	public static void main(String[] args) {
		MarksheetDTO dto = new MarksheetDTO();
		MarksheetService service = new MarksheetService();
		MarksheetDTO dto1 = service.getById(1);
		System.out.println(dto1.getId() +"\t" + dto1.getName());
		/*
		 * Iterator it = list.iterator(); while (it.hasNext()) { MarksheetDTO
		 * obj = (MarksheetDTO) it.next(); System.out.println(obj.getId() + "\t"
		 * + obj.getRollNumber() + "\t" + obj.getName() + "\t" + obj.getHindi()
		 * + "\t" + obj.getEnglish() + "\t" + obj.getPhysics() + "\t" +
		 * obj.getChemistry() + "\t" + obj.getMaths()); }
		 */
	}

}
