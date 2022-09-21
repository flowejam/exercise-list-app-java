package com.example.accessingdatamongodb;
import org.slf4j.Logger;                                                        
import org.slf4j.LoggerFactory;                                                 

class ExerciseNotFoundException extends RuntimeException{
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    ExerciseNotFoundException(String id) {
        super("Could not find details for exercise with id " + id);
        log.info("Could not find details for this exercise.");
    }
    
}
