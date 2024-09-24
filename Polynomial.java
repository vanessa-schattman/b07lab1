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
	
	public Polynomial add (Polynomial p){
		double [] new_coeffs = new double[Math.max((p.coeffs).length, coeffs.length)];
		//int [] p = new int[Math.max((p.).length, coeffs.length)];

		//make new_powers
		int i = 0;
		int j = 0;
		int pow_len = 0;
		while (i < (p.coeffs).length && j < (coeffs.length)) {
			if (p.coeffs[i] == coeffs[j]){
				i++;
				j++;
				pow_len++;
			}

			if (p.coeffs[i] < coeffs[j]) {
				i++;
				pow_len++;
			}

			
		}

	
		Polynomial total = new Polynomial(new_coeffs, new_powers);
		int i = 0;
		for (i = 0; i < Math.max((p.coeffs).length, coeffs.length); i++){
			if (i >= p.coeffs.length) {
				total.coeffs[i] = coeffs[i];
			}
			else if (i >= coeffs.length) {
				total.coeffs[i] = p.coeffs[i];
			}
			else {
				total.coeffs[i] = p.coeffs[i] + coeffs[i];
			}
		}
		return total;
	}
	
	public double evaluate (double x){
		double total = 0;
		for (int i = 0; i < coeffs.length; i++){
			total += coeffs[i] * Math.pow(x, i);
		}
		return total;
	}
	
	public boolean hasRoot (double val){
		return evaluate(val) == 0;
	}
}

/* Modify Polynomial.java as follows:
a. Replace the array representing the coefficients by two arrays: one representing the non-
zero coefficients (of type double) and another one representing the corresponding
exponents (of type int). For example, the polynomial 6 − 2𝑥 + 5𝑥 ! would be represented
using the arrays [6, -2, 5] and [0, 1, 3]
b. Update the existing methods accordingly
c. Add a method named multiply that takes one argument of type Polynomial and returns
the polynomial resulting from multiplying the calling object and the argument. The
resulting polynomial should not contain redundant exponents.
d. Add a constructor that takes one argument of type File and initializes the polynomial
based on the contents of the file. You can assume that the file contains one line with no
Fall 2024
whitespaces representing a valid polynomial. For example: the line 5-3x2+7x8
corresponds to the polynomial 5 − 3𝑥 " + 7𝑥 #
Hint: you might want to use the following methods: split of the String class, parseInt of
the Integer class, and parseDouble of the Double class
e. Add a method named saveToFile that takes one argument of type String representing a
file name and saves the polynomial in textual format in the corresponding file (similar to
the format used in part d)

*/