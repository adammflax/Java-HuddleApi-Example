package actor;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import link.link;

@XStreamAlias("actor")
public class actor {
	@XStreamAsAttribute
	private String name = "";
	@XStreamAsAttribute
	private String email = "";
	@XStreamAsAttribute
	private String rel = "";
	@XStreamImplicit
	private ArrayList<link> link = new ArrayList<link>();

	public ArrayList<link> getLink() {
		return link;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getRel() {
		return rel;
	}
}
