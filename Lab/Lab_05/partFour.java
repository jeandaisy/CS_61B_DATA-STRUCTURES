class superclass{
	int i=20;
	
	public void disp(){
		System.out.println("superclass"+i);
	}
}
class subclass extends superclass{
	
	int i=30;
	public void dispy(){
//		super.disp();
		System.out.println("subclass"+i);
		
	}
	
}



class partFour{
	public static void main(String[] args) {
/*	question1	
		subclass object=new subclass();
		((superclass)object).disp();
*/
		//	question2	
		/*
		superclass object=new superclass();
		((subclass)object).disp();
		*/
//		question3	
			
			subclass object=new subclass();
//			((superclass)object).disp();
// if subclass and superclass have same method name, will be overide
			(object).dispy();
			
	} 
	}



