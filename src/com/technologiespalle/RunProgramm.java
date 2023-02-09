package com.technologiespalle;

public class RunProgramm {

	public static void main(String[] args) {
		
		CrudOperations co = new CrudOperations();
//		co.creating();
//		co.inserting(3, "MeghaSai", 55000);
//		co.inserting(4, "Rajesh", 45000);
//		co.updating(1, "BharghavaRaj", 75000);
		co.deleting(4);
	}
}
