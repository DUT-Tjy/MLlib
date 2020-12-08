import org.apache.spark.mllib.linalg.{Matrix, Matrices}

object local_matrix {
  def main(args:Array[String]){
    val mx = Matrices.dense(2, 3, Array(1, 2, 3, 4, 5, 6))
    println(mx)
  }
}
