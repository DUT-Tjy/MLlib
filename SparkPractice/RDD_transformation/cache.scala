import org.apache.spark.{SparkContext, SparkConf}
object cache {
  def mian(args: Array[String]): Unit ={
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("cache")
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array("abc", "b", "c"), 2)
    println(arr)
    println("------")
    println(arr.cache())
    //分别打印RDD存储结果以及真实结果
  }
}
