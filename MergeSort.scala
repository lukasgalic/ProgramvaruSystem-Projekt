object Main {
    def main(args: Array[String]): Unit = {
	val source  = introprog.IO.loadLines(args(0),"UTF-8")
	var arr = Array[Int]();
	for(x <- 0 to source.size-1){
		arr = arr :+ source(x).toInt
	}
	var vec = Vector[String]();
	for(x <- 1 to args(2).toInt){
	var now = System.nanoTime
	sort(arr)
	var timeElapsed = System.nanoTime - now
	vec = vec :+ s"$x,$timeElapsed"
	}
	introprog.IO.saveLines(vec, args(1), "UTF-8")
}
        
}

def sort(array:Array[Int]):Unit = {
    if (array.length > 1 ){
      var firstArrayLength = (array.length/2)
      var first:Array[Int] = array.slice(0, firstArrayLength)
      var second:Array[Int] = array.slice(firstArrayLength, array.length)
      sort(first)
      sort(second)
      merge(array, first, second)
    }
  }

  def merge(result:Array[Int], first:Array[Int], second:Array[Int]):Unit = {
    var i:Int = 0
    var j:Int = 0
    for (k <- 0 until result.length) {
      if(i<first.length && j<second.length){
        if (first(i) < second(j)){
          result(k) = first(i)
          i=i+1
        } else {
          result(k) = second(j)
          j=j+1
        }
      }else if(i>=first.length && j<second.length){
        result(k) = second(j)
        j=j+1
      } else {
        result(k) = first(i)
        i=i+1
      }
    }
  }