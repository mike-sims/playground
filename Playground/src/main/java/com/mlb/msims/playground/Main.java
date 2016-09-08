package com.mlb.msims.playground;

public class Main {

	public static void main(String[] args) {
		NonStaticVar nsv1 = new NonStaticVar();
		nsv1.nonStaticVar = 1;
		NonStaticVar nsv2 = new NonStaticVar();
		nsv2.nonStaticVar = 2;
		System.out.println("non static var1 = "+nsv1.nonStaticVar);
		System.out.println("non static var2 = "+nsv2.nonStaticVar);
		StaticVar sv1 = new StaticVar();
		sv1.staticVar = 1;
		sv1.nonStaticVar = 3;
		StaticVar sv2 = new StaticVar();
		sv2.staticVar = 2;
		sv2.nonStaticVar = 5;
		System.out.println("static var1 = "+sv1.staticVar);
		System.out.println("static var2 = "+sv2.staticVar);
		System.out.println("static var1 = "+sv1.nonStaticVar);
		System.out.println("static var2 = "+sv2.nonStaticVar);
	}

}
