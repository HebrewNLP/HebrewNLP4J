package il.co.hebrewnlp.names;

import org.json.JSONObject;

public class NameInfo {

	private int male;
	private int female;
	private int firstName;
	private int lastName;

	public NameInfo(int male, int female, int firstName, int lastName) {
		this.male = male;
		this.female = female;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getMale() {
		return male;
	}

	public void setMale(int male) {
		this.male = male;
	}

	public int getFemale() {
		return female;
	}

	public void setFemale(int female) {
		this.female = female;
	}

	public int getFirstName() {
		return firstName;
	}

	public void setFirstName(int firstName) {
		this.firstName = firstName;
	}

	public int getLastName() {
		return lastName;
	}

	public void setLastName(int lastName) {
		this.lastName = lastName;
	}
	
	public static NameInfo fromJson(JSONObject obj) {
		return new NameInfo(obj.getInt("Male"), obj.getInt("Female"), obj.getInt("FirstName"), obj.getInt("LastName"));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + female;
		result = prime * result + firstName;
		result = prime * result + lastName;
		result = prime * result + male;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NameInfo other = (NameInfo) obj;
		if (female != other.female)
			return false;
		if (firstName != other.firstName)
			return false;
		if (lastName != other.lastName)
			return false;
		if (male != other.male)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NameInfo [male=" + male + ", female=" + female + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
	
}
