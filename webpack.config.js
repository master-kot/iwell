const path = require('path')
const HtmlWebpackPlugin = require('html-webpack-plugin')
const {CleanWebpackPlugin} = require('clean-webpack-plugin')
const CopyWebpackPlugin = require('copy-webpack-plugin')
const MiniCssExtractPlugin = require('mini-css-extract-plugin')
const TerserWebpackPlugin = require('terser-webpack-plugin')
//TODO OptimizeCssAssetsWebpackPlugin
const OptimizeCssAssetsWebpackPlugin = require('optimize-css-assets-webpack-plugin')

const isDev = process.env.NODE_ENV === 'development'
const isProd = !isDev
const filename = ext => isDev ? `[name].${ext}` : `[name].[hash].${ext}`
const imgDir = isDev
    ? path.resolve(__dirname, 'src/main/resources/templates/img')
    : path.resolve(__dirname, 'src/main/resources/static/img')
const scriptPath = isDev
    ? 'auto'
    : './'

const optimization = () => {
    const config = {
        // удаление дублтрованного кода
        splitChunks: {
            chunks: 'all'
        }
    }

    if (isProd) {
        config.minimizer = [
            // сжатие стилей
            new OptimizeCssAssetsWebpackPlugin(),
            // сжатие скриптов
            new TerserWebpackPlugin()
        ]
    }

    return config
}

const cssLoaders = extra => {
    const loaders = [
        MiniCssExtractPlugin.loader,
        'css-loader'
    ]

    if (extra) {
        loaders.push(extra)
    }

    return loaders
}

const babelOptions = preset => {
    const opts = {
        presets: [
            '@babel/preset-env'
        ],
        plugins: [
            '@babel/plugin-proposal-class-properties'
        ]
    }

    if (preset) {
        opts.presets.push(preset)
    }

    return opts
}

module.exports = {
    //корневая директория
    context: path.resolve(__dirname, 'src/main/resources/src'),
    mode: 'development',
    //точка входа
    entry: {
        main: [
            '@babel/polyfill',
            './index.js'
        ]
    },
    //директория для скомпилированных файлов
    output: {
        filename: filename('js'),
        path: path.resolve(__dirname, 'src/main/resources/static')
    },
    //расширения файлов по-умолчанию
    resolve: {
        extensions: ['.js'],
        alias: {
            '@': path.resolve(__dirname, 'src/main/resources/src')
        }
    },
    optimization: optimization(),
    devServer: {
        port: 4200,
        hot: isDev
    },
    // devtool: isDev ? 'source-map' : '',
    plugins: [
        new HtmlWebpackPlugin({
            //место включения скриптов
            inject: 'body',
            //шаблон исходного индекса
            template: path.resolve(__dirname, 'src/main/resources/src/index.html'),
            //директория для скомпилированного индекса
            filename: path.resolve(__dirname, 'src/main/resources/templates/index.html'),
            //директория подключения скриптов
            publicPath: scriptPath,
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
                    to: imgDir
                }
            ]
        }),
        new MiniCssExtractPlugin({
            filename: filename('css')
        })
    ],
    module: {
        rules: [
            {
                test: /\.css$/,
                use: cssLoaders()
            },
            {
                test: /\.s[ac]ss$/,
                use: cssLoaders('sass-loader')
            },
            {
                test: /\.m?js$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                    options: babelOptions()
                }
            },
            {
                test: /\.jsx$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                    options: babelOptions('@babel/preset-react')
                }
            }
            // {
            //     test: /\.s[ac]ss$/,
            //     use: [
            //         {
            //             loader: MiniCssExtractPlugin.loader,
            //             options: {
            //                 // hmr: isDev,
            //                 // reloadAll: true
            //             },
            //         },
            //         // 'style-loader',
            //         'css-loader',
            //         {
            //             loader: "sass-loader",
            //             // options: {
            //             //     implementation: require("node-sass"),
            //             // },
            //         }
            //         ]
            // },
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