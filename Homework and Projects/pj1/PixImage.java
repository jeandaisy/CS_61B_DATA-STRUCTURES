//import java.util.Arrays;

/* PixImage.java */


/**
 *  The PixImage class represents an image, which is a rectangular grid of
 *  color pixels.  Each pixel has red, green, and blue intensities in the range
 *  0...255.  Descriptions of the methods you must implement appear below.
 *  They include a constructor of the form
 *
 *      public PixImage(int width, int height);
 *
 *  that creates a black (zero intensity) image of the specified width and
 *  height.  Pixels are numbered in the range (0...width - 1, 0...height - 1).
 *
 *  All methods in this class must be implemented to complete Part I.
 *  See the README file accompanying this project for additional details.
 */

public class PixImage {

	private  int width;
	private  int height;
	private short[][][] color;
		
  /**
   *  Define any variables associated with a PixImage object here.  These
   *  variables MUST be private.
   */

  /**
   * PixImage() constructs an empty PixImage with a specified width and height.
   * Every pixel has red, green, and blue intensities of zero (solid black).
   *
   * @param width the width of the image.
   * @param height the height of the image.
   */
  public PixImage(int width, int height) {
    // Your solution here.

	  this.width=width;
	  this.height=height;
	color=new short[3][width][height];
	
	for (int row=0;row<width;row++) {
		for (int column=0;column<height;column++){
		color[0][row][column]=0;
		color[1][row][column]= 0;
		color[2][row][column]=0;
	
	}
	}
	
  }

/**
   * getWidth() returns the width of the image.
   *
   * @return the width of the image.
   */
  public int getWidth() {
    // Replace the following line with your solution.
/*
	  BufferedImage myPicture=null;
	  try {
		  myPicture=ImageIO.read(this.getClass().getResource("Dog.tiff"));
	  }catch(IOException e) {
		  
	  }
	  */
	 
    return width;
  }

  /**
   * getHeight() returns the height of the image.
   *
   * @return the height of the image.
   */
  public int getHeight() {
    // Replace the following line with your solution.
	/*  BufferedImage myPicture=null;
	  try {
		  myPicture=ImageIO.read(this.getClass().getResource("Dog.tiff"));
	  }catch(IOException e) {
		  
	  }
	  */
    return height;
  }

  /**
   * getRed() returns the red intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the red intensity of the pixel at coordinate (x, y).
   */
  public short getRed(int x, int y) {
    // Replace the following line with your solution.
	 
    return color[0][x][y];
  }

  /**
   * getGreen() returns the green intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the green intensity of the pixel at coordinate (x, y).
   */
  public short getGreen(int x, int y) {
    // Replace the following line with your solution.
	  
    return  color[1][x][y];
    
  }

  /**
   * getBlue() returns the blue intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the blue intensity of the pixel at coordinate (x, y).
   */
  public short getBlue(int x, int y) {
    // Replace the following line with your solution.

    return color[2][(x)][y];
  }

  /**
   * setPixel() sets the pixel at coordinate (x, y) to specified red, green,
   * and blue intensities.
   *
   * If any of the three color intensities is NOT in the range 0...255, then
   * this method does NOT change any of the pixel intensities.
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @param red the new red intensity for the pixel at coordinate (x, y).
   * @param green the new green intensity for the pixel at coordinate (x, y).
   * @param blue the new blue intensity for the pixel at coordinate (x, y).
   */
  public void setPixel(int x, int y, short red, short green, short blue) {
    // Your solution here.
	  if (red <= 255 && red >= 0) {
		  color[0][x][y]=red;
	  }
	  if (green <= 255 && green >= 0) {
		  color[1][x][y]=green;
	  }
	  if (blue <= 255 && blue >= 0) {
		  color[2][x][y]=blue;
  }
  }
  /**
   * toString() returns a String representation of this PixImage.
   *
   * This method isn't required, but it should be very useful to you when
   * you're debugging your code.  It's up to you how you represent a PixImage
   * as a String.
   *
   * @return a String representation of this PixImage.
   */
  public String toString() {
    // Replace the following line with your solution.

	  String result="Image:"+getWidth()+" by "+getHeight()+"\n";

	  for (int row=0;row<width;row++) {
		  for (int column=0;column<height;column++){
				result+="(" +getRed(row,column)+" , "+getGreen(row,column)+" , "+getBlue(row,column)+" ) ";
			}
		result+="\n";
	  }
		
   return result;
  }


/**
   * boxBlur() returns a blurred version of "this" PixImage.
   *
   * If numIterations == 1, each pixel in the output PixImage is assigned
   * a value equal to the average of its neighboring pixels in "this" PixImage,
   * INCLUDING the pixel itself.
   *
   * A pixel not on the image boundary has nine neighbors--the pixel itself and
   * the eight pixels surrounding it.  A pixel on the boundary has six
   * neighbors if it is not a corner pixel; only four neighbors if it is
   * a corner pixel.  The average of the neighbors is the sum of all the
   * neighbor pixel values (including the pixel itself) divided by the number
   * of neighbors, with non-integer quotients rounded toward zero (as Java does
   * naturally when you divide two integers).
   *
   * Each color (red, green, blue) is blurred separately.  The red input should
   * have NO effect on the green or blue outputs, etc.
   *
   * The parameter numIterations specifies a number of repeated iterations of
   * box blurring to perform.  If numIterations is zero or negative, "this"
   * PixImage is returned (not a copy).  If numIterations is positive, the
   * return value is a newly constructed PixImage.
   *
   * IMPORTANT:  DO NOT CHANGE "this" PixImage!!!  All blurring/changes should
   * appear in the new, output PixImage only.
   *
   * @param numIterations the number of iterations of box blurring.
   * @return a blurred version of "this" PixImage.
   */
 public int[] top_left_corner_Neibor(int x, int y) {
     int[] RGB=new int[3];
	 int red_new=(getRed(x,y)+getRed(x,(y+1))+getRed((x+1),y)+getRed((x+1),(y+1)))/4;
	 int green_new=(getGreen(x,y)+getGreen(x,(y+1))+getGreen((x+1),y)+getGreen((x+1),(y+1)))/4;
	 int blue_new=(getBlue(x,y)+getBlue(x,(y+1))+getBlue((x+1),y)+getBlue((x+1),(y+1)))/4;
	 RGB[0]=red_new;
	 RGB[1]=green_new;
	 RGB[2]=blue_new;
	return RGB;
	 
//	 setPixel(x, y, (short)red_new, (short)green_new, (short)blue_new);
 }
 
