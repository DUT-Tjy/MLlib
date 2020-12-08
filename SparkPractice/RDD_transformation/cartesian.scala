import org.apache.spark.{SparkContext, SparkConf}

object cartesian {
  def mian(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setAppName("cartesian")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array(1, 2, 3, 4, 5, 6))
    val arr2 = sc.parallelize(Array(6, 5, 4, 3, 2, 1))
    val result = arr.cartesian(arr2)
    result.foreach(print)
    //循环打印笛卡尔积结果
  }
}
