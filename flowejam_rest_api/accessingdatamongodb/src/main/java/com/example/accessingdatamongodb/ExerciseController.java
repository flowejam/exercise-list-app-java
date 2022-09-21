package com.example.accessingdatamongodb;

import javax.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ExerciseController {

  private final ExerciseRepository repository;

  ExerciseController(ExerciseRepository repository) {
    this.repository = repository;
  }


  @GetMapping("/exercises")
  List<Exercise> all() {
    return repository.findAll();
  }

  @PostMapping("/exercises")
  @ResponseStatus(value = HttpStatus.CREATED)
  Exercise newExercise(@RequestBody @Valid Exercise newExercise, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      throw new InvalidExerciseException();
    } else {
      return repository.save(newExercise);
    }
  }

  @GetMapping("/exercises/{id}")
  Exercise one(@PathVariable String id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new ExerciseNotFoundException(id));
  }

  @PutMapping("/exercises/{id}")
  Exercise replaceExercise(@RequestBody @Valid Exercise newExercise, BindingResult bindingResult, @PathVariable String id) {

    if (bindingResult.hasErrors()) {
      throw new InvalidExerciseException();
    } else {
      return repository.findById(id)
        .map(exercise -> {
          exercise.setName(newExercise.getName());
          exercise.setReps(newExercise.getReps());
          exercise.setWeight(newExercise.getWeight());
          exercise.setUnit(newExercise.getUnit());
          exercise.setDate(newExercise.getDate());
          return repository.save(exercise);
        })
        .orElseThrow(() -> new ExerciseNotFoundException(id));
    }
  }

  @DeleteMapping("/exercises/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  void delete(@PathVariable String id) {
    repository.deleteById(id);
  }

}
