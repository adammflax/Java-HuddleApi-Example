package profile;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("contact")
public class contact {
	@XStreamAsAttribute
	private String rel = "";
	@XStreamAsAttribute
	private String value = "";

	public String getRel() {
		return rel;
	}

	public String getValue() {
		return value;
	}
	
}
