module.exports={
    devServer: {

        proxy: {'/books': {
                target: 'http://localhost:8081',
                changeOrigin: true,
                pathRewrite: {
                    '^/books': '/books'
                }
            }

}
    }
}