 public int[] top_right_corner_Neibor(int x, int y) {
	 int[] RGB=new int[3];
	 int red_new=(getRed(x,y)+getRed((x-1),(y))+getRed((x-1),(y+1))+getRed((x),(y+1)))/4;
	 int green_new=(getGreen(x,y)+getGreen((x-1),(y))+getGreen((x-1),(y+1))+getGreen((x),(y+1)))/4;
	 int blue_new=(getBlue(x,y)+getBlue((x-1),(y))+getBlue((x-1),(y+1))+getBlue((x),(y+1)))/4;
	 RGB[0]=red_new;
	 RGB[1]=green_new;
	 RGB[2]=blue_new;
	return RGB;
 }
 
 public int[] bottom_left_corner_Neibor(int x, int y) {
	 int[] RGB=new int[3];
	 int red_new=(getRed(x,y)+getRed((x+1),(y))+getRed((x+1),(y-1))+getRed((x),(y-1)))/4;
	 int green_new=(getGreen(x,y)+getGreen((x+1),(y))+getGreen((x+1),(y-1))+getGreen((x),(y-1)))/4;
	 int blue_new=(getBlue(x,y)+getBlue((x+1),(y))+getBlue((x+1),(y-1))+getBlue((x),(y-1)))/4;
	 RGB[0]=red_new;
	 RGB[1]=green_new;
	 RGB[2]=blue_new;
	return RGB;
 }
 
 public int[] bottom_right_corner_Neibor(int x, int y) {
	 int[] RGB=new int[3];
	 int red_new=(getRed(x,y)+getRed(x,(y-1))+getRed((x-1),y)+getRed((x-1),(y-1)))/4;
	 int green_new=(getGreen(x,y)+getGreen(x,(y-1))+getGreen((x-1),y)+getGreen((x-1),(y-1)))/4;
	 int blue_new=(getBlue(x,y)+getBlue(x,(y-1))+getBlue((x-1),y)+getBlue((x-1),(y-1)))/4;
	 RGB[0]=red_new;
	 RGB[1]=green_new;
	 RGB[2]=blue_new;
	return RGB;
 }
 
