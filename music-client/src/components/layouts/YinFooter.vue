<template>
  <div class="yin-footer">
    <p v-for="(item, index) in footerList" :key="index">
      {{ item }}
    </p>
    <img src="http://101.37.117.226:9090/wdhcr/%E5%B0%8F%E6%B3%A5%E9%B3%85%E6%B8%B8%E6%88%8F?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=7v3qUvGaLweXRbw4%2F20230605%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230605T003217Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=95f72e6bd100ee909f7050a95af0129d203c467611d9c0ea3dd1e0fc3ad5e799" width="60" height="60">
    <el-image class="song-pic" fit="contain" :src="attachImageUrl(songPic)" />
  </div>
</template>

<script lang="ts">
import { defineComponent, readonly } from "vue";
import { HttpManager } from "@/api";
export default defineComponent({
  setup() {
    const songPic = "http://101.37.117.226:9090/wdhcr/%E5%BC%A0%E6%85%A7%E5%A6%B9Thu%20Jun%2001%202023%2015%3A29%3A54%20GMT%2B0800%20%28%E4%B8%AD%E5%9B%BD%E6%A0%87%E5%87%86%E6%97%B6%E9%97%B4%29?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=7v3qUvGaLweXRbw4%2F20230601%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230601T072954Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=b287fe62e51ef9739a9910724f223aae86bae72395d76209923a6b9e959aaf95";

    const footerList = readonly([
      "关于 | 帮助 | 条款 | 反馈",
      "Copyright © 2023 dzl",
      "京ICP备2023013015号 | https://beian.miit.gov.cn",
    ]);

    return { footerList,      attachImageUrl: HttpManager.attachImageUrlSingle,
      songPic, };
  },
});
</script>

<style lang="scss" scoped>
@import "@/assets/css/var.scss";
@import "@/assets/css/global.scss";

.yin-footer {
  width: 100%;
  height: $footer-height;
  padding: 20px 0;
  box-sizing: border-box;
  font-size: 14px;
  @include layout(center, center, column);
}

p {
  height: 30px;
}
</style>
