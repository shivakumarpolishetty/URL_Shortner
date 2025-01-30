package springboot.urlshortner.model;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DatabaseURL {
	
	
	
	@Id
	private String longUrl;
	private String shortid;
	
	public DatabaseURL()
	{
		
	}
	public DatabaseURL(String longUrl, String shortid)
	{
		this.longUrl =longUrl;
		this.shortid=shortid;
	}
	
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	public String getShortid() {
		return shortid;
	}
	public void setShortid(String shortid) {
		this.shortid = shortid;
	}
	

   
}
