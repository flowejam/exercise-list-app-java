package com.example.accessingdatamongodb;
import org.slf4j.Logger;                                                        
import org.slf4j.LoggerFactory;                                                 
import org.springframework.boot.CommandLineRunner;                              
import org.springframework.context.annotation.Bean;                             
import org.springframework.context.annotation.Configuration;   

@Configuration                                                                  
class LoadDatabase {                                                            
                                                                                
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
                                                                                
  @Bean                                                                         
  CommandLineRunner initDatabase(ExerciseRepository repository) {               
                                                                                
    return args -> {                                                            
    repository.deleteAll();
    // save a few exercises to display
    log.info("Preloading " + repository.save(new Exercise("push up", 100, 180, "lbs", "01-01-22")));
    log.info("Preloading " + repository.save(new Exercise("bicep curls", 20, 60, "lbs", "01-01-22")));
    log.info("Preloading " + repository.save(new Exercise("sit up", 15, 180, "lbs", "01-02-22")));
    };                                                                          
  }                                                                             
}      
