package documents;

import java.util.ArrayList;

import actor.actor;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import link.link;
@XStreamAlias("document")
public class document {
	@XStreamAsAttribute
	private String title = "";
	@XStreamAsAttribute
	private String description = "";
	@XStreamImplicit
	private ArrayList<link> links = new ArrayList<link>();
	@XStreamImplicit
	private ArrayList<actor> actor = new ArrayList<actor>();
	@XStreamAlias("size")
	private int size = 0;
	@XStreamAlias("version")
	private float  version = 0;
	@XStreamAlias("created")
	private String created = "";
	@XStreamAlias("updated")
	private String updated = "";
	@XStreamAlias("procssingStatus")
	private String processingStatus = "";
	@XStreamAlias("views")
	private int views = 0;
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public ArrayList<link> getLinks() {
		return links;
	}

	public ArrayList<actor> getActor() {
		return actor;
	}

	public int getSize() {
		return size;
	}

	public float getVersion() {
		return version;
	}

	public String getCreated() {
		return created;
	}

	public String getUpdated() {
		return updated;
	}

	public String getProcessingStatus() {
		return processingStatus;
	}

	public int getViews() {
		return views;
	}
	
}