 public int[] top_edge_Neibor(int x, int y) {
	 int[] RGB=new int[3];
	 int red_new=(getRed((x-1),y)+getRed(x,y)+getRed((x+1),y)+getRed((x-1),(y+1))+getRed((x),(y+1))+getRed((x+1),(y+1)))/6;
	 int green_new=(getGreen((x-1),y)+getGreen(x,y)+getGreen((x+1),y)+getGreen((x-1),(y+1))+getGreen((x),(y+1))+getGreen((x+1),(y+1)))/6;
	 int blue_new=(getBlue((x-1),y)+getBlue(x,y)+getBlue((x+1),y)+getBlue((x-1),(y+1))+getBlue((x),(y+1))+getBlue((x+1),(y+1)))/6;
	 RGB[0]=red_new;
	 RGB[1]=green_new;
	 RGB[2]=blue_new;
	return RGB;
 }
 
public int[] bottom_edge_Neibor(int x, int y) {
	int[] RGB=new int[3];
	 int red_new=(getRed((x-1),y)+getRed(x,y)+getRed((x+1),y)+getRed((x-1),(y-1))+getRed((x),(y-1))+getRed((x+1),(y-1)))/6;
	 int green_new=(getGreen((x-1),y)+getGreen(x,y)+getGreen((x+1),y)+getGreen((x-1),(y-1))+getGreen((x),(y-1))+getGreen((x+1),(y-1)))/6;
	 int blue_new=(getBlue((x-1),y)+getBlue(x,y)+getBlue((x+1),y)+getBlue((x-1),(y-1))+getBlue((x),(y-1))+getBlue((x+1),(y-1)))/6;
	 RGB[0]=red_new;
	 RGB[1]=green_new;
	 RGB[2]=blue_new;
	return RGB;
 }

public int[] left_edge_Neibor(int x, int y) {
	int[] RGB=new int[3];
	 int red_new=(getRed((x+1),y)+getRed(x,y)+getRed((x+1),(y+1))+getRed((x),(y+1))+getRed((x),(y-1))+getRed((x+1),(y-1)))/6;
	 int green_new=(getGreen((x+1),y)+getGreen(x,y)+getGreen((x+1),(y+1))+getGreen((x),(y+1))+getGreen((x),(y-1))+getGreen((x+1),(y-1)))/6;
	 int blue_new=(getBlue((x+1),y)+getBlue(x,y)+getBlue((x+1),(y+1))+getBlue((x),(y+1))+getBlue((x),(y-1))+getBlue((x+1),(y-1)))/6;
	 RGB[0]=red_new;
	 RGB[1]=green_new;
	 RGB[2]=blue_new;
	return RGB;
}

public int[] right_edge_Neibor(int x, int y) {
	int[] RGB=new int[3];
	 int red_new=(getRed((x-1),y)+getRed(x,y)+getRed((x-1),(y+1))+getRed((x),(y+1))+getRed((x-1),(y-1))+getRed((x),(y-1)))/6;
	 int green_new=(getGreen((x-1),y)+getGreen(x,y)+getGreen((x-1),(y+1))+getGreen((x),(y+1))+getGreen((x),(y-1))+getGreen((x-1),(y-1)))/6;
	 int blue_new=(getBlue((x-1),y)+getBlue(x,y)+getBlue((x-1),(y+1))+getBlue((x),(y+1))+getBlue((x),(y-1))+getBlue((x-1),(y-1)))/6;
	 RGB[0]=red_new;
	 RGB[1]=green_new;
	 RGB[2]=blue_new;
	return RGB;
}
 
public int[] middle_Neibor(int x, int y) {
	int[] RGB=new int[3];
	 int red_new=(getRed((x-1),(y-1))+getRed(x,(y-1))+getRed((x+1),(y-1))+getRed((x-1),y)+getRed(x,y)+getRed((x+1),y)+getRed((x-1),(y+1))+getRed((x),(y+1))+getRed((x+1),(y+1)))/9;
	 int green_new=(getGreen((x-1),(y-1))+getGreen(x,(y-1))+getGreen((x+1),(y-1))+getGreen((x-1),y)+getGreen(x,y)+getGreen((x+1),y)+getGreen((x-1),(y+1))+getGreen((x),(y+1))+getGreen((x+1),(y+1)))/9;
	 int blue_new=(getBlue((x-1),(y-1))+getBlue(x,(y-1))+getBlue((x+1),(y-1))+getBlue((x-1),y)+getBlue(x,y)+getBlue((x+1),y)+getBlue((x-1),(y+1))+getBlue((x),(y+1))+getBlue((x+1),(y+1)))/9;
	 RGB[0]=red_new;
	 RGB[1]=green_new;
	 RGB[2]=blue_new;
	return RGB;
 }


  public PixImage boxBlur(int numIterations) {
    // Replace the following line with your solution.
	  
	  PixImage Object=new PixImage(width,height);
	  
	  
	  if (numIterations<1) {
		  return this;
	  } 
	  
	  if ((width>1) && (height>1)){
		 Object.setPixel(0, 0, (short)top_left_corner_Neibor(0,0)[0], (short)top_left_corner_Neibor(0,0)[1], (short)top_left_corner_Neibor(0,0)[2]);
		 Object.setPixel((width-1), 0, (short)top_right_corner_Neibor((width-1),0)[0], (short)top_right_corner_Neibor((width-1),0)[1], (short)top_right_corner_Neibor((width-1),0)[2]);
		 Object.setPixel(0, (height-1), (short)bottom_left_corner_Neibor(0,(height-1))[0], (short)bottom_left_corner_Neibor(0,(height-1))[1], (short)bottom_left_corner_Neibor(0,(height-1))[2]);
		 Object.setPixel((width-1), (height-1), (short)bottom_right_corner_Neibor((width-1), (height-1))[0], (short)bottom_right_corner_Neibor((width-1), (height-1))[1], (short)bottom_right_corner_Neibor((width-1), (height-1))[2]);
		 
		 
		 for (int i=1;i<(width-1);i++) {
			 Object.setPixel(i, 0, (short)top_edge_Neibor(i,0)[0], (short)top_edge_Neibor(i,0)[1], (short)top_edge_Neibor(i,0)[2]);
			 Object.setPixel(i, (height-1), (short)bottom_edge_Neibor(i,(height-1))[0], (short)bottom_edge_Neibor(i,(height-1))[1], (short)bottom_edge_Neibor(i,(height-1))[2]);
			 	 
		 }
		 for (int i=1;i<(height-1);i++) {
			 Object.setPixel(0,i,(short)left_edge_Neibor(0,i)[0], (short)left_edge_Neibor(0,i)[1], (short)left_edge_Neibor(0,i)[2]);
			 Object.setPixel((width-1),i,(short)right_edge_Neibor((width-1),i)[0], (short)right_edge_Neibor((width-1),i)[1], (short)right_edge_Neibor((width-1),i)[2]);
			  
		 }
		 for (int i=1;i<(width-1);i++) {
			 for (int j=1;j<(height-1);j++) {
				 Object.setPixel(i,j,(short)middle_Neibor(i,j)[0],(short)middle_Neibor(i,j)[1],(short)middle_Neibor(i,j)[2]);
				 
				 
			 }
		 }
	  }
	  
	  
	if(numIterations==1) { 
    return Object;
	}else {
		return Object.boxBlur(numIterations-1);
	}
}

