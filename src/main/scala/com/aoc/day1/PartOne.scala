package com.aoc.day1
import scala.io.Source
import scala.util.{Try, Using}

object PartOne extends App {

  val resourcePath = "src/main/resources/day1input.txt"

  for {
    data <- readData(resourcePath)
    count = countNumberOfIncreases(data)
  } yield println(count)

  def readData(path: String): Try[List[Int]] = {
    Using(Source.fromFile(path))(_.getLines().map(_.toInt).toList)
  }

  def findIncrease(previous: Int, current: Int): Int =
    if (current > previous) 1 else 0

  def countNumberOfIncreases(list: List[Int]): Int = {
    list
      .foldLeft(List.empty[(Int, Int)]) {
        case (l, elem) if l.isEmpty => List((elem, 0))
        case (l, elem) =>
          l ++ List((elem, findIncrease(l.last._1, elem)))
      }
      .map(_._2)
      .sum
  }
}
