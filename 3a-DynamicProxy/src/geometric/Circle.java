package geometric;

public class Circle extends Shape implements CircleNames , CircleInterface{
	private int radius;
	private double area,perimeter;
	private String name="Circle";
	@Override
	public void setRadius(int m) {
		//System.out.println("setRadius Called");
		radius = m ;
		//System.out.println("radius ="+radius);
	}
	@Override
	public double getCircleArea() {
		//System.out.println("getCircleArea Called");
		area = Math.PI * radius * radius;
		//System.out.println("area ="+ area);
		return area;
	}
	@Override
	public double getCirclePerimeter() {
		//System.out.println("getCirclePerimeter Called");
		perimeter = 2 * Math.PI * radius;
		//System.out.println("perimeter ="+perimeter);
		return perimeter;
	}
	@Override
	public String getCircleName() {
		return name;
	}
}