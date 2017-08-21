# Scala & Spark
## Scala School of Twitter
learn Scala by reading Twitter's Scala School project(https://twitter.github.io/scala_school/zh_cn/index.html)
## ImoocSparkSQL log analysis job
- The analysis and visualization of imooc.com log with the help of SparkSQL and visualization tools such as Zeppelin and ECharts.
- The architecture of offline data pipeline
![Alt text](https://github.com/YHGui/scala/blob/ae9b0c55cdb0b7bb3af5e56a70acb839a625b501/images/architecture.jpeg?raw=true)
- The issues are: 
  - Top N course and articles(Todo => visualization)
    - analyze the log for the Top N courses and articles, load data into mysql database
    - TODO: visualization
  - Top N course partioned by city with the help of IP
    - analyze the log for the Top N courses and articles with the information about city, load data into mysql database(deadlock in batching)
    - TODO: visualization
  - Top N couser according to traffic
    - analyze the log for the Top N courses and articles with the information about traffics, load data into mysql database
    - TODO: visualization