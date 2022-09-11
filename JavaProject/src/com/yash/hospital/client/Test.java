package com.yash.hospital.client;

import java.util.Scanner;

import com.yash.hospital.service.Lifeline;
import com.yash.hospital.serviceimpl.Pusad;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Lifeline l = new Pusad();
		while(true)
		{
			System.out.println("===============================");
			System.out.println("Enter 1 for addHospital"+"\n"+"Enter 2 for viewHospitalData"+"\n"+
		                       "Enter 3 for addDepartment"+"\n"+"Enter 4 for viewDepartment"+"\n"+
					           "Enter 5 for addDoctor"+"\n"+"Enter 6 for viewDoctorData"+"\n"+
		                       "Enter 7 for addPatient"+"\n"+"Enter 8 for viewPatientData");
			System.out.println("===============================");
			int ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				l.addHospital();
				break;
			case 2:
				l.viewHospitalData();
				break;
			case 3:
				l.addDeparment();
				break;
			case 4:
				l.viewDepartment();
				break;
			case 5:
				l.addDoctor();
				break;
			case 6:
				l.viewDoctorData();
				break;
			case 7:
				l.addPatient();
				break;
			case 8:
				l.viewPatient();
				break;
			}
		}
		
		
		
		
		
		
	}
}