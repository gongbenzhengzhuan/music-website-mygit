#!/bin/sh

source ~/.bash_profile

# 本地项目打包
mvn clean package -Dmaven.test.skip=true
sleep 2s

echo "上传jar文件"
scp -r target/yin-0.0.1-SNAPSHOT.jar root@101.37.117.226:/home/front/music/server

sleep 3s
echo "执行启动脚本"
ssh  root@101.37.117.226 "cd /home/front/music/server; nohup java -jar yin-0.0.1-SNAPSHOT.jar &"


