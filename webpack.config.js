const path = require('path')
const HtmlWebpackPlugin = require('html-webpack-plugin')
const {CleanWebpackPlugin} = require('clean-webpack-plugin')

module.exports = {
    mode: 'development',
    entry: {
        main: path.resolve(__dirname, 'src/main/resources/src/index.js')
    },
    output: {
        filename: '[name].[contenthash].js',
        path: path.resolve(__dirname, 'src/main/resources/static')
    },
    plugins: [
        new HtmlWebpackPlugin({
            inject: 'body',
            template: path.resolve(__dirname, 'src/main/resources/src/index.html'),
            filename: path.resolve(__dirname, 'src/main/resources/templates/index.html'),
            publicPath: 'auto'    //  './' build config path
        }),
        new CleanWebpackPlugin()
    ]
}