  /**
   * mag2gray() maps an energy (squared vector magnitude) in the range
   * 0...24,969,600 to a grayscale intensity in the range 0...255.  The map
   * is logarithmic, but shifted so that values of 5,080 and below map to zero.
   *
   * DO NOT CHANGE THIS METHOD.  If you do, you will not be able to get the
   * correct images and pass the autograder.
   *
   * @param mag the energy (squared vector magnitude) of the pixel whose
   * intensity we want to compute.
   * @return the intensity of the output pixel.
   */
  private static short mag2gray(long mag) {
    short intensity = (short) (30.0 * Math.log(1.0 + (double) mag) - 256.0);

    // Make sure the returned intensity is in the range 0...255, regardless of
    // the input value.
    if (intensity < 0) {
      intensity = 0;
    } else if (intensity > 255) {
      intensity = 255;
    }
    return intensity;
  }

  /**
   * sobelEdges() applies the Sobel operator, identifying edges in "this"
   * image.  The Sobel operator computes a magnitude that represents how
   * strong the edge is.  We compute separate gradients for the red, blue, and
   * green components at each pixel, then sum the squares of the three
   * gradients at each pixel.  We convert the squared magnitude at each pixel
   * into a grayscale pixel intensity in the range 0...255 with the logarithmic
   * mapping encoded in mag2gray().  The output is a grayscale PixImage whose
   * pixel intensities reflect the strength of the edges.
   *
   * See http://en.wikipedia.org/wiki/Sobel_operator#Formulation for details.
   *
   * @return a grayscale PixImage representing the edges of the input image.
   * Whiter pixels represent stronger edges.
   */
 public int[][] reflection_red(int x,int y) {
	 int[][] red_reflection = new int[3][3];

	 if((x!=0)&&(y!=0)&&(x!=(width-1))&&(y!=(height-1))) {
	 red_reflection[0][0]=color[0][x-1][y-1];
	 red_reflection[1][0]=color[0][x][y-1];
	 red_reflection[2][0]=color[0][x+1][y-1];
	 red_reflection[0][1]=color[0][x-1][y];
	 red_reflection[1][1]=color[0][x][y];
	 red_reflection[2][1]=color[0][x+1][y];
	 red_reflection[0][2]=color[0][x-1][y+1];
	 red_reflection[1][2]=color[0][x][y+1];
	 red_reflection[2][2]=color[0][x+1][y+1];
	 }
	 if((x==0) && (y!=0)&&(y!=(height-1))){
		 red_reflection[0][0]=color[0][x][y-1];
		 red_reflection[1][0]=color[0][x][y-1];
		 red_reflection[2][0]=color[0][x+1][y-1];
		 red_reflection[0][1]=color[0][x][y];
		 red_reflection[1][1]=color[0][x][y];
		 red_reflection[2][1]=color[0][x+1][y];
		 red_reflection[0][2]=color[0][x][y+1];
		 red_reflection[1][2]=color[0][x][y+1];
		 red_reflection[2][2]=color[0][x+1][y+1]; 
	 }
	 if((x!=0) && (y==0) && (x!=(width-1))){
		 red_reflection[0][0]=color[0][x-1][y];
		 red_reflection[1][0]=color[0][x][y];
		 red_reflection[2][0]=color[0][x+1][y];
		 red_reflection[0][1]=color[0][x-1][y];
		 red_reflection[1][1]=color[0][x][y];
		 red_reflection[2][1]=color[0][x+1][y];
		 red_reflection[0][2]=color[0][x-1][y+1];
		 red_reflection[1][2]=color[0][x][y+1];
		 red_reflection[2][2]=color[0][x+1][y+1];
	 }
	 if((x==0)&&(y==0)) {
		 red_reflection[0][0]=color[0][x][y];
		 red_reflection[1][0]=color[0][x][y];
		 red_reflection[2][0]=color[0][x+1][y];
		 red_reflection[0][1]=color[0][x][y];
		 red_reflection[1][1]=color[0][x][y];
		 red_reflection[2][1]=color[0][x+1][y];
		 red_reflection[0][2]=color[0][x][y+1];
		 red_reflection[1][2]=color[0][x][y+1];
		 red_reflection[2][2]=color[0][x+1][y+1];
		 
		 }
	 if((x==0) && (y==(height-1))) {
		 red_reflection[0][0]=color[0][x][y-1];
		 red_reflection[1][0]=color[0][x][y-1];
		 red_reflection[2][0]=color[0][x+1][y-1];
		 red_reflection[0][1]=color[0][x][y];
		 red_reflection[1][1]=color[0][x][y];
		 red_reflection[2][1]=color[0][x+1][y];
		 red_reflection[0][2]=color[0][x][y];
		 red_reflection[1][2]=color[0][x][y];
		 red_reflection[2][2]=color[0][x+1][y];
		 }
	 if((x==(width-1))&&(y==0)) {
		 red_reflection[0][0]=color[0][x-1][y];
		 red_reflection[1][0]=color[0][x][y];
		 red_reflection[2][0]=color[0][x][y];
		 red_reflection[0][1]=color[0][x-1][y];
		 red_reflection[1][1]=color[0][x][y];
		 red_reflection[2][1]=color[0][x][y];
		 red_reflection[0][2]=color[0][x-1][y+1];
		 red_reflection[1][2]=color[0][x][y+1];
		 red_reflection[2][2]=color[0][x][y+1];
		 }
	 if((x==(width-1))&&(y==(height-1))) {
		 red_reflection[0][0]=color[0][x-1][y-1];
		 red_reflection[1][0]=color[0][x][y-1];
		 red_reflection[2][0]=color[0][x][y-1];
		 red_reflection[0][1]=color[0][x-1][y];
		 red_reflection[1][1]=color[0][x][y];
		 red_reflection[2][1]=color[0][x][y];
		 red_reflection[0][2]=color[0][x-1][y];
		 red_reflection[1][2]=color[0][x][y];
		 red_reflection[2][2]=color[0][x][y];
		 }
	 if((x==(width-1))&&(y!=(height-1))&&(y!=0)) {
		 red_reflection[0][0]=color[2][x-1][y-1];
		 red_reflection[1][0]=color[2][x][y-1];
		 red_reflection[2][0]=color[2][x][y-1];
		 red_reflection[0][1]=color[2][x-1][y];
		 red_reflection[1][1]=color[2][x][y];
		 red_reflection[2][1]=color[2][x][y];
		 red_reflection[0][2]=color[2][x-1][y+1];
		 red_reflection[1][2]=color[2][x][y+1];
		 red_reflection[2][2]=color[2][x][y+1];
		 }
	 if((x!=(width-1))&&(y==(height-1))&&(x!=0)) {
		 red_reflection[0][0]=color[2][x-1][y-1];
		 red_reflection[1][0]=color[2][x][y-1];
		 red_reflection[2][0]=color[2][x+1][y-1];
		 red_reflection[0][1]=color[2][x-1][y];
		 red_reflection[1][1]=color[2][x][y];
		 red_reflection[2][1]=color[2][x+1][y];
		 red_reflection[0][2]=color[2][x-1][y];
		 red_reflection[1][2]=color[2][x][y];
		 red_reflection[2][2]=color[2][x+1][y];
		 }
	 
	return red_reflection;
 }

