package com.yash.hospital.serviceimpl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.yash.hospital.model.Department;
import com.yash.hospital.model.Doctor;
import com.yash.hospital.model.Hospital;
import com.yash.hospital.model.patient;
import com.yash.hospital.service.Lifeline;

public class Pusad implements Lifeline{
	
	List<Hospital> hlist = new ArrayList<>();
	List<Department> delist = new ArrayList<>();
	List<Doctor> dlist = new ArrayList<>();
	List<patient> plist = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	int count=0;
	int count1=0;
	int count2=0;
	int count3=0;

	@Override
	public void addHospital() {
		
		System.out.println("Enter how many hospital data you want to add");
		int hno= sc.nextInt();
		for(int i=0;i<hno;i++)
		{
			Hospital h = new Hospital();
			System.out.print("Enter Hospital id: ");
			h.setHid(sc.nextInt());
			System.out.print("Enter Hospital name: ");
			h.setHname(sc.next());
			while(true)
			{
				try
				{
					Scanner sc = new Scanner(System.in);
					System.out.print("Enter Hospital mobNo: ");
					h.setHmobno(sc.nextLong());
					break;
				}
				catch(InputMismatchException e)
				{
					System.out.println("*****Enter valid Mob No*****");
				}
			
			
			}
			
			System.out.print("Enter Hospital location: ");
			h.setHlocation(sc.next());
			hlist.add(h);
			count++;
			
		}
		
		System.out.println("###Hospital data added successfully###");
		
	}

	@Override
	public void viewHospitalData() {
		if(count>0)
		{
			System.out.println("Enter Hospital id which you want to view otherwise enter 0 for all hospital data");
			int hid=sc.nextInt();
			Iterator<Hospital> itr = hlist.iterator();
			while(itr.hasNext())
			{
			    Hospital h	= itr.next();
			    int h1 = h.getHid();
			    if(hid==h1||hid==0)
			    {
			    	System.out.println("Hospital id: "+h.getHid());
			    	System.out.println("Hospital name: "+h.getHname());
			    	System.out.println("Hospital mobNo: "+h.getHmobno());
			    	System.out.println("Hospital location: "+h.getHlocation());
			    }
			    else
			    {
			    	System.out.println("Enter valid id");
			    }
			}
		}
		else
		{
			System.out.println("Add Hospital data first");
		}
		
	}

	@Override
	public void addDeparment() {
		if(count>0)
		{
			Department d = new Department();
			System.out.println("Enter Department id: ");
			d.setDid(sc.nextInt());
			System.out.println("Enter Department name: ");
			d.setDname(sc.next());
			System.out.println("Enter Hospital id you want to add");
			int hid=sc.nextInt();
			Iterator<Hospital> itr = hlist.iterator();
			while(itr.hasNext())
			{
				Hospital h = itr.next();
				int h1=h.getHid();
				if(h1==hid)
				{
					d.setHospital(h);
					delist.add(d);
					count1++;
				}
				else
				{
					System.out.println("Enter valid hospital id");
				}
			}
			System.out.println("Deparment data added successfully");
		}
		else
		{
			System.out.println("Add hospital data first");
		}
		
	}

	@Override
	public void viewDepartment() {
		if(count1>0)
		{
			System.out.println("Enter Department id which you want to view otherwise enter 0 for all Depertment data");
			int deid=sc.nextInt();
			Iterator<Department> itr = delist.iterator();
			while(itr.hasNext())
			{
				Department d  = itr.next();
				int did = d.getDid();
				if(deid==did||deid==0)
				{
					System.out.println("Department id: "+d.getDid());
					System.out.println("Department name: "+d.getDname());
					System.out.println("Hospital id: "+d.getHospital().getHid());
					System.out.println("Hospital name: "+d.getHospital().getHname());
					System.out.println("Hospital Hmobno: "+d.getHospital().getHmobno());
					System.out.println("Hospital location: "+d.getHospital().getHlocation());
				}
				else
				{
					System.out.println("Enter valid id");
				}
				
			}
		}
		else
		{
			System.out.println("Add department data first");
		}
		
	}

