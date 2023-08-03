type MyMove = "X" | "Y" | "Z"
type OpponentMove = "A" | "B" | "C"

def calculateMoveScore(opponentMove: OpponentMove, myMove: MyMove): Int =
  (opponentMove, myMove) match
    case ("A", "X") => 3
    case ("A", "Y") => 4
    case ("A", "Z") => 8
    case ("B", "X") => 1
    case ("B", "Y") => 5
    case ("B", "Z") => 9
    case ("C", "X") => 2
    case ("C", "Y") => 6
    case ("C", "Z") => 7

@main def dayTwo: Unit =
  val path: os.Path = os.pwd / "src" / "main" / "resources" / "day-two.txt"
  val content: Seq[String] = os.read.lines(path)
  val myTotalScore: Int = content
    .map(round => {
      val Array(opponentRoundMove: OpponentMove, myRoundMove: MyMove) = round.split("\\s")

      calculateMoveScore(opponentRoundMove, myRoundMove)
    })
    .reduce(_ + _)

  println(myTotalScore)