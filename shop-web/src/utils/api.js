
import axios from "axios";

import {Message} from "element-ui";

axios.interceptors.response.use(function ({data}) {
        console.log(data)
    if (data.code===500){
        // 业务错误
        if (data.msg){
            Message.error(data.msg)
        }else{
            Message.error("业务错误")
        }
        return
    }
    if (data.msg){
        Message.success(data.msg)
    }
    return data;
},function (error) {
    Message.error("服务器错误");
    return;
})


// let prefixUrl ="/api"
let prefixUrl =""

export const postRequest=(url,params,header)=>{
    return axios({
        method:"post",
        url:`${prefixUrl}${url}`,
        data:params,
        header:header
    })
}


export const putRequest=(url,params)=>{
    return axios({
        method:"put",
        url:`${prefixUrl}${url}`,
        data:params
    })
}
export const deleteRequest=(url)=>{
    return axios({
        method:"delete",
        url:`${prefixUrl}${url}`
    })
}



export const getRequest=(url)=>{
    return axios({
        method:"get",
        url:`${prefixUrl}${url}`
    })
}
