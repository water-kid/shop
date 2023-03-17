const BASE_URL="http://localhost:8090"
module.exports = {
  transpileDependencies: true,
  // devServer:{
  //   host:"localhost",
  //   port:"8080",
  //   proxy:{
  //     "/api":{
  //       target:"http://localhost:8090",
  //       changeOrigin:true,
  //       ws:true,
  //       secure:false,
  //       pathRewrite:{
  //         "^/api":""
  //       }
  //     }
  //   }
  // },
  // BASE_URL,
  // server
  publicPath:'./',
  outputDir:"dist",
  assetsDir:"static"
}
