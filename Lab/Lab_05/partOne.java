class X{
	public String str;
}

class Y extends X{
	
}

class partOne{
	public static void main(String[] args) {
	X [] xa;
	Y [] ya;
	xa=new X[1];
	ya=new Y[1];
	
	//xa is an array of X's, ya is an array of Y's
//	xa=ya;
//	ya=(Y[])xa;
	
	//the array of type X[] references objects that are all of class Y
	xa=new Y[1];
	ya=(Y[]) xa;
	
	//ya references an array of Y's,
	System.out.println("passed");
	}
}