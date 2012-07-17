package membership;

import java.util.ArrayList;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("workspaces")
public class workspaces {
	@XStreamImplicit
	private ArrayList<workspace> workspace = new ArrayList<workspace>();

	public ArrayList<workspace> getWorkspace() {
		return workspace;
	}


}