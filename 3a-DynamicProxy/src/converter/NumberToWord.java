package converter;

public class NumberToWord implements NumberToWordInterface{
	private String valueInString;
	
	private static final String[] specialNames = {
			"",
			" thousand",
			" million",
			" billion",
			" trillion",
			" quadrillion",
			" quintillion"
	};

	private static final String[] tensNames = {
			"",
			" ten",
			" twenty",
			" thirty",
			" forty",
			" fifty",
			" sixty",
			" seventy",
			" eighty",
			" ninety"
	};

	private static final String[] numNames = {
			"",
			" one",
			" two",
			" three",
			" four",
			" five",
			" six",
			" seven",
			" eight",
			" nine",
			" ten",
			" eleven",
			" twelve",
			" thirteen",
			" fourteen",
			" fifteen",
			" sixteen",
			" seventeen",
			" eighteen",
			" nineteen"
	};
	//convertLessThanOneThousand
	private String CLOT(int number) {
		String current;
		//System.out.println("CLOT(int number)");
		//System.out.println("number =" + number);
		if (number % 100 < 20){
			current = numNames[number % 100];
			//System.out.println("if current =" + current);
			number /= 100;
			//System.out.println("if number =" + number);
		}
		else {
			current = numNames[number % 10];
			//System.out.println("numNames current =" + current);
			number /= 10;
			//System.out.println("else number =" + number);
			current = tensNames[number % 10] + current;
			//System.out.println("tensNames current =" + current);
			number /= 10;
			//System.out.println("tensNames number =" + number);
		}
		if (number == 0) return current;
		return current = numNames[number] + " hundred" + current;
	}
	private String convert(int number) {
		//System.out.println("String convert(int number) =" + number);
		if (number == 0) { return "zero"; }

		String prefix = "";

		if (number < 0) {
			number = -number;
			//System.out.println("-number =" +number);
			prefix = "negative";
		}

		String current = "";
		int place = 0;
		while (number > 0){
		//do {
			int n = number % 1000;
			if (n != 0){
				String s = CLOT(n);
				current = s + specialNames[place] + current;
				//System.out.println("INplace =" + place);
			}
			place++;
			number /= 1000;
		}; //while (number > 0);
		//System.out.println("place =" + place);

		return (prefix + current).trim();
		//return current;
	}
	
	@Override
	public void setNumber(int m) {
		valueInString=convert(m);
	}

	@Override
	public String getNumberString() {
		return valueInString;
	}
	public static void main(String[] args) {
		NumberToWord obj = new NumberToWord();
		obj.setNumber(12345678);
		System.out.println(obj.getNumberString());
	}

}
