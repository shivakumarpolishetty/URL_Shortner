package springboot.urlshortner.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.urlshortner.model.DatabaseURL;
import springboot.urlshortner.model.URL;

public interface DataRepository extends JpaRepository<DatabaseURL, String> {

	
	
	
}
