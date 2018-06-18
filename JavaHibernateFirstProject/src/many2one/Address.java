package many2one;

public class Address {
		private int id;
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		private int houseNo;
		private int streetNo;
		private String city;
		private String state;
		private String zipCode;
		
		
		public Address() {}
		
		public Address(int houseNo, int streetNo, String city, String state,
				String zipCode) {
			super();
			this.houseNo = houseNo;
			this.streetNo = streetNo;
			this.city = city;
			this.state = state;
			this.zipCode = zipCode;
		}
		
		
		
		
		
		public int getHouseNo() {
			return houseNo;
		}
		public void setHouseNo(int houseNo) {
			this.houseNo = houseNo;
		}
		public int getStreetNo() {
			return streetNo;
		}
		public void setStreetNo(int streetNo) {
			this.streetNo = streetNo;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getZipCode() {
			return zipCode;
		}
		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}
		
		
}
