package com.aoc.day2
import scala.io.Source
import scala.util.{Try, Using}

object PartTwo extends App {
  val resourcePath = "src/main/resources/day2input.txt"

  for {
    data <- readData(resourcePath)
    horizontal <- computeHorizontalPosition(data)
    (_, depth) <- computeAim(data)
  } yield (println(depth * horizontal))

  def readData(path: String): Try[List[InputData]] = {
    Using(Source.fromFile(path)) {
      _.getLines().toList.map { line =>
        val l = line.split(" ").toList
        l match {
          case Nil => ???
          case List(command, amount) =>
            InputData(command, amount.toInt) // TODO can throw
          case ::(head, next) => ???
        }
      }
    }
  }

  def computeHorizontalPosition(l: List[InputData]): Try[Int] = Try {
    l.collect {
      case c if c.command == "forward" => c.amount
    }.sum
  }

  def computeAim(l: List[InputData]) = Try {
    l.foldLeft((0, 0)) {
      case ((aim, depth), c) if c.command == "forward" =>
        (aim, depth + (aim * c.amount))
      case ((aim, depth), c) if c.command == "up"   => (-c.amount + aim, depth)
      case ((aim, depth), c) if c.command == "down" => (c.amount + aim, depth)
    }
  }

  final case class InputData(command: String, amount: Int)
}
