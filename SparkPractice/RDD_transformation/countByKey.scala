import org.apache.spark.{SparkContext, SparkConf}
object countByKey {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setAppName("countByKey")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array((1, "col"), (2, "d"), (2, "c")))
    val result = arr.countByKey()
    result.foreach(print)
    //计算Array中key的个数
  }
}
