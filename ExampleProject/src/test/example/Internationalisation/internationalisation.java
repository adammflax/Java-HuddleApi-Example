package Internationalisation;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("internationalisation")
public class internationalisation {
	@XStreamAlias("timezone")
	private String timezone = "";
	@XStreamAlias("utcOffset")
	private int utcOffset = 0;
	
	public String getTimezone() {
		return timezone;
	}

	public int getUtcOffset() {
		return utcOffset;
	}
	
}
