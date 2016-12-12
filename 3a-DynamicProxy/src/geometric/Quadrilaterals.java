package geometric;

public class Quadrilaterals extends Shape implements QuadrilateralsNames,QuadrilateralsInterface,QuadrilateralsInterface2 {

	private int length,width,area,perimeter;
	private String name;
	private String namesArray[] = {"Square","Rectangle"};
	
	@Override
	public void setArea(int m, int n) {
		//System.out.println("setArea Called");
		length = m ;
		width  = n;
		//System.out.println("length ="+length + " width="+width);	
	}
	@Override
	public int getArea() {
		//System.out.println("getArea Called");
		area = length*width; 
		//System.out.println("area ="+area);
		return area;
	}
	@Override
	public int getPerimeter() {
		System.out.println("getPerimeter Called");
		perimeter =(2*length) + (2*width); 
		System.out.println("perimeter ="+perimeter);
		return perimeter;
	}
	@Override
	public String getName() {
		//System.out.println("getName Called");
		if(length  == width)
			name = namesArray[0];
		else
			name = namesArray[1];
		//System.out.println("name ="+name);
		return name;
	}
}