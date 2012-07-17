package profile;


import java.util.ArrayList;

import link.link;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;


@XStreamAlias("company")
public class company {
	@XStreamAsAttribute
	private String name = "";
	@XStreamAsAttribute
	private String role = "";
	@XStreamImplicit
	private ArrayList<link> link = new ArrayList<link>();

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public ArrayList<link> getLink() {
		return link;
	}
	
}
