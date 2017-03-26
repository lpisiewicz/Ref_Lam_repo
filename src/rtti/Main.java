package rtti;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {

		//Square
		Object o = Class.forName("rtti.Square").newInstance();
		Square square = (Square) o;
		square.name = "Kwadrat";
		System.out.println(square.name);
		Class square2 = Square.class;
		System.out.println(square2.getName());
		Square s = (Square) square2.newInstance();
		s.name = "Kopniety kwadrat";
		System.out.println(s.name);
		// Class.forName("Circle");
		// System.out.println(square.getName());
		// System.out.println(circle.getClass().getName());
		
		
		//Circle
		Shape circle = new Circle();
		Class klasa = circle.getClass();
		System.out.println(klasa.getSimpleName());
		((Circle)circle).setType("cycek");
		Circle c=(Circle)circle;
		System.out.println(c.getType());
		
		//Access private filed
		Field privateFiledCircle=null;
		privateFiledCircle=Circle.class.getDeclaredField("type");
		privateFiledCircle.setAccessible(true);
		String value=(String) privateFiledCircle.get(c);
		System.out.println("Private value is "+ value);
		
		//Access private method
		
		Prostokat prostokat=new Prostokat();
		Field wartosc=Prostokat.class.getDeclaredField("wartosc");
		wartosc.setAccessible(true);
		wartosc.set(prostokat, "DUpA");
		System.out.println(prostokat.getWartosc());

		
		
		
		Method privateMethod=null;
		privateMethod=prostokat.getClass().getDeclaredMethod("setWartosc", null);
		privateMethod.setAccessible(true);
		privateMethod.invoke(prostokat, "Lukasz_test");
		System.out.println(prostokat.getWartosc());
		
		

		
		
		
		
		

	}

}
