//import org.apache.spark._
//import org.apache.spark.mllib.linalg.{Vector, Vectors}
//import org.apache.spark.mllib.linalg.distributed.RowMatrix
//
//object matrix_hang {
//  def main(args:Array[String]): Unit ={
//    val conf = new SparkConf()
//      .setMaster("local")
//      .setAppName("matrix_hang")
//    val sc = new SparkContext(conf)
//    val rdd = sc.textFile("")
//      .map(_.split(' '))
//      //.map(_.toDouble)
//      .map(line => Vectors.dense(line))
//    val rm = new RowMatrix(rdd)
//    println(rm.numCols())
//    println(rm.numRows())
//  }
//}
