package com.management.service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.management.entities.Employe;
import com.management.repository.EmployeRepository;

@Service
public class EmployeService {
	
	@Autowired
	EmployeRepository personRepository;

	public int readAndFetchData() throws Exception {
		List<Employe> personList = new ArrayList<>();
		BufferedReader br = null;
		String strLine;
		String path = "C:\\Users\\Dimpal_bhatia\\Downloads\\sample-data.txt";
		br = new BufferedReader(new FileReader(path));
		br.readLine();
		while ((strLine = br.readLine()) != null) {
			if (!strLine.isEmpty()) {
				personList.add(parseData(strLine));
			}
		}
		personRepository.saveAll(personList);
		br.close();
		return personList.size();
	}

	private static Employe parseData(String str) {
		String[] data = str.split("\\|");
		Employe person = new Employe();
		person.setName(data[0]);
		person.setEmail(data[1]);
		person.setMobile(Integer.parseInt(data[2]));
		person.setGender(data[3]);
		person.setAddress(data[4]);
		person.setCity(data[5]);
		return person;
	}

}
