package springboot.urlshortner.model;

import lombok.Data;


public class URL {
	
	private String  longURL;
	
	public URL()
	{
		
	}
	public URL(String url)
	{
		this.longURL=url;
	}

	public String getLongURL() {
		return longURL;
	}

	public void setLongURL(String longURL) {
		this.longURL = longURL;
	}
	
	
	
	

	

}
