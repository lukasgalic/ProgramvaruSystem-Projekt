object Main:
  def main(args: Array[String]): Unit = 
    val fileName: String = args(0)
    val n: Int = args(1).toInt
    var fw: PrintWriter = new PrintWriter(fileName)
    fw.write("löpnummber, sorteringstid i ns")
    
    var i: Int = 0
    while (i < n)
      var t0: Long = System.nanoTime
      var Number: Int = fib(30)
      var t1: Long = System.nanoTime
      fw.write("\n" + (i+1) + "," + (t1-t0))
      i += 1
    fw.close()


  def fib(n: Int): Int = 
      if (n <= 1) 
        n
      else 
        fib(n - 1) + fib(n - 2)