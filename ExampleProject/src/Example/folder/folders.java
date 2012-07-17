package folder;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("folders")
public class folders {
	@XStreamImplicit
	private ArrayList<folder> folder= new ArrayList<folder>();

	public ArrayList<folder> getFolder() {
		return folder;
	}
}
