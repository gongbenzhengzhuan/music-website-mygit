#!/bin/sh

echo "上传zip文件"
scp -r dist.zip root@101.37.117.226:/home/front/vue-project/file

sleep 3s
echo "执行启动脚本"
ssh  root@101.37.117.226 "cd /home/front/vue-project/file; sh start_zb.sh;"

