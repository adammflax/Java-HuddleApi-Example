package membership;


import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("membership")
public class membership {
	@XStreamAlias("workspaces")
	private workspaces workspaces;
	
	public workspaces getWorkspaces() {
		return workspaces;
	}
}
