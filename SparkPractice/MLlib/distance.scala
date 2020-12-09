//import org.apache.spark.{SparkConf, SparkContext}
//import org.apache.spark.mllib.stat.Statistics
//import org.apache.spark.mllib.linalg.{Vector, Vectors}
//object distance {
//  def main(args:Array[String]): Unit ={
//    val conf = new SparkConf()
//      .setAppName("distance")
//      .setMaster("local")
//    val sc = new SparkContext(conf)
//    val rdd = sc.textFile("../data/c.text")
//      .map(_.split(' '))
//      .map(_.toDouble)
//      .map(line => Vectors.dense(line))
//    val summary = Statistics.colStats(rdd)
//    println(summary.normL1)
//    //计算曼哈顿距离
//    println(summary.normL2)
//    //计算欧几里德距离
//  }
//}