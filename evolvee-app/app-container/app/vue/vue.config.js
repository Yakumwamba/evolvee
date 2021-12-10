const NodePolyfillPlugin = require('node-polyfill-webpack-plugin')
const path = require('path')

module.exports = {
  transpileDependencies: true,
  configureWebpack: {
    entry: "./src/evolvee_client/src/ui/EvolveeUI.tsx",
    module: {
      rules: [
        {
          test: /\.tsx?$/,
          use: 'babel-loader',
          exclude: /node_modules/,
        },
      ]
    },
    resolve: {
      symlinks: false,
      alias: {
        vue$: path.resolve("./node_modules/vue/dist/vue.esm-bundler.js"),
      },
      extensions: [".ts",".tsx", ".js", ".json"],
    },
    plugins: [new NodePolyfillPlugin()],
    output: {
      filename: "[name].js",
      chunkFilename: "[id].[chunkhash].js",
      path: path.resolve(__dirname, "dist"),
    },
  },
};
