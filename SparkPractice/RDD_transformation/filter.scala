import org.apache.spark.{SparkContext, SparkConf}

object filter {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setAppName("filter")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array(1, 2, 3, 4, 5))
    val result = arr.filter(_>3)
    result.foreach(print)
    //进行数据选择
  }
}
