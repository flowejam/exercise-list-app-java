package com.example.accessingdatamongodb;

import org.slf4j.Logger;                                                        
import org.slf4j.LoggerFactory;                                                 

class InvalidExerciseException extends RuntimeException{
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    InvalidExerciseException() {
        log.info("InvalidExerciseException raised");
    }
    
}
