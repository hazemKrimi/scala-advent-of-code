import scala.compiletime.ops.string.CharAt

val lowerCaseLetters = ('a' to 'z').toList
val upperCaseLetters = lowerCaseLetters.map(l => l.toUpper)

class CompartmentItem(val letter: Char):
  val priority: Int =
    if (letter.isUpper) upperCaseLetters.indexOf(letter) + 27
    else lowerCaseLetters.indexOf(letter) + 1

def calculatePriorityOfChar(c: Char): Int = CompartmentItem(c).priority

def calculatePriorityOfLine(line: String): Int =
  val firstCompartment = line.take(line.length / 2)
  val secondCompartment = line.takeRight(line.length / 2)
  val misplaced = firstCompartment.intersect(secondCompartment).head

  calculatePriorityOfChar(misplaced)

def calculatePriorityOfGroup(group: Seq[String]): Int = calculatePriorityOfChar(group.map(_.toSet).reduce(_ intersect _).head)

@main def dayThree: Unit =
  val path: os.Path = os.pwd / "src" / "main" / "resources" / "day-three.txt"
  val content: Seq[String] = os.read.lines(path)
  val sumOfPriorities = content.map((line) => calculatePriorityOfLine(line)).reduce(_ + _)
  val sumOfGroupPriorities = content.sliding(3, 3).map(calculatePriorityOfGroup).reduce(_ + _)

  println(sumOfPriorities)
  println(sumOfGroupPriorities)