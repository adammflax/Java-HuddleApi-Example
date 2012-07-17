package folder;

import java.util.ArrayList;

import link.link;

import actor.actor;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import documents.documents;

@XStreamAlias("folder")
public class folder {
	@XStreamAsAttribute
	private String title;
	@XStreamAsAttribute
	private String description;
	@XStreamImplicit
	private ArrayList<link> links = new ArrayList<link>();
	@XStreamAlias("updated")
	private String updated = "";
	@XStreamAlias("created")
	private String created = "";
	@XStreamImplicit
	private  ArrayList<actor> actor = new ArrayList<actor>();
	@XStreamAlias("documents")
	private documents document;
	@XStreamAlias("folders")
	private folders folders;
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public ArrayList<link> getLinks() {
		return links;
	}
	
	public String getUpdated() {
		return updated;
	}
	
	public String getCreated() {
		return created;
	}

	public documents getDocument() {
		return document;
	}

	public folders getFolders() {
		return folders;
	}

	public ArrayList<actor> getActor() {
		return actor;
	}
}