 public int[][] reflection_green(int x,int y) {
	 int[][] green_reflection = new int[3][3];

	 if((x!=0)&&(y!=0)&&(x!=(width-1))&&(y!=(height-1))) {
	 green_reflection[0][0]=color[1][x-1][y-1];
	 green_reflection[1][0]=color[1][x][y-1];
	 green_reflection[2][0]=color[1][x+1][y-1];
	 green_reflection[0][1]=color[1][x-1][y];
	 green_reflection[1][1]=color[1][x][y];
	 green_reflection[2][1]=color[1][x+1][y];
	 green_reflection[0][2]=color[1][x-1][y+1];
	 green_reflection[1][2]=color[1][x][y+1];
	 green_reflection[2][2]=color[1][x+1][y+1];
	 }
	 if((x==0) && (y!=0)&&(y!=(height-1))){
		 green_reflection[0][0]=color[1][x][y-1];
		 green_reflection[1][0]=color[1][x][y-1];
		 green_reflection[2][0]=color[1][x+1][y-1];
		 green_reflection[0][1]=color[1][x][y];
		 green_reflection[1][1]=color[1][x][y];
		 green_reflection[2][1]=color[1][x+1][y];
		 green_reflection[0][2]=color[1][x][y+1];
		 green_reflection[1][2]=color[1][x][y+1];
		 green_reflection[2][2]=color[1][x+1][y+1]; 
	 }
	 if((x!=0) && (y==0) && (x!=(width-1))){
		 green_reflection[0][0]=color[1][x-1][y];
		 green_reflection[1][0]=color[1][x][y];
		 green_reflection[2][0]=color[1][x+1][y];
		 green_reflection[0][1]=color[1][x-1][y];
		 green_reflection[1][1]=color[1][x][y];
		 green_reflection[2][1]=color[1][x+1][y];
		 green_reflection[0][2]=color[1][x-1][y+1];
		 green_reflection[1][2]=color[1][x][y+1];
		 green_reflection[2][2]=color[1][x+1][y+1];
	 }
	 if((x==0)&&(y==0)) {
		 green_reflection[0][0]=color[1][x][y];
		 green_reflection[1][0]=color[1][x][y];
		 green_reflection[2][0]=color[1][x+1][y];
		 green_reflection[0][1]=color[1][x][y];
		 green_reflection[1][1]=color[1][x][y];
		 green_reflection[2][1]=color[1][x+1][y];
		 green_reflection[0][2]=color[1][x][y+1];
		 green_reflection[1][2]=color[1][x][y+1];
		 green_reflection[2][2]=color[1][x+1][y+1];
		 }
	 if((x==0) && (y==(height-1))) {
		 green_reflection[0][0]=color[1][x][y-1];
		 green_reflection[1][0]=color[1][x][y-1];
		 green_reflection[2][0]=color[1][x+1][y-1];
		 green_reflection[0][1]=color[1][x][y];
		 green_reflection[1][1]=color[1][x][y];
		 green_reflection[2][1]=color[1][x+1][y];
		 green_reflection[0][2]=color[1][x][y];
		 green_reflection[1][2]=color[1][x][y];
		 green_reflection[2][2]=color[1][x+1][y];
		 }
	 if((x==(width-1))&&(y==0)) {
		 green_reflection[0][0]=color[1][x-1][y];
		 green_reflection[1][0]=color[1][x][y];
		 green_reflection[2][0]=color[1][x][y];
		 green_reflection[0][1]=color[1][x-1][y];
		 green_reflection[1][1]=color[1][x][y];
		 green_reflection[2][1]=color[1][x][y];
		 green_reflection[0][2]=color[1][x-1][y+1];
		 green_reflection[1][2]=color[1][x][y+1];
		 green_reflection[2][2]=color[1][x][y+1];
		 }
	 if((x==(width-1))&&(y==(height-1))) {
		 green_reflection[0][0]=color[1][x-1][y-1];
		 green_reflection[1][0]=color[1][x][y-1];
		 green_reflection[2][0]=color[1][x][y-1];
		 green_reflection[0][1]=color[1][x-1][y];
		 green_reflection[1][1]=color[1][x][y];
		 green_reflection[2][1]=color[1][x][y];
		 green_reflection[0][2]=color[1][x-1][y];
		 green_reflection[1][2]=color[1][x][y];
		 green_reflection[2][2]=color[1][x][y];
		 }
	 if((x==(width-1))&&(y!=(height-1))&&(y!=0)) {
		 green_reflection[0][0]=color[2][x-1][y-1];
		 green_reflection[1][0]=color[2][x][y-1];
		 green_reflection[2][0]=color[2][x][y-1];
		 green_reflection[0][1]=color[2][x-1][y];
		 green_reflection[1][1]=color[2][x][y];
		 green_reflection[2][1]=color[2][x][y];
		 green_reflection[0][2]=color[2][x-1][y+1];
		 green_reflection[1][2]=color[2][x][y+1];
		 green_reflection[2][2]=color[2][x][y+1];
		 }
	 if((x!=(width-1))&&(y==(height-1))&&(x!=0)) {
		 green_reflection[0][0]=color[2][x-1][y-1];
		 green_reflection[1][0]=color[2][x][y-1];
		 green_reflection[2][0]=color[2][x+1][y-1];
		 green_reflection[0][1]=color[2][x-1][y];
		 green_reflection[1][1]=color[2][x][y];
		 green_reflection[2][1]=color[2][x+1][y];
		 green_reflection[0][2]=color[2][x-1][y];
		 green_reflection[1][2]=color[2][x][y];
		 green_reflection[2][2]=color[2][x+1][y];
		 }
	return green_reflection;
 }

