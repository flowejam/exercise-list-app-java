package com.example.accessingdatamongodb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;                  
                                                                                
@ControllerAdvice                                                               
class ExerciseNotFoundAdvice {                                                  
                                                                                
  @ResponseBody                                                                 
  @ExceptionHandler(InvalidExerciseException.class)                            
  @ResponseStatus(HttpStatus.BAD_REQUEST)                                         
  String exerciseNotFoundHandler(InvalidExerciseException ex) {                
    return ex.getMessage();                                                     
  }                                                                             
}        
