package link;

import java.util.ArrayList;

public class sortLinks {
	private ArrayList<link> links = new ArrayList<link>();
	
	public sortLinks(ArrayList<link> links)
	{
		this.links = links;
	}
	
	public link getLinkWithHref(String href)
	{
		for(int i = 0; i < links.size(); i++)
		{
			if(links.get(i).getHref().equals(href))
			{
				return links.get(i);
			}
		}
		return link.empty();
	}
	
	public link getLinkWithRel(String Rel)
	{
		for(int i = 0; i < links.size(); i++)
		{
			if(links.get(i).getRel().equals(Rel))
			{
				return links.get(i);
			}
		}
		return link.empty();
	}

}
