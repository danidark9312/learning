package com.danielgm.variables;

public class Estudiante extends Persona{
	
	public void estudiar(){
		pensar();
		System.out.println("estoy estudiando");
	}
	
	public void hacerTarea(){
		estudiar();
	}
	public Estudiante(){
		
	}

}





class Persona{
	public void pensar(){
		System.out.println("estoy pensando");
	}
}
