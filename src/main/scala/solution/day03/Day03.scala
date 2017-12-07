package solution.day03

import solution._

object Day03 extends Day(3) {

  case class Coordinate(x: Int, y: Int) {
    def move(direction: Direction): Coordinate = direction match {
      case Up => Coordinate(x, y + 1)
      case Down => Coordinate(x, y - 1)
      case Left => Coordinate(x + 1, y)
      case Right => Coordinate(x - 1, y)
    }
  }
  object Coordinate {
    def start() = Coordinate(0,0)
  }

  sealed trait Direction
  case object Up extends Direction
  case object Down extends Direction
  case object Left extends Direction
  case object Right extends Direction
  object Direction {
    def apply(str: String): Option[Direction] = str match {
      case "^" => Some(Up)
      case "v" => Some(Down)
      case "<" => Some(Left)
      case ">" => Some(Right)
      case _ => None
    }
  }

  case class Grid(position: Coordinate, gifted: Map[Coordinate, Int]) {
    def move(d: Direction): Grid = {
      val nextPosition = position.move(d)
      val nextGifted = gifted.updated(nextPosition, gifted.getOrElse(nextPosition, 0) + 1)
      Grid(nextPosition, nextGifted)
    }
  }
  object Grid {
    def start() = {
      val startPos = Coordinate.start()
      Grid(startPos, Map(startPos -> 1))
    }
  }

  case class DoubleGrid(santa: Coordinate, robo: Coordinate, gifted: Map[Coordinate, Int]) {
    def move(moveSanta: Boolean, d: Direction): DoubleGrid = {
      val nextSanta = if (moveSanta) { santa.move(d) } else { santa }
      val nextRobo = if (!moveSanta) { robo.move(d) } else { robo }
      val newPosition = if (moveSanta) { nextSanta } else { nextRobo }
      val nextGifted = gifted.updated(newPosition, gifted.getOrElse(newPosition, 0) + 1)
      DoubleGrid(nextSanta, nextRobo, nextGifted)
    }
  }
  object DoubleGrid {
    def start: DoubleGrid = {
      val startPos = Coordinate.start()
      DoubleGrid(startPos, startPos, Map(startPos -> 1))
    }
  }

  /**
    * Problem A
    * @param input
    * @return
    */
  def problemA(input: String): Int = {
    val directions = input.split("").flatMap(Direction(_))
    val finalGrid = directions.foldLeft(Grid.start){(grid, direction) => grid.move(direction)}
    finalGrid.gifted.size
  }
  val solutionA = problemA(input)
  finalAnswer(solutionA.toString, A)

  /**
    * Problem B
    * @param input
    * @return
    */
  def problemB(input: String): Int = {
    val directions = input.split("").flatMap(Direction(_))
    val (finalGrid, _) = directions.foldLeft((DoubleGrid.start, true)){(acc, direction) =>
      val (grid, isSantasTurn) = acc
      val nextGrid = grid.move(isSantasTurn, direction)
      (nextGrid, !isSantasTurn)
    }
    finalGrid.gifted.size
  }

  val solutionB = problemB(input)
  finalAnswer(solutionB.toString, B)

}
