import org.apache.spark.{SparkContext, SparkConf}
object distinct {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("distinct")
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array(1, 2, 3, 4, 2, 1))
    val result = arr.distinct()
    result.foreach(print)
    //删除重复数字
  }
}
