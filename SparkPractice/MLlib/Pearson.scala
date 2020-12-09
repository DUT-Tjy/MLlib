import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.stat.Statistics

object Pearson {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("Pearson")
    val sc = new SparkContext(conf)
    val rddx = sc.textFile("../data/c.txt")
      .flatMap(_.split(' '))
      .map(_.toDouble)
    val rddy = sc.textFile("../data/d.txt")
      .flatMap(_.split(' '))
      .map(_.toDouble)
    val correction: Double = Statistics.corr(rddx, rddy)
    println(correction)
  }
}
//皮尔逊系数计算方式：协方差除标准差
