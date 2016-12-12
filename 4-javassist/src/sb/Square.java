package sb;

public class Square extends Shape implements Named {

	private int l=-1;
	private String name="Square-1";

	public String getName() {
		return name;
	}

	public void setl(int len) {
		int x=len+1;
		l = x-1;
	}

	// getl() with a long execution time
	public int getl() {
		int i, result=l;
		for (i=0; i<1000000; i++)
			result += l;
		for (i=0; i<1000000; i++)
			result -= l;
		return result;
	}

}