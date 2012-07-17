package membership;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("setting")
public class setting {
	@XStreamAsAttribute
	private String name = "";
	@XStreamAsAttribute
	private String value = "";

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
}
