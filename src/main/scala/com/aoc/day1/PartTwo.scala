package com.aoc.day1

object PartTwo extends App {
  val resourcePath = "src/main/resources/day1input.txt"

  for {
    data <- PartOne.readData(resourcePath)
    count = computeNumberOfIncreases(data)
  } yield println(count)

  def computeNumberOfIncreases(list: List[Int]): Int = {
    val updatedList = list
      .sliding(3)
      .map(_.sum)
      .toList

    PartOne.countNumberOfIncreases(updatedList)
  }
}
