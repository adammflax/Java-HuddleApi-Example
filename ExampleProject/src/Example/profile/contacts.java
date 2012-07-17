package profile;


import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("contacts")
public class contacts {
	@XStreamImplicit
	private ArrayList<contact> contact = new ArrayList<contact>();

	public ArrayList<contact> getContact() {
		return contact;
	}
	
}
