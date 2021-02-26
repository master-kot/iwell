const path = require('path')
const HtmlWebpackPlugin = require('html-webpack-plugin')
const {CleanWebpackPlugin} = require('clean-webpack-plugin')
const CopyWebpackPlugin = require('copy-webpack-plugin')

module.exports = {
    context: path.resolve(__dirname, 'src/main/resources/src'),
    mode: 'development',
    entry: {
        main: './index.js'
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
            publicPath: 'auto'
            //TODO  './' build config path
        }),
        new CleanWebpackPlugin(),
        new CopyWebpackPlugin({
            patterns: [
                {
                    from: path.resolve(__dirname, 'src/main/resources/src/img'),
                    to: path.resolve(__dirname, 'src/main/resources/templates/img')
                    // TODO replace path for build
                }
            ]
        })
    ],
    module: {
        rules: [
            {
                test: /\.s[ac]ss$/,
                use: ['style-loader', 'css-loader', 'sass-loader']
            },
            // {
            //     test: /\.(png|jpg|svg|gif)$/,
            //     loader: 'file-loader',
            //     options: {
            //         publicPath: 'src/main/resources/src/img',
            //         outputPath: 'src/main/resources/static/img'
            //     }
            // }
        ]
    }
}