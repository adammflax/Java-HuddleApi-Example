package user;

import java.util.ArrayList;

import profile.profile;

import link.link;
import membership.membership;



import Internationalisation.internationalisation;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;


@XStreamAlias("user")
public class user {
	@XStreamAlias("xmlns")
	private String xmlns = "";
	@XStreamImplicit
	private ArrayList<link> link = new ArrayList<link>();
	@XStreamAlias("membership")
	private membership membership;
	@XStreamAlias("profile")
	private profile profile;
	@XStreamAlias("internationalisation")
	private internationalisation internationalisation;

	public String getXmlns() {
		return xmlns;
	}

	public ArrayList<link> getLink() {
		return link;
	}

	public membership getMembership() {
		return membership;
	}

	public profile getProfile() {
		return profile;
	}

	public internationalisation getInternationalisation() {
		return internationalisation;
	}
}
