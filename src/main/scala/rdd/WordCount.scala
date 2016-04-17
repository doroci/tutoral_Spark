package rdd

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object WordCount{
  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir", "c:\\winutil\\")

    val logFile = "C:\\spark-1.3.1-bin-hadoop2.4\\README.md" // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
  }
}
