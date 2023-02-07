package com.employee.model;

public class employeSql {
		private long address_id;
		private String first_name;
		private String last_name;
		private String department;
		public employeSql(long address_id, String first_name, String last_name, String department) {
			super();
			this.address_id = address_id;
			this.first_name = first_name;
			this.last_name = last_name;
			this.department = department;
		}
		public long getAddress_id() {
			return address_id;
		}
		public void setAddress_id(long address_id) {
			this.address_id = address_id;
		}
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}


}
