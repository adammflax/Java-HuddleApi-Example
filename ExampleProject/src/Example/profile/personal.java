package profile;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("personal")
public class personal {
	@XStreamAlias("firstname")
	private String firstname = "";
	@XStreamAlias("surname")
	private String surname = "";
	@XStreamAlias("displayname")
	private String displayname = "";

	public String getFirstName() {
		return firstname;
	}

	public String getLastname() {
		return surname;
	}

	public String getDisplayname() {
		return displayname;
	}
}
