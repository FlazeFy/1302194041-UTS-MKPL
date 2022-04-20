package lib;

public class TaxFunction {

	//Comment.
	private static final int notMarriednChild = 54000000;
	private static final int married = 58500000;
	private static final int child = 1500000;
	
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		
		int tax = 0;

		check(numberOfMonthWorking, numberOfChildren);
		//Long method_Menghitung pajak.
		if (isMarried) {
			tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - (married + (numberOfChildren * child))));
		}else {
			tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - notMarriednChild));
		}
		
		if (tax < 0) {
			return 0;
		}else {
			return tax;
		}		 
	}
	private static void check(int numberOfMonthWorking, int numberOfChildren){
		//Long method_Mengecek data karyawan (durasi kerja dan jumlah anak).
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
		
		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}
	}
	
}