 public int[][] reflection_blue(int x,int y) {
	 int[][] blue_reflection = new int[3][3];

	 if((x!=0)&&(y!=0)&&(x!=(width-1))&&(y!=(height-1))) {
	 blue_reflection[0][0]=color[2][x-1][y-1];
	 blue_reflection[1][0]=color[2][x][y-1];
	 blue_reflection[2][0]=color[2][x+1][y-1];
	 blue_reflection[0][1]=color[2][x-1][y];
	 blue_reflection[1][1]=color[2][x][y];
	 blue_reflection[2][1]=color[2][x+1][y];
	 blue_reflection[0][2]=color[2][x-1][y+1];
	 blue_reflection[1][2]=color[2][x][y+1];
	 blue_reflection[2][2]=color[2][x+1][y+1];
	 }
	 if((x==0) && (y!=0)&&(y!=(height-1))){
		 blue_reflection[0][0]=color[2][x][y-1];
		 blue_reflection[1][0]=color[2][x][y-1];
		 blue_reflection[2][0]=color[2][x+1][y-1];
		 blue_reflection[0][1]=color[2][x][y];
		 blue_reflection[1][1]=color[2][x][y];
		 blue_reflection[2][1]=color[2][x+1][y];
		 blue_reflection[0][2]=color[2][x][y+1];
		 blue_reflection[1][2]=color[2][x][y+1];
		 blue_reflection[2][2]=color[2][x+1][y+1]; 
	 }
	 if((x!=0) && (y==0) && (x!=(width-1))){
		 blue_reflection[0][0]=color[2][x-1][y];
		 blue_reflection[1][0]=color[2][x][y];
		 blue_reflection[2][0]=color[2][x+1][y];
		 blue_reflection[0][1]=color[2][x-1][y];
		 blue_reflection[1][1]=color[2][x][y];
		 blue_reflection[2][1]=color[2][x+1][y];
		 blue_reflection[0][2]=color[2][x-1][y+1];
		 blue_reflection[1][2]=color[2][x][y+1];
		 blue_reflection[2][2]=color[2][x+1][y+1];
	 }
	 if((x==0)&&(y==0)) {
		 blue_reflection[0][0]=color[2][x][y];
		 blue_reflection[1][0]=color[2][x][y];
		 blue_reflection[2][0]=color[2][x+1][y];
		 blue_reflection[0][1]=color[2][x][y];
		 blue_reflection[1][1]=color[2][x][y];
		 blue_reflection[2][1]=color[2][x+1][y];
		 blue_reflection[0][2]=color[2][x][y+1];
		 blue_reflection[1][2]=color[2][x][y+1];
		 blue_reflection[2][2]=color[2][x+1][y+1];
		 }
	 if((x==0) && (y==(height-1))) {
		 blue_reflection[0][0]=color[2][x][y-1];
		 blue_reflection[1][0]=color[2][x][y-1];
		 blue_reflection[2][0]=color[2][x+1][y-1];
		 blue_reflection[0][1]=color[2][x][y];
		 blue_reflection[1][1]=color[2][x][y];
		 blue_reflection[2][1]=color[2][x+1][y];
		 blue_reflection[0][2]=color[2][x][y];
		 blue_reflection[1][2]=color[2][x][y];
		 blue_reflection[2][2]=color[2][x+1][y];
		 }
	 if((x==(width-1))&&(y==0)) {
		 blue_reflection[0][0]=color[2][x-1][y];
		 blue_reflection[1][0]=color[2][x][y];
		 blue_reflection[2][0]=color[2][x][y];
		 blue_reflection[0][1]=color[2][x-1][y];
		 blue_reflection[1][1]=color[2][x][y];
		 blue_reflection[2][1]=color[2][x][y];
		 blue_reflection[0][2]=color[2][x-1][y+1];
		 blue_reflection[1][2]=color[2][x][y+1];
		 blue_reflection[2][2]=color[2][x][y+1];
		 }
	 if((x==(width-1))&&(y==(height-1))) {
		 blue_reflection[0][0]=color[2][x-1][y-1];
		 blue_reflection[1][0]=color[2][x][y-1];
		 blue_reflection[2][0]=color[2][x][y-1];
		 blue_reflection[0][1]=color[2][x-1][y];
		 blue_reflection[1][1]=color[2][x][y];
		 blue_reflection[2][1]=color[2][x][y];
		 blue_reflection[0][2]=color[2][x-1][y];
		 blue_reflection[1][2]=color[2][x][y];
		 blue_reflection[2][2]=color[2][x][y];
		 }
	 if((x==(width-1))&&(y!=(height-1))&&(y!=0)) {
		 blue_reflection[0][0]=color[2][x-1][y-1];
		 blue_reflection[1][0]=color[2][x][y-1];
		 blue_reflection[2][0]=color[2][x][y-1];
		 blue_reflection[0][1]=color[2][x-1][y];
		 blue_reflection[1][1]=color[2][x][y];
		 blue_reflection[2][1]=color[2][x][y];
		 blue_reflection[0][2]=color[2][x-1][y+1];
		 blue_reflection[1][2]=color[2][x][y+1];
		 blue_reflection[2][2]=color[2][x][y+1];
		 }
	 if((x!=(width-1))&&(y==(height-1))&&(x!=0)) {
		 blue_reflection[0][0]=color[2][x-1][y-1];
		 blue_reflection[1][0]=color[2][x][y-1];
		 blue_reflection[2][0]=color[2][x+1][y-1];
		 blue_reflection[0][1]=color[2][x-1][y];
		 blue_reflection[1][1]=color[2][x][y];
		 blue_reflection[2][1]=color[2][x+1][y];
		 blue_reflection[0][2]=color[2][x-1][y];
		 blue_reflection[1][2]=color[2][x][y];
		 blue_reflection[2][2]=color[2][x+1][y];
		 }
	return blue_reflection;
 }
  public PixImage sobelEdges() {
    // Replace the following line with your solution.
	  PixImage Object1=new PixImage(getWidth(),getHeight());
	  
	  int[][] gx=new int[3][3];
	  int[][] gy=new int[3][3];
	
	  int energy_value=0;
	  int sum_red_gx=0;
	  int sum_red_gy=0;
	  int sum_green_gx=0;
	  int sum_green_gy=0;
	  int sum_blue_gx=0;
	  int sum_blue_gy=0;
	  
	  gx[0][0]=1;
	  gx[0][1]=2;
	  gx[0][2]=1;
	  gx[1][0]=0;
	  gx[1][1]=0;
	  gx[1][2]=0;
	  gx[2][0]=-1;
	  gx[2][1]=-2;
	  gx[2][2]=-1;
	  
	  gy[0][0]=1;
	  gy[0][1]=0;
	  gy[0][2]=-1;
	  gy[1][0]=2;
	  gy[1][1]=0;
	  gy[1][2]=-2;
	  gy[2][0]=1;
	  gy[2][1]=0;
	  gy[2][2]=-1;
	  
	  for(int i=0;i<width;i++) {
		  for(int j=0;j<height;j++) {
			  energy_value = 0;
			  sum_red_gx = 0;
			  sum_red_gy = 0;
			  sum_green_gx = 0;
			  sum_green_gy = 0;
			  sum_blue_gx = 0;
			  sum_blue_gy = 0;
			  for(int t=0; t<3; t++) {
				  for(int m=0;m<3;m++) {
				  sum_red_gx+=(int)(gx[t][m]*reflection_red(i,j)[t][m]);
			      sum_red_gy+=(int)(gy[t][m]*reflection_red(i,j)[t][m]);
			      sum_green_gx+=(int)(gx[t][m]*reflection_green(i,j)[t][m]);
			      sum_green_gy+=(int)(gy[t][m]*reflection_green(i,j)[t][m]);
			      sum_blue_gx+=(int)(gx[t][m]*reflection_blue(i,j)[t][m]);
			      sum_blue_gy+=(int)(gy[t][m]*reflection_blue(i,j)[t][m]);
				  } 
			  }
				energy_value+=(int) (sum_red_gx*sum_red_gx+sum_red_gy*sum_red_gy+sum_green_gx*sum_green_gx+sum_green_gy*sum_green_gy+sum_blue_gx*sum_blue_gx+sum_blue_gy*sum_blue_gy);
				Object1.color[0][i][j]=mag2gray(energy_value);
				Object1.color[1][i][j]=mag2gray(energy_value);
				Object1.color[2][i][j]=mag2gray(energy_value);
		  }
	  }
    return Object1;
    // Don't forget to use the method mag2gray() above to convert energies to
    // pixel intensities.
  
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
      for (int y = 0; y < height; y++) {
        image.setPixel(x, y, (short) pixels[x][y], (short) pixels[x][y],
                       (short) pixels[x][y]);
        
      }
    
    
    }
    
