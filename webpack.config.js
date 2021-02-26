const path = require('path')
const HtmlWebpackPlugin = require('html-webpack-plugin')
const {CleanWebpackPlugin} = require('clean-webpack-plugin')
const CopyWebpackPlugin = require('copy-webpack-plugin')
const MiniCssExtractPlugin = require('mini-css-extract-plugin')
const TerserWebpackPlugin = require('terser-webpack-plugin')
// Optimize CSS Assets Webpack Plugin

const isDev = process.env.NODE_ENV === 'development'
const isProd = !isDev

module.exports = {
    //корневая директория
    context: path.resolve(__dirname, 'src/main/resources/src'),
    mode: 'development',
    //точка входа
    entry: {
        main: './index.js'
    },
    //директория для скомпилированных файлов
    output: {
        filename: '[name].[contenthash].js',
        path: path.resolve(__dirname, 'src/main/resources/static')
    },
    //расширения файлов по-умолчанию
    resolve: {
        extensions: ['.js'],
        alias: {
            '@': path.resolve(__dirname, 'src/main/resources/src')
        }
    },
    optimization: {
        //удаление дублирования кода скриптов
        splitChunks: {
            chunks: 'all'
        }
    },
    devServer: {
        port: 4200,
        hot: isDev
    },
    plugins: [
        new HtmlWebpackPlugin({
            //место включения скриптов
            inject: 'body',
            //шаблон исходного индекса
            template: path.resolve(__dirname, 'src/main/resources/src/index.html'),
            //директория для скомпилированного индекса
            filename: path.resolve(__dirname, 'src/main/resources/templates/index.html'),
            //директория подключения скриптов
            //TODO  './' build config path
            publicPath: 'auto',
            minify: {
                collapseWhitespace: isProd
            }
        }),
        //очистка старых версий файлов
        new CleanWebpackPlugin(),
        //копирование файлов
        new CopyWebpackPlugin({
            patterns: [
                {
                    from: path.resolve(__dirname, 'src/main/resources/src/img'),
                    //TODO replace path for build
                    to: path.resolve(__dirname, 'src/main/resources/templates/img')
                }
            ]
        }),
        new MiniCssExtractPlugin({
            //возможно здесь sass
            filename: '[name].[contenthash].css'
        })
    ],
    module: {
        rules: [
            {
                test: /\.s[ac]ss$/,
                use: [
                    {
                        loader: MiniCssExtractPlugin.loader,
                        options: {
                            hmr: isDev,
                            reloadAll: true
                        },
                    },
                    'css-loader',
                    'sass-loader']
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