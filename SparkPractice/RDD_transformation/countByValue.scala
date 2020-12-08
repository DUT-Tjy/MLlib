import org.apache.spark.{SparkContext, SparkConf}
object countByValue {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setAppName("countBValue")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array(1, 2, 3, 4, 5, 6))
    val result = arr.countByValue()
    result.foreach(print)
    //计算Array中出现元素的个数
  }
}
