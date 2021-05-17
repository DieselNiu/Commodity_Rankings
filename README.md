 How to build

clone 项目至本地目录：

```shell
git clone git@github.com:DieselNiu/Commodity_Rankings.git
```

从 Docker 启动 MySQL 数据库：

* [Docker 下载地址](https://www.docker.com/)
* 如果需要持久化数据需要配置 -v 磁盘文件映射

```shell
docker run --name rankings -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 MYSQL_DATABASE=mall -d mysql:8.0
```

使用 IDEA 打开项目，刷新 Maven，再使用开源数据库迁移工具 Flyway 完成自动建表工作：

```shell
mvn flyway:migrate
```

项目测试：

```shell
mvn clean verify
```

运行项目：

* Run Application 类

* 访问 [localhost:8080//rank.htm](localhost:8080//rank.htm) 就可以可以运行了


运行结果如下图：

[![gWeouT.png](https://z3.ax1x.com/2021/05/17/gWeouT.png)](https://imgtu.com/i/gWeouT)


