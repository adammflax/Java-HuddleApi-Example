package documents;

import java.util.ArrayList;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("documents")
public class documents {
	@XStreamImplicit
	private ArrayList<document> document = new ArrayList<document>();

	public ArrayList<document> getDocument() {
		return document;
	}

}
