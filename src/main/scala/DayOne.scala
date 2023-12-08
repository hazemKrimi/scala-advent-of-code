package advent_of_code

import os.*

def getTotalCaloriesByElveSorted: Seq[Int] =
  val path: os.Path = os.pwd / "src" / "main" / "resources" / "day-one.txt"
  val content: String = os.read(path)
  val elvesCalories: Seq[String] = content.split("\\n\\s")

  val totalCaloriesForByElve: Seq[Int] = elvesCalories.map((elveCalories: String) =>
    elveCalories.split("\\s").map(calorie => calorie.toInt).sum
  ).sorted.reverse

  totalCaloriesForByElve

def dayOne: Unit =
  println(getTotalCaloriesByElveSorted.take(3).sum)
