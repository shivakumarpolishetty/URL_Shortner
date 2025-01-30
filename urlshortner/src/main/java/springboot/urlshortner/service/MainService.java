package springboot.urlshortner.service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

import javax.management.loading.PrivateClassLoader;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.opsmatters.bitly.Bitly;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkResponse;

import jakarta.annotation.PostConstruct;
import springboot.urlshortner.Dao.DataRepository;
import springboot.urlshortner.model.DatabaseURL;
import springboot.urlshortner.model.URL;

@Service
public class MainService {
	
	//make sure to use the yours authorized token 
	//token:token[place in the application.properties]

	@Value("${token}")
	String token; 
	
	private Bitly client;
	
	@Autowired
	DataRepository dataRepository;
	
	@PostConstruct
	public void setup()
	{
		client = new Bitly(token);
	}
	
	public String thirdparyapi(String url)
	{
		
		  
		 String link = "error";
		 
		 
			
			  try { CreateBitlinkResponse response = client.bitlinks().shorten(url).get();
			  link = response.getLink();
			  
			  
			  } catch (Exception e) {
			  
			  return e.getMessage();
			  
			  }
			 
		 return link;
		
	}

	
	public String  databasebased(String  url) {
		
		
		  Optional<DatabaseURL> objofdb   = dataRepository.findById(url);
		 if(objofdb.isPresent())
		 {
			 return "https://www.google.com/search?"+objofdb.get().getShortid();
		 }
		 String shortCode = generateShortCode();
	     DatabaseURL objUrl = new DatabaseURL(url,shortCode);		
	    dataRepository.save(objUrl);
		
		return "succussfully uploaded url into the database try the same url again";
	       
	
	}
	
	
	
	private String generateShortCode() {
        // Generate Base62 or random 6-character code
        return RandomStringUtils.randomAlphanumeric(6);
    }

}


