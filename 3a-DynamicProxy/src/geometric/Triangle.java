package geometric;

import java.util.Arrays;

public class Triangle extends Shape implements TriangleInterface{
	private int side1,side2,side3;
	private String triangleName;

	@Override
	public void setTriangle(int x, int y, int z) {
		
		side1=x;
		side2=y;
		side3=z;
		
		int arraySides[] = {side1,side2,side3};
		Arrays.sort(arraySides);
		side1=arraySides[0];
		side2=arraySides[1];
		side3=arraySides[2];
		
	}

	@Override
	public String getTriangleName() {
		if((side1 + side2 > side3))
		{
			if((side1==side2) && (side2==side3)){
				triangleName="Equilateral";
			}else if ((side1 == side2) & (side2 != side3) || (side2 == side3) & (side3!= side1)){
				triangleName="Isosceles";
			}else if((side1 != side2) & (side2 != side3)){
				triangleName="Scalene";
			}
		}else{
			triangleName="Invalid";
		}
		return triangleName;
	}
}