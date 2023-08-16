val lowerCaseLetters = ('a' to 'z').toList
val upperCaseLetters = lowerCaseLetters.map(l => l.toUpper)

class CompartmentItem(val letter: Char):
  val priority: Int =
    if (letter.isUpper) upperCaseLetters.indexOf(letter) + 27
    else lowerCaseLetters.indexOf(letter) + 1

def calculatePriority(line: String): Int =
  val firstCompartment = line.take(line.length / 2)
  val secondCompartment = line.takeRight(line.length / 2)
  val misplaced = firstCompartment.intersect(secondCompartment).head

  CompartmentItem(misplaced).priority

@main def dayThree: Unit =
  val path: os.Path = os.pwd / "src" / "main" / "resources" / "day-three.txt"
  val content: Seq[String] = os.read.lines(path)
  val sumOfPriorities = content.map((line) => calculatePriority(line)).reduce(_ + _)

  println(sumOfPriorities)