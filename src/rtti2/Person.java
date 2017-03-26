package rtti2;

public class Person {

	private String name;
	private String lastname;
	private static int numPeople=0;
	
	public Person(){	
	}
	
	
	public Person(String name){
		this.name=name;
		numPeople++;
		
	}

	public Person(String name, String lastname){
		this.name=name;
		this.lastname=lastname;
		numPeople++;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastname() {
		return lastname;
	}

	public static void printPerson(Person p){
		System.out.println(p.getName());
	}
	
	
	
}
