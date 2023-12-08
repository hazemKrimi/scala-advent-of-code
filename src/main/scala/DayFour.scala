package advent_of_code

def getPairRanges(line: String) =
  val pair = line.split(",")
  val firstElfSection = pair.head.split("-")
  val secondElfSection = pair.last.split("-")
  val firstRange = (firstElfSection.head.toInt to firstElfSection.last.toInt).toList
  val secondRange = (secondElfSection.head.toInt to secondElfSection.last.toInt).toList

  (firstRange, secondRange)

def dayFour: Unit =
  val path: os.Path = os.pwd / "src" / "main" / "resources" / "day-four.txt"
  val content: Seq[String] = os.read.lines(path)
  val sumOfContainedRanges = content.map(getPairRanges).count((firstRange, secondRange) => {
    firstRange.sliding(secondRange.length).contains(secondRange) ||
      secondRange.sliding(firstRange.length).contains(firstRange)
  })
  val sumOfOverlappingRanges = content.map(getPairRanges).count((firstRange, secondRange) => {
    firstRange.intersect(secondRange).nonEmpty
  })

  println(sumOfContainedRanges)
  println(sumOfOverlappingRanges)