const { defineConfig } = require('@vue/cli-service')

module.exports = defineConfig({
  publicPath: process.env.NODE_ENV === 'production' ? './' : '/',
  outputDir: 'dist',
  indexPath: 'index.html',
  lintOnSave: false,
  transpileDependencies: true,
  devServer:{
    port: 9003,
    open: true
  },
  chainWebpack: config => {
    config.plugin('define').tap(definitions => {
      Object.assign(definitions[0]['process.env'], {
        //NODE_HOST: '"http://localhost:8888"',
        NODE_HOST: '"http://82.156.135.173:9001"',
      });
      return definitions;
    });
  }
})
