# Scala & Spark
## Scala School of Twitter
learn Scala by reading Twitter's Scala School project(https://twitter.github.io/scala_school/zh_cn/index.html)
## Echarts Demo Project for Spark
- Hello Echarts
![Alt text](https://github.com/YHGui/scala/blob/f826a3d7f528b3b4a70792af5dc339ae74afe1a2/SparkWeb/images/echarts-demo.jpeg)	
## ImoocSparkSQL log analysis job
- The analysis and visualization of imooc.com log with the help of SparkSQL and visualization tools such as Zeppelin and ECharts.
- The architecture of offline data pipeline
![Alt text](https://github.com/YHGui/scala/blob/ae9b0c55cdb0b7bb3af5e56a70acb839a625b501/images/architecture.jpeg?raw=true)
- The issues are: 
  - Top N course and articles(Todo => visualization)
    - analyze the log for the Top N courses and articles, load data into mysql database
  - Top N course partioned by city with the help of IP
    - analyze the log for the Top N courses and articles with the information about city, load data into mysql database(deadlock in batching)
  - Top N couser according to traffic
    - analyze the log for the Top N courses and articles with the information about traffics, load data into mysql database
  - visualization with echarts
  ![Alt text](https://github.com/YHGui/scala/blob/46a6823e2051afd64f97c51f1ee70dad03325007/images/TopN-course.jpeg)
  - visualization with zeppelin
  ![Alt text](https://github.com/YHGui/scala/blob/927cafeb55662d0ba4df28aa6e8b7199764266bc/images/TopN-course-zeppelin.jpeg)
  - visualization with zeppelin in bar
  ![Alt text](https://github.com/YHGui/scala/blob/927cafeb55662d0ba4df28aa6e8b7199764266bc/images/TopN-course-zeppelin-bar.jpeg)
  - other topic visualizations are similar to them, they are ommited because of my little knowledge about front end, I cannot put them away elegantly.