public class Polynomial{
	double [] coeffs;
	int [] powers;
	
	public Polynomial(){
		coeffs = new double[]{0};
		powers = new int[]{0};
	}
	
	public Polynomial(double [] c, int [] p){
		coeffs = c;
		powers = p;
	}

	public Polynomial(File file){
		Scanner scanner = new Scanner(file);
		String str = scanner.nextLine();
		String[] terms = str.split("[+|-]");
		coeffs = new double[terms.length];
		powers = new int[terms.length];

		for (int i = 0; i < terms.length; i++){
			String[] sep = terms[i].split("x");
			coeffs[i] = Double.parseDouble(sep[0]);

			if (sep.length == 1){
				powers[i] = 0;
			}
			else {
				powers[i] = Integer.parseInt(sep[1]);
			}
		}
	}
	
	public Polynomial add (Polynomial p){
		//make new_powers
		int i = 0;
		int j = 0;
		int new_len = 0;
		while (i < (p.coeffs).length && j < (coeffs.length)) {
			if (p.coeffs[i] == coeffs[j]){
				i++;
				j++;
			}
			else if (p.coeffs[i] < coeffs[j]) {
				i++;
			}
			else {
				j++;
			}
			new_len++;
		}

		double [] new_coeffs = new double[new_len];
		int [] new_powers = new int[new_len];
		i = 0;
		j = 0;

		for (int k = 0; k < new_len; k++){
			if (p.powers[i] == powers[j]){
				new_powers[k] = powers[j];
				new_coeffs[k] = p.coeffs[i] + coeffs[j];
				i++;
				j++;
			}
			else if (p.powers[i] < powers[j]){
				new_powers[k] = p.powers[i];
				new_coeffs[k] = p.coeffs[i];
				i++;
			}
			else{
				new_powers[k] = powers[j];
				new_coeffs[k] = coeffs[j];
				j++;
			}
		}
		Polynomial total = new Polynomial(new_coeffs, new_powers);
		return total;
	}
	
	public double evaluate (double x){
		double total = 0;
		for (int i = 0; i < coeffs.length; i++){
			total += coeffs[i] * Math.pow(x, powers[i]);
		}
		return total;
	}
	
	public boolean hasRoot (double val){
		return evaluate(val) == 0;
	}

	public Polynomial single_mult(Polynomial poly, double coeff, int power){
		double [] new_coeffs = poly.coeffs.clone();
		int[] new_powers = poly.powers.clone();
		Polynomial total = new Polynomial(new_coeffs, new_powers);
		for (int i = 0; i < poly.coeffs.length; i++){
			total.coeffs[i] *= coeff;
			total.powers[i] += power;
		}
		return total;
	}

	public Polynomial multiply (Polynomial p) {
		Polynomial total = new Polynomial();
		for (int i = 0; i < coeffs.length(); i++){
			Polynomial new_poly = single_mult(p, coeffs[i], powers[i]);
			total.add(new_poly);
		}
		return total;
	}

	public void saveToFile (String filename){
		PrintStream ps = new PrintStream(filename); 
		String s = "";
		for (int i = 0; i < coeffs.length; i++){
			s = s + coeffs[i];
			if (powers[i] != 0){
				s = s + "x" + powers[i];
			}
			if (i + 1 < coeffs.length && coeffs[i + 1] >= 0){
				s = s + "+";
			}
		}
		
	}

}

/* Modify Polynomial.java as follows:
a. Replace the array representing the coefficients by two arrays: one representing the non-
zero coefficients (of type double) and another one representing the corresponding
exponents (of type int). For example, the polynomial 6 − 2x + 5x ! would be represented
using the arrays [6, -2, 5] and [0, 1, 3]
b. Update the existing methods accordingly
c. Add a method named multiply that takes one argument of type Polynomial and returns
the polynomial resulting from multiplying the calling object and the argument. The
resulting polynomial should not contain redundant exponents.
d. Add a constructor that takes one argument of type File and initializes the polynomial
based on the contents of the file. You can assume that the file contains one line with no
whitespaces representing a valid polynomial. For example: the line 5-3x2+7x8
corresponds to the polynomial 5 − 3x " + 7x #
Hint: you might want to use the following methods: split of the String class, parseInt of
the Integer class, and parseDouble of the Double class
e. Add a method named saveToFile that takes one argument of type String representing a
file name and saves the polynomial in textual format in the corresponding file (similar to
the format used in part d)

*/