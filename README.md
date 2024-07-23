<div align="center">
	<img src="https://gitee.com/zj-prism/data-pulse/raw/v1.0-master/src/main/resources/imgs/%E4%B8%BBLOGO.png" width="30%">
</div>

<p align="center">
	<strong>轻量级binlog同步平台</strong>
</p>
<p align="center">
    <a href='https://gitee.com/zj-prism/data-pulse'>
        <img src='https://gitee.com/zj-prism/data-pulse/widgets/widget_5.svg' width="19px" alt='Fork me on Gitee'/>
    </a>
	<a target="_blank" href="https://license.coscl.org.cn/MulanPSL2">
		<img src="https://img.shields.io/:license-MulanPSL2-blue.svg" />
	</a>
	</a>
    <a target="_blank" href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html">
		<img src="https://img.shields.io/badge/JDK-17-green.svg" alt="jdk-17" />
	</a>
    <a href='https://gitee.com/zj-prism/data-pulse/stargazers'>
        <img src='https://gitee.com/zj-prism/data-pulse/badge/star.svg?theme=dark' alt='star'/>
    </a>
</p>




### 📚简介
`data-pulse` 是一个轻量级的数据同步平台，提供了开箱即用的数据同步服务，基于`binlog4j`开源组件+国产纯血轻量级java框架 `solon`开发，旨在以最小的资源开销，完成数据同步任务。
    
### 🍬特点
1. 轻量：基于`binlog4j`开源组件+国产纯血轻量级java框架 `solon`开发，资源开销较小。
2. 高可用：支持集群模式，断点续传。
2. 简单：配置简单，无需编写代码，即可完成数据同步任务。
3. 易扩展： 支持多种数据源，如mysql、oracle、sqlserver、postgresql等，用户只需要编写对应的目标库的方言即可实现数据同步。

### 🕒版本

| 版本 | 描述 |
| :----: | :----: |
|v1.0-beta|初始版本(开发中)|
### 🚀开发计划
1. 2024.7月-9月 v1.0.0 mysql-->es   mysql-->mysql    mysql-->clickhouse
    搭建基本框架，binlog数据订阅并同步，全量数据同步
2. 2024.9月-12月 v1.5
    开始规划用户管理界面，实现用户管理功能，用户可以自定义同步任务，并管理任务状态，任务日志，任务配置等。
3. 2025.1月--*
    持续迭代，持续优化，持续完善，持续更新。
### 🔨规划思维导图
<div align="center">
    <img src="https://gitee.com/zj-prism/data-pulse/blob/v1.0-master/src/main/resources/imgs/%E9%A1%B9%E7%9B%AE%E8%A7%84%E5%88%92.png">
</div>
### 👥联系我们
QQ群：`621215734`
