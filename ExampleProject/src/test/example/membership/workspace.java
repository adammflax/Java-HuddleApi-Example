package membership;


import java.util.ArrayList;

import link.link;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;


@XStreamAlias("workspace")
public class workspace {
	@XStreamAsAttribute
	private String title = "";
	@XStreamAsAttribute
	private String type = "";
	@XStreamImplicit
	private ArrayList<link> links = new ArrayList<link>();
	@XStreamAlias("settings")
	private settings setting;

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public ArrayList<link> getLinks() {
		return links;
	}

	public settings getSetting() {
		return setting;
	}
}
