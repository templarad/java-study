package objectsystem;

public class ObjectSystem {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		//Test1
		Object obj = new Object();
		Object obj2 = new Object();
		System.out.println("クラスオブジェクトは唯一か？");
		System.out.println("1. obj2.getClass == obj.getClass? : "+ (obj2.getClass() == obj.getClass()) );
		System.out.println("2. Object.class.getClass == ClassObject?: "+ (Object.class.getClass() == Class.class));
		
		//Test 2
		ObjectSystem obs = new ObjectSystem();
		Class<Class> a = Class.class;//a is class object of java.lang.Class
		
		System.out.println();
		System.out.println("Class<T>はTクラスオブジェクトと言えるか");
		System.out.println("3. a.getName() is :"+a.getName());
		System.out.println("4. a.getClass.getName is "+a.getClass().getName());
		
		System.out.println("5. "+ obs.getClass().getSimpleName()+"'s class object is instance of Class: "+(obs.getClass() instanceof Class));
		System.out.println("6. "+ obs.getClass().getSimpleName()+"'s class object is instance of Object: "+(obs.getClass() instanceof Object));

		System.out.println();
		System.out.println("全てのオブジェクトはjava.lang.Objectのインスタンス");
		System.out.println("7. obs is instance of Object: "+(obs instanceof Object));
		System.out.println("8. obj is instance of Object: "+(obj instanceof Object));
		System.out.println("9. Class object is instance of Object: "+(Class.class instanceof Object));
		
		
		System.out.println();
		System.out.println("クラスオブジェクトの型はjava.lang.Class");
		System.out.println("10. Class object is instance of Class: "+(Class.class instanceof Class));		
		System.out.println("11. obj is instance of Class: "+(obj instanceof Class));
//		System.out.println("11.1. obj is instance of Object: "+(obj instanceof Object));
//		System.out.println("11.2. Object.class object is instance of Class: "+(Object.class instanceof Class));
//		System.out.println("So Object ≠ Object.class");
		System.out.println("12. obj.getClass is instance of Class: "+(obj.getClass() instanceof Class));
		System.gc();
		
	}

}
