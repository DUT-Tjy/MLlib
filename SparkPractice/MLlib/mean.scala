//import org.apache.spark.mllib.stat.Statistics
//import org.apache.spark.{SparkConf, SparkContext}
//object mean {
//  def main(args:Array[String]){
//    val conf = new SparkConf()
//    val sc = new SparkContext(conf)
//    val rdd = sc.textFile("../data/c.text")
//      .map(_.split(' '))
//      .map(_.toDouble)
//    val summary = Statistics.colStats(rdd)
//    println(summary.mean)
//    println(summary.varience)
//  }
//}
