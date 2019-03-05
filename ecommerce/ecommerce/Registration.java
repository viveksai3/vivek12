package ecommerce;

import java.io.Serializable;
import java.util.stream.IntStream;

public class Registration implements Serializable{

	
		private String firstName,lastName,password,address;
		private long phoneNo,regNo;
		
		
		
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public long getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(long phoneNo) {
			this.phoneNo = phoneNo;
		}
		public long getregNo() {
			return regNo;
		}
		public void setregNo(long regNo) {
			this.regNo = regNo;
		}
		
		
		
	
}
