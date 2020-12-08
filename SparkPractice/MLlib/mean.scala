import org.apache.spark.{SparkConf, SparkContext}
object mean {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("../data/c.text")
    val summary = Statistics.colStats(rdd)
    println(summary.mean)
    println(summary.varience)
  }
}