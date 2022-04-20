package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class Employee extends Karyawan{

	//Primitive Obsession-1.
	private enum Kelamin {
		LakiLaki,
		Perempuan
	}

	//Large Class-1_Data karyawan.
	private Person employee;
	
	//Primitive Obsession-2.
	private Date dateJoined; //year, month, day.

	private int monthWorkingInYear;
	
	private boolean isForeigner;

	//Primitive Obsession-1.
	private Kelamin gender; //true = Laki-laki, false = Perempuan
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	//Large Class-1_Data pasangan.
	private Person spouse;

	//Large Class-1_Data anak.
	private List<Person> child;
	
	public Employee(Karyawan employee, Person employee, Date dateJoined, Kelamin gender) {
		this.employee = employee; //Long Parameter List.
		this.dateJoined = dateJoined; //Primitive Obsession-2.
		this.isForeigner = false; //Long Parameter List-default.
		this.gender = gender;
		
		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}

	//Comment.
	private static final int grade1 = 3000000;
	private static final int grade2 = 5000000;
	private static final int grade3 = 7000000;

	public void setMonthlySalary(int grade) {	
		if (grade == 1) {
			monthlySalary = grade1;
			if (isForeigner) {
				monthlySalary = (int) (grade1 * 1.5);
			}
		}else if (grade == 2) {
			monthlySalary = grade2;
			if (isForeigner) {
				monthlySalary = (int) (grade2 * 1.5);
			}
		}else if (grade == 3) {
			monthlySalary = grade3;
			if (isForeigner) {
				monthlySalary = (int) (grade3 * 1.5);
			}
		}
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public int getAnnualIncomeTax() {
		
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();
		
		//getYear() & getMonth() untuk mendapatkan tahun dan bulan pada variabel dateJoined dengan tipe data Date.
		if (date.getYear() == dateJoined.getYear()) {
			monthWorkingInYear = date.getMonthValue() - dateJoined.getMonth();
		}else {
			monthWorkingInYear = 12;
		}
		
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
	}
}
