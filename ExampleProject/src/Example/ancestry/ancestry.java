package ancestry;

import java.util.ArrayList;

import folder.*;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;


@XStreamAlias("ancestry")
public class ancestry {
	@XStreamImplicit
	private ArrayList<folder> folder = new ArrayList<folder>();

	public ArrayList<folder> getFolder() {
		return folder;
	}
}
