package rtti2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {

		Person p = new Person("Tomasz");

		Class clazz = Person.class;
		//Class.forName("Person");

		// Access private field
		try {
			Field field = p.getClass().getDeclaredField("name");

			field.setAccessible(true);
			String name = (String) field.get(p);
			System.out.println(field.get(p));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Access private static filed
		try {

			Field field = Person.class.getDeclaredField("numPeople");
			field.setAccessible(true);
			System.out.println(field.get(null));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Access private method for now it is public

		try {
			Method method = p.getClass().getDeclaredMethod("getName");
			method.setAccessible(true);
			System.out.println(method.invoke(p));
		} catch (Exception e) {
		}

		// Access private method with parameter for now it is public

		try {
			Method method = p.getClass().getMethod("setName", String.class);
			method.setAccessible(true);
			method.invoke(p, "£ukasz");
			System.out.println(p.getName());

		} catch (Exception e) {
		}

		// Access private static method for now it is public. We don't need a
		// instance.

		try {
			Method method = Person.class.getDeclaredMethod("printPerson", Person.class);
			method.setAccessible(true);
			method.invoke(null, p);
		} catch (Exception e) {
		}

		// Access private constructor

		Person other = new Person("Wojtek");
		try {
			Constructor<Person> constructor = Person.class.getConstructor(String.class);
			Person z = constructor.newInstance("Danuta");
			System.out.println(z.getName());
		} catch (Exception e) {

			e.printStackTrace();
		}

		// Access private constructor

		try {
			Constructor c=Person.class.getConstructor();
			Person person1=(Person)c.newInstance();
			person1.setName("Kasia");
			System.out.println(person1.getName());
		} catch (Exception e) {
		}

		// Access private constructor
		Class[] parameters=new Class[]{String.class, String.class};
		Object[] arguments=new Object[]{"Andrzej", "Pisiewicz"};
		try{
		Person person1=Person.class.getConstructor(parameters).newInstance(arguments);
		System.out.println(person1.getName()+" "+ person1.getLastname());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
