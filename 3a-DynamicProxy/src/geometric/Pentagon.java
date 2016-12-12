package geometric;

public class Pentagon extends Shape implements PentagonNames , PentagonInterface{
	private int sides;
	private double area,perimeter;
	private String name="Pentagon";
	
	@Override
	public void setSides(int m) {
		//System.out.println("setSides Called");
		sides = m ;
		//System.out.println("sides ="+sides);
	}

	@Override
	public double getPentagonArea() {
		//System.out.println("getPentagonArea Called");
		area  =(5 * Math.pow(sides, 2)) / (4 * Math.tan(Math.PI / 5));
		//System.out.println("area ="+ area);
		return area;
	}

	@Override
	public double getPentagonPerimeter() {
		//System.out.println("getPentagonPerimeter Called");
		perimeter = 5*sides;
		//System.out.println("perimeter ="+ perimeter);
		return perimeter;
	}

	@Override
	public String getPentagonName() {
		return name;
	}
}
