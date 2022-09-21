package com.example.accessingdatamongodb;

import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

public class Exercise {

  @Id
  public String id;

  @NotNull
  @Size(min=1)
  public String name;

  @NotNull
  @Min(1)
  public int reps;

  @NotNull
  @Min(1)
  public int weight;

  @NotNull
  public String unit;

  @NotNull
  public String date;


  public Exercise() {}

  public Exercise(String name, int reps, int weight, String unit, String date) {
    this.name = name;
    this.reps = reps;
    this.weight = weight;
    this.unit = unit;
    this.date = date;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public int getReps() {
    return this.reps;
  }

  public void setReps(int reps) {
    this.reps = reps;
  }

  public int getWeight() {
    return this.weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getUnit() {
    return this.unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getDate() {
    return this.date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return String.format(
        "Exercise[id=%s, exercise name='%s', reps='%d', weight='%d', unit='%s', date='%s']",
        id, name, reps, weight, unit, date);
  }

}
