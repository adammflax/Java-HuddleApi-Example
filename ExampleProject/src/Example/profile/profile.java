package profile;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("profile")
public class profile {
	@XStreamAlias("personal")
	private personal personal;
	@XStreamAlias("company")
	private company company;
	@XStreamAlias("contacts")
	private contacts contacts;

	public personal getPersonal() {
		return personal;
	}

	public company getCompany() {
		return company;
	}

	public contacts getContacts() {
		return contacts;
	}
}
