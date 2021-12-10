module.exports = {
  presets: ["@vue/cli-plugin-babel/preset", "@babel/preset-typescript"],
  plugins: ["@babel/plugin-transform-runtime"],
  overrides: [
    {
      test: [/\.jsx?$/, /\.tsx?$/],
      presets: ["@babel/preset-react", "@babel/preset-typescript"],
      plugins: ["@babel/plugin-transform-react-jsx"],
    },
  ],
};