	@Override
	public void addDoctor() {
		if(count1>0)
		{
			Doctor d = new Doctor();
			System.out.println("Enter Doctor id: ");
			d.setDid(sc.nextInt());
			System.out.println("Enter Doctor name: ");
			d.setDname(sc.next());
			System.out.println("Enter Doctor specialist: ");
			d.setSpecialist(sc.next());
			System.out.println("Enter Doctor fees: ");
			d.setDfees(sc.nextInt());
			System.out.println("Enter Doctor salary: ");
			d.setDsalary(sc.nextDouble());
			
			System.out.println("Enter Department id for which department you want to add");
			int did=sc.nextInt();
			
			Iterator<Department> itr = delist.iterator();
			while(itr.hasNext())
			{
				Department de= itr.next();
				int deid=de.getDid();
				if(deid==did)
				{
					d.setDepartment(de);
					dlist.add(d);
					count2++;
				}
				
			}
			System.out.println("Doctor data added successfully");
		}
		else
		{
			System.out.println("Add department data first");
		}
		
	}

	@Override
	public void viewDoctorData() {
		if(count2>0)
		{
			System.out.println("Enter Doctor id which you want to view otherwise enter 0 for all Doctor data");
			int did=sc.nextInt();
			Iterator<Doctor> itr = dlist.iterator();
			while(itr.hasNext())
			{
				Doctor d= itr.next();
				int doid=d.getDid();
				if(did==doid||did==0)
				{
					System.out.println("Doctor id: "+d.getDid());
					System.out.println("Doctor name: "+d.getDname());
					System.out.println("Doctor specialist: "+d.getSpecialist());
					System.out.println("Doctor fees: "+d.getDfees());
					System.out.println("Doctor salary: "+d.getDsalary());
					System.out.println("Department id: "+d.getDepartment().getDid());
					System.out.println("Department name: "+d.getDepartment().getDname());
					System.out.println("Hospital id: "+d.getDepartment().getHospital().getHid());
					System.out.println("Hospital name: "+d.getDepartment().getHospital().getHname());
					System.out.println("Hospital mobno: "+d.getDepartment().getHospital().getHmobno());
					System.out.println("Hospital location: "+d.getDepartment().getHospital().getHlocation());
				}
				else
				{
					
					System.out.println("Enter valid id");
				}
				
			}
		}
		else
		{
			System.out.println("Add Doctor data first");
		}
		
	}

	@Override
	public void addPatient() {
		if(count2>0)
		{
			patient p = new patient();
			System.out.println("Enter Patient id: ");
			p.setPid(sc.nextInt());
			System.out.println("Enter Patient name: ");
			p.setPname(sc.next());
			System.out.println("Enter Patient mobno: ");
			p.setPmobno(sc.nextLong());
			
			System.out.println("Enter Doctor id for which doctor under you want to add");
			int did=sc.nextInt();
			
			Iterator<Doctor> itr = dlist.iterator();
			while(itr.hasNext())
			{
				Doctor d = itr.next();
				int doid=d.getDid();
				if(doid==did)
				{
					p.setDoctor(d);
					plist.add(p);
					count3++;
				}
			}
			System.out.println("Patient data added successfully");
			
		}
		else
		{
			System.out.println("Add doctor data first");
		}
		
	}

	@Override
	public void viewPatient() {
		if(count3>0)
		{
			System.out.println("Enter Patient id which you want to view otherwise enter 0 for all Patient data");
			int pid=sc.nextInt();
			Iterator<patient> itr = plist.iterator();
			while(itr.hasNext())
			{
				patient p=itr.next();
				int pa = p.getPid();
				if(pid==pa||pid==0)
				{
					System.out.println("Patient id: "+p.getPid());
					System.out.println("Patient name: "+p.getPname());
					System.out.println("Patient MobNo: "+p.getPmobno());
					System.out.println("Doctor id: "+p.getDoctor().getDid());
					System.out.println("Doctor name: "+p.getDoctor().getDname());
					System.out.println("Doctor specialist: "+p.getDoctor().getSpecialist());
					System.out.println("Doctor fee: "+p.getDoctor().getDfees());
					System.out.println("Doctor salary: "+p.getDoctor().getDsalary());
					System.out.println("Department id: "+p.getDoctor().getDepartment().getDid());
					System.out.println("Department name: "+p.getDoctor().getDepartment().getDname());
					System.out.println("Hospital id: "+p.getDoctor().getDepartment().getHospital().getHid());
					System.out.println("Hospital name: "+p.getDoctor().getDepartment().getHospital().getHname());
					System.out.println("Hospital Mobno: "+p.getDoctor().getDepartment().getHospital().getHmobno());
					System.out.println("Hospital location: "+p.getDoctor().getDepartment().getHospital().getHlocation());
				}
				else
				{
					System.out.println("Enter valid id");				}
				
				
			}
		}
		else
		{
			System.out.println("Add patient data first");
		}
		
	}

}
