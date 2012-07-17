package link;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("link")

public class link {
	
	@XStreamAsAttribute
	private String href = "";
	@XStreamAsAttribute
	private String rel = "";
	@XStreamAsAttribute
	private String type ="";
	@XStreamAsAttribute
	private String title = "";
	
	private link()
	{
		
	}
	
	public String getHref()
	{
		return href;
	}

	public String getRel()
	{
		return rel;
	}
	
	public static link empty()
	{
		return new link();
	}

	public String getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}
	
	
}
