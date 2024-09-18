public class Polynomial{
	double [] coeffs;
	
	public Polynomial(){
		coeffs = new double[]{0};
	}
	
	public Polynomial(double [] c){
		coeffs = c;
	}
	
	public Polynomial add (Polynomial p){
		double [] c = new double[Math.max((p.coeffs).length, coeffs.length)];
		Polynomial total = new Polynomial(c);
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

/*Develop class Polynomial as follows:
i. It has one field representing the coefficients of the polynomial using an array of
double. A polynomial is assumed to have the form 
ii. It has a no-argument constructor that sets the polynomial to zero (i.e. the
corresponding array would be [0])
iii. It has a constructor that takes an array of double as an argument and sets the
coefficients accordingly
iv. It has a method named add that takes one argument of type Polynomial and
returns the polynomial resulting from adding the calling object and the argument
v. It has a method named evaluate that takes one argument of type double
representing a value of x and evaluates the polynomial accordingly. For example,
if the polynomial is () and evaluate(-1) is invoked, the result should
be 3.
vi. It has a method named hasRoot that takes one argument of type double and
determines whether this value is a root of the polynomial or not. Note that a root
is a value of x for which the polynomial evaluates to zero.
*/