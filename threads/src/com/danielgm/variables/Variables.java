package com.danielgm.variables;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Variables {

	
	public static void main(String[] args) throws IOException{
		NumberStore numberStore = new NumberStore();
		System.out.println("the number: "+numberStore.getI());
		numberStore.setInteger(10);
		System.out.println("the number is: " +numberStore.getI());
		
	}
	
	public int suma(int i,int x) throws Exception{
		return i+x;
	}
}



class NumberStore {
	int i = 5;

	public void setInteger(Integer x) {
		System.out.println("he number passed is "+x);
		i = x;
	}

	public int getI() {
		return i;
	}
}


class Generic {
	public void wildCard(){
		List<? extends Number> list = new ArrayList<Integer>();
		
	}
}


