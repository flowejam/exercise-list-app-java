package com.example.accessingdatamongodb;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExerciseRepository extends MongoRepository<Exercise, String> {

  public Optional<Exercise> findById(String id);
  public List<Exercise> findByDate(String date);

}
