public class Driver {
	public static void main(String [] args) {
		//System.out.println("testing testing 1 2 3");
		Polynomial p = new Polynomial();
		System.out.println(p.evaluate(3));
		double [] c1 = {6,5};
		int[] pow1 = {0,3};
		Polynomial p1 = new Polynomial(c1, pow1);
		double [] c2 = {-2,-9};
		int [] pow2 = {1, 4};
		Polynomial p2 = new Polynomial(c2, pow2);
		Polynomial s = p1.add(p2);
		//s.print();
		Polynomial t = p1.multiply(p2);
		t.print();
		
		// for (int i = 0; i < s.coeffs.length; i++){
			//System.out.println(s.coeffs[i]);
		//}
		System.out.println("s(0.1) = " + s.evaluate(0.1));
		System.out.println("t(1) = " + t.evaluate(1));
		if(s.hasRoot(1)){
			System.out.println("1 is a root of s");
		}
		else {
			System.out.println("1 is not a root of s");
		}
	}
}