    return image;
  }

  /**
   * equals() checks whether two images are the same, i.e. have the same
   * dimensions and pixels.
   *
   * @param image a PixImage to compare with "this" PixImage.
   * @return true if the specified PixImage is identical to "this" PixImage.
   */
  public boolean equals(PixImage image) {
    int width = getWidth();
    int height = getHeight();

    if (image == null ||
        width != image.getWidth() || height != image.getHeight()) {
      return false;
    }

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        if (! (getRed(x, y) == image.getRed(x, y) &&
               getGreen(x, y) == image.getGreen(x, y) &&
               getBlue(x, y) == image.getBlue(x, y))) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * main() runs a series of tests to ensure that the convolutions (box blur
   * and Sobel) are correct.
   */
  public static void main(String[] args) {
    // Be forwarned that when you write arrays directly in Java as below,
    // each "row" of text is a column of your image--the numbers get
    // transposed.
  
	  PixImage image1 = array2PixImage(new int[][] { { 0, 10, 240 },
                                                   { 30, 120, 250 },
                                                   { 80, 250, 255 } });
    System.out.println("Testing getWidth/getHeight on a 3x3 image.  " +
                       "Input image:");

    
    System.out.print(image1.toString());

   
    doTest(image1.getWidth() == 3 && image1.getHeight() == 3,"Incorrect image width and height.");

    
    System.out.println("Testing blurring on a 3x3 image.");
    
   System.out.print((image1.boxBlur(1)).toString());
    
    doTest(image1.boxBlur(1).equals(
           array2PixImage(new int[][] { { 40, 108, 155 },
                                        { 81, 137, 187 },
                                        { 120, 164, 218 } })),
           "Incorrect box blur (1 rep):\n" + image1.boxBlur(1));
   
    doTest(image1.boxBlur(2).equals(
           array2PixImage(new int[][] { { 91, 118, 146 },
                                        { 108, 134, 161 },
                                        { 125, 151, 176 } })),
           "Incorrect box blur (2 rep):\n" + image1.boxBlur(2));
    doTest(image1.boxBlur(2).equals(image1.boxBlur(1).boxBlur(1)),
           "Incorrect box blur (1 rep + 1 rep):\n" +
           image1.boxBlur(2) + image1.boxBlur(1).boxBlur(1));

    System.out.println("Testing edge detection on a 3x3 image.");
    
    doTest(image1.sobelEdges().equals(
           array2PixImage(new int[][] { { 104, 189, 180 },
                                        { 160, 193, 157 },
                                        { 166, 178, 96 } })),
           "Incorrect Sobel:\n" + image1.sobelEdges());


    PixImage image2 = array2PixImage(new int[][] { { 0, 100, 100 },
                                                   { 0, 0, 100 } });
    System.out.println("Testing getWidth/getHeight on a 2x3 image.  " +
                       "Input image:");

    System.out.print(image2.toString());
    doTest(image2.getWidth() == 2 && image2.getHeight() == 3,
           "Incorrect image width and height.");

    System.out.println("Testing blurring on a 2x3 image.");
    doTest(image2.boxBlur(1).equals(
           array2PixImage(new int[][] { { 25, 50, 75 },
                                        { 25, 50, 75 } })),
           "Incorrect box blur (1 rep):\n" + image2.boxBlur(1));
/*
    System.out.println("Testing edge detection on a 2x3 image.");
    doTest(image2.sobelEdges().equals(
           array2PixImage(new int[][] { { 122, 143, 74 },
                                        { 74, 143, 122 } })),
           "Incorrect Sobel:\n" + image2.sobelEdges());
           */
  }
}
