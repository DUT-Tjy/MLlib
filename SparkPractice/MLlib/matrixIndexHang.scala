//import org.apache.spark._
//import org.apache.spark.mllib.linalg.distributed.{IndexedRow, RowMatrix, IndexedRowMatrix}
//import org.apache.spark.mllib.linalg.{Vector, Vectors}
//object matrixIndexHang {
//def main(args:Array[String]): Unit ={
//  val conf = new SparkConf()
//    .setMaster("local")
//    .setAppName("matrixIndexHang")
//  val sc = new SparkContext(conf)
//  val rdd = sc.textFile("")
//    .map(_.split(" "))
//    .map(_.toDouble)
//    .map(line => Vectors.dense(line))
//    .map((vd) => new IndexedRow(vd.size, vd))
//  val irm = new IndexedRowMatrix(rdd)
//  println(irm.getClass())
//  println(irm.rows.foreach(println))
//}
//}
