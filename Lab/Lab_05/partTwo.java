interface Disp{
	
	//public void disp(int i) /*same name and prototype*/
	//public int disp(int i) /*same name and different return type */
	//public void disp(String str)/*parameter type is different*/
	
	public void disp(int t) ;
}

class superclass{
	
	public void disp(int i) {
		System.out.println();;
	}
}

class subclass extends superclass implements Disp{

	public subclass() {
		// TODO Auto-generated constructor stub
	}
}
class partTwo{	
	public static void main(String[] args) {
		
		subclass object=new subclass();
		object.disp(1);
		
		System.out.println("Pass!!!!");
	}
}
