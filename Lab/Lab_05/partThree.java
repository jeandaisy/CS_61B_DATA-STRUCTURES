interface disp{
	public static final  String list="up";;
}
class superclass{
	public static final  String list="up" ;
}
class subclass extends superclass implements disp {
	//question1
	
	public void printf(String list) {
		System.out.println(list);
	}
	
	//write a main method to access the constant
	/*
	public static void main(String[] args) {
	System.out.print(superclass.list);
	}	
	
	*/
}

class partThree{
	public static void main(String[] args) {
		subclass object=new subclass();
		object.printf(superclass.list);
		System.out.print("passed!");
	}
	
}
