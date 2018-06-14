/* RunLengthEncoding.java */

/**
 *  The RunLengthEncoding class defines an object that run-length encodes
 *  a PixImage object.  Descriptions of the methods you must implement appear
 *  below.  They include constructors of the form
 *
 *      public RunLengthEncoding(int width, int height);
 *      public RunLengthEncoding(int width, int height, int[] red, int[] green,
 *                               int[] blue, int[] runLengths) {
 *      public RunLengthEncoding(PixImage image) {
 *
 *  that create a run-length encoding of a PixImage having the specified width
 *  and height.
 *
 *  The first constructor creates a run-length encoding of a PixImage in which
 *  every pixel is black.  The second constructor creates a run-length encoding
 *  for which the runs are provided as parameters.  The third constructor
 *  converts a PixImage object into a run-length encoding of that image.
 *
 *  See the README file accompanying this project for additional details.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RunLengthEncoding implements Iterable {

  /**
   *  Define any variables associated with a RunLengthEncoding object here.
   *  These variables MUST be private.
   */
	private int width,height;
//	int[] run;
	private DList<int[]> runs;
	
	



  /**
   *  The following methods are required for Part II.
   */

  /**
   *  RunLengthEncoding() (with two parameters) constructs a run-length
   *  encoding of a black PixImage of the specified width and height, in which
   *  every pixel has red, green, and blue intensities of zero.
   *
   *  @param width the width of the image.
   *  @param height the height of the image.
   */

  public RunLengthEncoding(int width, int height) {
    // Your solution here.
//	  PixImage image=new PixImage(width,height);
	  this.width=width;
	  this.height=height;
	  int[] run = {width*height, 0, 0, 0};
	   runs = new DList<int[]>(run);  
  }

  /**
   *  RunLengthEncoding() (with six parameters) constructs a run-length
   *  encoding of a PixImage of the specified width and height.  The runs of
   *  the run-length encoding are taken from four input arrays of equal length.
   *  Run i has length runLengths[i] and RGB intensities red[i], green[i], and
   *  blue[i].
   *
   *  @param width the width of the image.
   *  @param height the height of the image.
   *  @param red is an array that specifies the red intensity of each run.
   *  @param green is an array that specifies the green intensity of each run.
   *  @param blue is an array that specifies the blue intensity of each run.
   *  @param runLengths is an array that specifies the length of each run.
   *
   *  NOTE:  All four input arrays should have the same length (not zero).
   *  All pixel intensities in the first three arrays should be in the range
   *  0...255.  The sum of all the elements of the runLengths array should be
   *  width * height.  (Feel free to quit with an error message if any of these
   *  conditions are not met--though we won't be testing that.)
   */

  public RunLengthEncoding(int width, int height, int[] red, int[] green,
                           int[] blue, int[] runLengths) {
    // Your solution here.
	  this.height=height;
	  this.width=width;
	  runs = new DList<int[]>();
	 
	  for(int i=0;i<red.length;i++) {
		int[]  run= {runLengths[i],red[i],green[i],blue[i]};
		
		if(runs.isEmpty())
		{
			
			runs.addFirst(run);
		}else {
			DListNode<int[]> v=runs.getLast();
			runs.addAfter(v, run);
		}
	  
	  }
  }
  /**
   *  getWidth() returns the width of the image that this run-length encoding
   *  represents.
   *
   *  @return the width of the image that this run-length encoding represents.
   */

  public int getWidth() {
    // Replace the following line with your solution.
    return width;
  }

  /**
   *  getHeight() returns the height of the image that this run-length encoding
   *  represents.
   *
   *  @return the height of the image that this run-length encoding represents.
   */
  public int getHeight() {
    // Replace the following line with your solution.
    return height;
  }

  /**
   *  iterator() returns a newly created RunIterator that can iterate through
   *  the runs of this RunLengthEncoding.
   *
   *  @return a newly created RunIterator object set to the first run of this
   *  RunLengthEncoding.
   */
  public RunIterator iterator() {
    // Replace the following line with your solution.
     return new RunIterator(runs.getFirst());
    // You'll want to construct a new RunIterator, but first you'll need to
    // write a constructor in the RunIterator class.
    
      
  }

  /**
   *  toPixImage() converts a run-length encoding of an image into a PixImage
   *  object.
   *
   *  @return the PixImage that this RunLengthEncoding encodes.
   */
  public PixImage toPixImage() {
    // Replace the following line with your solution.
	  PixImage image=new PixImage(getWidth(),getHeight());
	  
	  DList<int[]> runs_new=new DList<int[]>();
			  for(RunIterator i=this.iterator();i.hasNext();) {
			      int[] run = i.next();
			      for (int t= 0; t < run[0]; t++) {
			    	  runs_new.addLast(run);
			  System.out.print("(" + run[1]+" "+ run[2]+" "+run[3]+")");
		  }  
	  }	
    int position=1;
 for(int j=0;j<height;j++) {
	 for(int i=0;i<width;i++) {
		
		 DListNode<int[]> run_new=runs_new.nth(position);
		 position++;
		 
		 image.setPixel(i, j, (short) run_new.item[1], (short) run_new.item[2], (short) run_new.item[3]);
	 }
 }
		 
		  
	  return image;
  }
  /**
   *  toString() returns a String representation of this RunLengthEncoding.
   *
   *  This method isn't required, but it should be very useful to you when
   *  you're debugging your code.  It's up to you how you represent
   *  a RunLengthEncoding as a String.
   *
   *  @return a String representation of this RunLengthEncoding.
   */
  public String toString() {
    // Replace the following line with your solution.
	  String result="Run Length Encoding for Image:"+getWidth()+" by "+getHeight()+"\n";
	  DListNode<int[]> node=runs.getFirst();
	  
	 
	  for (int i=1;i<=runs.length();i++) {
		  System.out.print(i);
		  result +="(";
		  result+=node.item[0]+" , "+node.item[1]+" , "+node.item[2]+" , "+node.item[3];
		  result+=")";
			result+="\n";
				node=node.next;
			}
	  
	 
    return result;
  }


  /**
   *  The following methods are required for Part III.
   */

  /**
   *  RunLengthEncoding() (with one parameter) is a constructor that creates
   *  a run-length encoding of a specified PixImage.
   * 
   *  Note that you must encode the image in row-major format, i.e., the second
   *  pixel should be (1, 0) and not (0, 1).
   *
   *  @param image is the PixImage to run-length encode.
   */
  public RunLengthEncoding(PixImage image) {
    // Your solution here, but you should probably leave the following line
    // at the end.
	  this.width=image.getWidth();
	  this.height=image.getHeight();
	 runs = new DList<int[]>(); 
	 
	 int length_count=0;
	  int cur_Color=-1;
	  int prev_Color=-1;
	  
	   for(int j=0;j<image.getHeight();j++) {	   
			 for(int i=0;i<image.getWidth();i++) {
				cur_Color=image.getRed(i, j); 
				if (cur_Color!=prev_Color) {
					length_count++;
					prev_Color=cur_Color;
				}	
				
			 }
			 
	   }
	  int count=1;
	  int[] red = new int[length_count];
	  int[] green = new int[length_count];
	  int[] blue = new int[length_count];
	  int[] runLengths =new int[length_count];
	  int t=0;
	  red[0]=image.getRed(0, 0);
	  green[0]=image.getGreen(0, 0);
	  blue[0]=image.getBlue(0, 0);
	  
	  int passed_counter = 0;
	  for(int j=0;j<image.getHeight();j++) {
			 for(int i=0;i<image.getWidth();i++) {
				 passed_counter++;
				 if(i>0 || j>0) { // do not do anything for the first element
					 if(image.getRed(i, j)!=red[t]) {
						 runLengths[t]=count;
						 count = 1;
						 t++;
						 runLengths[t]=image.getWidth()*image.getHeight() -passed_counter+1;
						 red[t]=image.getRed(i, j);
						 green[t]=image.getGreen(i, j);
						blue[t]=image.getBlue(i, j);
						
						
					 }
					 else {
						 count++;
					 }
				 }
						 
					 red[t]=image.getRed(i, j);
					 green[t]=image.getGreen(i, j);
					blue[t]=image.getBlue(i, j);
					 
				
			 }
	  }	
	  for(int i=0;i<red.length;i++) {
			int[]  run= {runLengths[i],red[i],green[i],blue[i]};
			
			if(runs.isEmpty())
			{
				
				runs.addFirst(run);
			}else {
				DListNode<int[]> v=runs.getLast();
				runs.addAfter(v, run);
			}    
	  
    
  }
	  check();
  }
  /**
   *  check() walks through the run-length encoding and prints an error message
   *  if two consecutive runs have the same RGB intensities, or if the sum of
   *  all run lengths does not equal the number of pixels in the image.
   */
  
  public void check() {
    // Your solution here.
	  
	  int position=1;
	  int count=runs.nth(1).item[0];
	  System.out.println("This is the RUNS: "+toString());
	  System.out.println("This is the Runs Length "+runs.length());
	  for(position=2;position<=runs.length();position++) {
		  DListNode<int[]> node_this=runs.nth(position);
		  DListNode<int[]> node_prev=runs.nth(position).prev;
		  
		  
		  if (runs.nth(position).item[1]==runs.nth(position).prev.item[1]) {
			  System.out.println("two consecutive runs have the same RGB intensities");
			  System.out.println("Two Consecutive runs are "+runs.nth(position).item[1]+" at "+position+" and "+ (position-1));
			  
		  }
		  count+=runs.nth(position).item[0];	  
		  }
	  
	
  	if (count!=width*height) {
	  System.out.println("all run lengths does not equal the number of pixels in the image");
	  System.out.println("RLE is "+count +" and it should be "+ (width*height));
  }
 
  }

  /**
   *  The following method is required for Part IV.
   */

  /**
   *  setPixel() modifies this run-length encoding so that the specified color
   *  is stored at the given (x, y) coordinates.  The old pixel value at that
   *  coordinate should be overwritten and all others should remain the same.
   *  The updated run-length encoding should be compressed as much as possible;
   *  there should not be two consecutive runs with exactly the same RGB color.
   *
   *  @param x the x-coordinate of the pixel to modify.
   *  @param y the y-coordinate of the pixel to modify.
   *  @param red the new red intensity to store at coordinate (x, y).
   *  @param green the new green intensity to store at coordinate (x, y).
   *  @param blue the new blue intensity to store at coordinate (x, y).
   */
  public void setPixel(int x, int y, short red, short green, short blue) {
    // Your solution here, but you should probably leave the following line
    //   at the end.
	  //if setPixel at the first location.
	  if((x==0) && (y==0)) {
		  if(red!=runs.getFirst().item[1]) {
			  if(runs.getFirst().item[0]!=1) {
				  int[] item= new int[] {1,red,green,blue};
				  runs.getFirst().item[0]=runs.getFirst().item[0]-1;
				  runs.addFirst(item);
			  }
			  else {
				  if(red!=runs.getFirst().next.item[1]) {
				  runs.remove(runs.nth(1));
				  int[] item= new int[] {1,red,green,blue};
				  runs.addFirst(item);
				  System.out.println(runs.toString());
				  }
				  else {
					  runs.remove(runs.nth(1));
					  runs.getFirst().item[0]=runs.getFirst().item[0]+1;
				  }
			  }
		  }
	  }
	  
	  //if setPixel at the last location.
	  else if((x==(width-1)) && (y==(height-1))) {
		  if(runs.getLast().item[0]==1) {
			  if(red!=runs.getLast().prev.item[1]) {
				  int[] item= new int[] {1,red,green,blue}; 
				  runs.remove(runs.getLast());
				  runs.addLast(item);
		  }
		  
			  else {
				  runs.remove(runs.getLast());
				  runs.getLast().item[0]=runs.getLast().item[0]+1;
			  }
			  
		  }
		  else {
			  int[] item= new int[] {1,red,green,blue};
			  runs.addLast(item);
			  runs.getLast().prev.item[0]=runs.getLast().prev.item[0]-1;
		  }
	  }
	  
	  //if Pixel is at a random location.
//	 if(((x>0) && (y>0)) && ((x!=(width-1)) && (y!=(height-1))) ) {
//	  if((x>0)&&(x!=(width-1))){
	  else {
	 int loc=y*(width)+x+1; 
	 int count=0;
	 for(int i=0;i<runs.length();i++) {
		 
		loc=loc-runs.nth(i+1).item[0] ;
		count++;
		if (loc<=0) {
			break;
		}
	 }
	 if((loc==0) && (runs.nth(count).item[0]==1)){
		 if((red!=runs.nth(count).next.item[1])&&(red!=runs.nth(count).prev.item[1])) { 
			 int[] item= new int[] {1,red,green,blue};
			 runs.addAfter(runs.nth(count), item);
			 runs.remove(runs.nth(count));
		 }
		 if((red==(runs.nth(count).next).item[1])&& (red!=runs.nth(count).prev.item[1])){
			 runs.remove(runs.nth(count));
			 runs.nth(count).item[0]=runs.nth(count).item[0]+1;
		 }	
		 if((red==(runs.nth(count).prev).item[1])&&(red!=runs.nth(count).next.item[1])) {
			 runs.remove(runs.nth(count));
			 runs.nth(count).prev.item[0]=runs.nth(count).prev.item[0]+1;
		 }	
		 if((red==(runs.nth(count).prev).item[1])&&(red==runs.nth(count).next.item[1])) {
			 runs.nth(count).prev.item[0]=runs.nth(count).prev.item[0]+1+runs.nth(count).next.item[0];
			 runs.remove(runs.nth(count));
			 runs.remove(runs.nth(count));
		 }
	 }
	 else if((loc==0) && (runs.nth(count).item[0]!=1)) {
		 if(red!=runs.nth(count).next.item[1]) {
			 runs.nth(count).item[0]=runs.nth(count).item[0]-1;
			 int[] item= new int[] {1,red,green,blue};
			 runs.addAfter(runs.nth(count), item);	 
		 }
		 else {
			 runs.nth(count+1).item[0]=runs.nth(count+1).item[0]+1;
		 }		 
	 } 
	 else if(loc!=0) {
		 
		 int[] item= new int[] {1,red,green,blue};

//		 DListNode<int[]> dup=runs.nth(count);
//		 System.out.println("This is dup"+dup.item[0]+" "+dup.item[1]+" "+dup.item[2]+" "+dup.item[0]);		 
		 runs.addAfter(runs.nth(count), item);
		 int[] dup=new int[] {runs.nth(count).item[0],runs.nth(count).item[1],runs.nth(count).item[2],runs.nth(count).item[3]};
		 runs.addAfter(runs.nth(count).next, dup);
		 System.out.println(runs.nth(count).item[0]+"This is loc "+loc+"THis is count "+count);
		 runs.nth(count).item[0]=runs.nth(count).item[0]+loc-1;
		 System.out.println(runs.nth(count).next.next.item[0]+"This is loc "+loc+"THis is count "+count);
		 runs.nth(count).next.next.item[0]=runs.nth(count).next.next.item[0]+loc-1;	
		 }
		 
	 
	  }
  check();
}


  /**
   * TEST CODE:  YOU DO NOT NEED TO FILL IN ANY METHODS BELOW THIS POINT.
   * You are welcome to add tests, though.  Methods below this point will not
   * be tested.  This is not the autograder, which will be provided separately.
   */


  /**
   * doTest() checks whether the condition is true and prints the given error
   * message if it is not.
   *
   * @param b the condition to check.
   * @param msg the error message to print if the condition is false.
   */
  private static void doTest(boolean b, String msg) {
    if (b) {
      System.out.println("Good.");
    } else {
      System.err.println(msg);
    }
  }

  /**
   * array2PixImage() converts a 2D array of grayscale intensities to
   * a grayscale PixImage.
   *
   * @param pixels a 2D array of grayscale intensities in the range 0...255.
   * @return a new PixImage whose red, green, and blue values are equal to
   * the input grayscale intensities.
   */
  private static PixImage array2PixImage(int[][] pixels) {
    int width = pixels.length;
    int height = pixels[0].length;
    PixImage image = new PixImage(width, height);

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height;y++) {
        image.setPixel(x, y, (short) pixels[x][y], (short) pixels[x][y],
                       (short) pixels[x][y]);
      }
    }

    return image;
  }

  /**
   * setAndCheckRLE() sets the given coordinate in the given run-length
   * encoding to the given value and then checks whether the resulting
   * run-length encoding is correct.
   *
   * @param rle the run-length encoding to modify.
   * @param x the x-coordinate to set.
   * @param y the y-coordinate to set.
   * @param intensity the grayscale intensity to assign to pixel (x, y).
   */
  private static void setAndCheckRLE(RunLengthEncoding rle,
                                     int x, int y, int intensity) {
    rle.setPixel(x, y,
                 (short) intensity, (short) intensity, (short) intensity);
    rle.check();
  }

  /**
   * main() runs a series of tests of the run-length encoding code.
   */
  public static void main(String[] args) {
    // Be forwarned that when you write arrays directly in Java as below,
    // each "row" of text is a column of your image--the numbers get
    // transposed.
    PixImage image1 = array2PixImage(new int[][] { { 0, 3, 6 },
                                                   { 1, 4, 7 },
                                                   { 2, 5, 8 } });

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
                       "on a 3x3 image.  Input image:");
    System.out.print(image1);
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*
    int [] red = {2,4,1,6,7};
    int [] leth = {2,3,1,1,2};

   RunLengthEncoding rle0 = new RunLengthEncoding(3, 3,red, red,red, leth);
 //   RunLengthEncoding rle0 = new RunLengthEncoding(3, 3);
    
   for(RunIterator i=rle0.iterator();i.hasNext();) {
	   System.out.println(i.next()[3]);
   }
   
   rle0.toPixImage();
   
   System.out.println(rle0.toPixImage().toString());
   System.out.println("XXXXXXXXXX");

  */
   
    
    RunLengthEncoding rle1 = new RunLengthEncoding(image1);
    rle1.check();
    System.out.println("Testing getWidth/getHeight on a 3x3 encoding.");
    doTest(rle1.getWidth() == 3 && rle1.getHeight() == 3,
           "RLE1 has wrong dimensions");
    
    rle1.toPixImage();
    
    System.out.println("Testing toPixImage() on a 3x3 encoding.");
    System.out.println(rle1.toPixImage().toString());
    System.out.println(image1.toString());
    doTest(image1.equals(rle1.toPixImage()),
           "image1 -> RLE1 -> image does not reconstruct the original image");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 0, 0, 42);
    image1.setPixel(0, 0, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           /*
                       array2PixImage(new int[][] { { 42, 3, 6 },
                                                    { 1, 4, 7 },
                                                    { 2, 5, 8 } })),
           */
           "Setting RLE1[0][0] = 42 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 1, 0, 42);
    image1.setPixel(1, 0, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[1][0] = 42 fails.");

  
    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 0, 1, 2);
    image1.setPixel(0, 1, (short) 2, (short) 2, (short) 2);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[0][1] = 2 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 0, 0, 0);
    image1.setPixel(0, 0, (short) 0, (short) 0, (short) 0);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[0][0] = 0 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 2, 2, 7);
    image1.setPixel(2, 2, (short) 7, (short) 7, (short) 7);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[2][2] = 7 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 2, 2, 42);
    image1.setPixel(2, 2, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[2][2] = 42 fails.");
   
    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 1, 2, 42);
    image1.setPixel(1, 2, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[1][2] = 42 fails.");

   
    PixImage image2 = array2PixImage(new int[][] { { 2, 3, 5 },
                                                   { 2, 4, 5 },
                                                   { 3, 4, 6 } });

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
                       "on another 3x3 image.  Input image:");
    System.out.print(image2);

    
    
    RunLengthEncoding rle2 = new RunLengthEncoding(image2);
    rle2.check();
    System.out.println("Testing getWidth/getHeight on a 3x3 encoding.");
    doTest(rle2.getWidth() == 3 && rle2.getHeight() == 3,
           "RLE2 has wrong dimensions");

    System.out.println("Testing toPixImage() on a 3x3 encoding.");
    doTest(rle2.toPixImage().equals(image2),
           "image2 -> RLE2 -> image does not reconstruct the original image");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle2, 0, 1, 2);
    
    image2.setPixel(0, 1, (short) 2, (short) 2, (short) 2);
    doTest(rle2.toPixImage().equals(image2),
           "Setting RLE2[0][1] = 2 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle2, 2, 0, 2);
    image2.setPixel(2, 0, (short) 2, (short) 2, (short) 2);
    doTest(rle2.toPixImage().equals(image2),
           "Setting RLE2[2][0] = 2 fails.");


    PixImage image3 = array2PixImage(new int[][] { { 0, 5 },
                                                   { 1, 6 },
                                                   { 2, 7 },
                                                   { 3, 8 },
                                                   { 4, 9 } });

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
                       "on a 5x2 image.  Input image:");
    System.out.print(image3);
    RunLengthEncoding rle3 = new RunLengthEncoding(image3);
    rle3.check();
    System.out.println("Testing getWidth/getHeight on a 5x2 encoding.");
    doTest(rle3.getWidth() == 5 && rle3.getHeight() == 2,
           "RLE3 has wrong dimensions");

    System.out.println("Testing toPixImage() on a 5x2 encoding.");
    doTest(rle3.toPixImage().equals(image3),
           "image3 -> RLE3 -> image does not reconstruct the original image");

    System.out.println("Testing setPixel() on a 5x2 encoding.");
    setAndCheckRLE(rle3, 4, 0, 6);
    image3.setPixel(4, 0, (short) 6, (short) 6, (short) 6);
    doTest(rle3.toPixImage().equals(image3),
           "Setting RLE3[4][0] = 6 fails.");

    System.out.println("Testing setPixel() on a 5x2 encoding.");
    setAndCheckRLE(rle3, 0, 1, 6);
    image3.setPixel(0, 1, (short) 6, (short) 6, (short) 6);
    doTest(rle3.toPixImage().equals(image3),
           "Setting RLE3[0][1] = 6 fails.");

    System.out.println("Testing setPixel() on a 5x2 encoding.");
    setAndCheckRLE(rle3, 0, 0, 1);
    image3.setPixel(0, 0, (short) 1, (short) 1, (short) 1);
    doTest(rle3.toPixImage().equals(image3),
           "Setting RLE3[0][0] = 1 fails.");


    PixImage image4 = array2PixImage(new int[][] { { 0, 3 },
                                                   { 1, 4 },
                                                   { 2, 5 } });

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
                       "on a 3x2 image.  Input image:");
    System.out.print(image4);
    RunLengthEncoding rle4 = new RunLengthEncoding(image4);
    rle4.check();
    System.out.println("Testing getWidth/getHeight on a 3x2 encoding.");
    doTest(rle4.getWidth() == 3 && rle4.getHeight() == 2,
           "RLE4 has wrong dimensions");

    System.out.println("Testing toPixImage() on a 3x2 encoding.");
    doTest(rle4.toPixImage().equals(image4),
           "image4 -> RLE4 -> image does not reconstruct the original image");

    System.out.println("Testing setPixel() on a 3x2 encoding.");
    setAndCheckRLE(rle4, 2, 0, 0);
    image4.setPixel(2, 0, (short) 0, (short) 0, (short) 0);
    doTest(rle4.toPixImage().equals(image4),
           "Setting RLE4[2][0] = 0 fails.");

    System.out.println("Testing setPixel() on a 3x2 encoding.");
    setAndCheckRLE(rle4, 1, 0, 0);
    image4.setPixel(1, 0, (short) 0, (short) 0, (short) 0);
    doTest(rle4.toPixImage().equals(image4),
           "Setting RLE4[1][0] = 0 fails.");

    System.out.println("Testing setPixel() on a 3x2 encoding.");
    setAndCheckRLE(rle4, 1, 0, 1);
    image4.setPixel(1, 0, (short) 1, (short) 1, (short) 1);
    doTest(rle4.toPixImage().equals(image4),
           "Setting RLE4[1][0] = 1 fails.");
    
   
  }
}
