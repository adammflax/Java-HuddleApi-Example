package membership;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("settings")
public class settings {
	@XStreamImplicit
	private ArrayList<setting> setting = new ArrayList<setting>();

	public ArrayList<setting> getSetting() {
		return setting;
	}

}
