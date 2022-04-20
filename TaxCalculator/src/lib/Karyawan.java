package lib;

public class Karyawan extends Person{
    private String employeeId;
	private String address;

    //Getter & Setter karyawan
    public String getemployeeId() {
        return this.employeeId;
    }

    public void setemployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getaddress() {
        return this.address;
    }

    public void setaddress(String address) {
        this.address = address;
    }
}