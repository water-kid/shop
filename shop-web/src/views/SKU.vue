<template>
<div>
    <div>
        <el-button @click="handleInsert">添加商品</el-button>
    </div>
    <el-table
            :data="skuList"
            stripe
            @selection-change="handleSelection"
            style="width: 100%">
        <el-table-column
                type="selection"
                width="55">
        </el-table-column>
        <el-table-column
                prop="spuId"
                label="spu_id"
                width="180">
        </el-table-column>
        <el-table-column
                prop="title"
                label="标题"
                width="180">
        </el-table-column>
        <el-table-column
                prop="images"
                label="图片"
                width="180">
            <template slot-scope="scope">

               <img :src="item" height="50" width="50" v-for="(item,index) in scope.row.images" :key="index"/>
            </template>
        </el-table-column>
        <el-table-column
                prop="price"
                label="价格">
        </el-table-column>
        <el-table-column
                prop="param"
                label="参数">
            <template slot-scope="scope">
               <div v-for="(val,key,i) in scope.row.param">
                   {{key}} <el-tag type="success">{{val}}</el-tag>
               </div>

            </template>
        </el-table-column>
        <el-table-column
                prop="valid"
                label="是否有效">

            <template slot-scope="scope">
                <el-tag :type="scope.row.valid?'success':'danger'">{{scope.row.valid?"有效":"无效"}}</el-tag>
            </template>

        </el-table-column>
        <el-table-column
                prop="createTime"
                label="创建时间">
        </el-table-column>
        <el-table-column
                prop="lastUpdateTime"
                label="更新时间">
        </el-table-column>

        <el-table-column label="操作">
            <template slot-scope="scope">
                <el-button
                        size="mini"
                        @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                <el-button
                        size="mini"
                        type="danger"
                        @click="handleDelete(scope.$index, scope.row)">删除</el-button>
            </template>
        </el-table-column>




<!--        <el-pagination-->
<!--                :page-size="20"-->
<!--                :pager-count="11"-->
<!--                layout="prev, pager, next"-->
<!--                :total="1000">-->
<!--        </el-pagination>-->
    </el-table>
    <el-button type="danger" :disabled="selectIds.length===0?true:false" @click="batchDelete">批量删除</el-button>
<!--dialog-->
    <el-dialog
            title="提示"
            :visible.sync="dialogVisible"
            width="60%"
            >
        <template>
            <el-form :inline="true" :model="skuForm" class="demo-form-inline" ref="skuForm">
                <el-form-item label="spu">
                    <el-select v-model="skuForm.spuId" placeholder="请选择" @change="handleChangeSpu">
                        <el-option
                                v-for="item in spuList"
                                :key="item.id"
                                :label="item.title"
                                :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="标题">
                    <el-input v-model="skuForm.title" placeholder="请输入标题"></el-input>
                </el-form-item>
                <el-form-item label="价格">
                    <el-input v-model="skuForm.price" placeholder="请输入价格"></el-input>
                </el-form-item>
                <el-form-item label="图片">
                    <el-upload
                            multiple
                            action=""
                            :limit="3"
                            :on-change="handleChange"
                            :on-remove="handleRemove"
                            :auto-upload="false"
                            :file-list="fileList"
                            :on-exceed="handleExceed"
                    >
                        <el-button slot="trigger" size="small" type="primary" @click="resetFileCount">选取文件</el-button>
                        <el-button size="small" type="success" @click="submitUpload">上传到服务器</el-button>
                    </el-upload>

                </el-form-item>


                   <el-form-item :label="item.name" v-for="(item,index) in defaultParams" :key="index" style="border: 1px solid red" v-if="defaultParams.length!==0">

                       <template>


                           <el-radio v-model="skuForm.param[item.name]" :label="desc" v-for="(desc,indexj) in item.details.desc" :key="indexj">{{ desc }}</el-radio>
                       </template>
                   </el-form-item>

                <el-form-item label="是否有效">
                    <el-switch
                            v-model="skuForm.valid"
                            active-color="#13ce66"
                            inactive-color="#ff4949">
                    </el-switch>
                </el-form-item>
            </el-form>
        </template>
    <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="submitForm">确 定</el-button>
  </span>
    </el-dialog>

</div>
</template>

<script>
    export default {
        name: "SKU",
        data(){
            return{
                selectIds:[],
                flag:0,// 0 : 增加  1：更新
                defaultParams:[],// 默认的参数信息
                oldFileList:[],// 之前的file
                fileList:[],//上传的文件列表，，Array
                fileCount:0,// 文件个数

                spuList:[],
                skuForm:{
                    spuId:1,
                    images:{
                    },
                    price:1,
                    param:{
                    },
                    valid:true,
                    title:""
                },
                dialogVisible:false,
                skuList:[]
            }
        },
        methods:{
            batchDelete(){
                let url = "/sku/batchDelete?"
                this.selectIds.forEach(item=>{
                    url+="ids="+item+"&"
                })
                this.deleteRequest(url).then(data=>{
                    if (data){
                        this.initSku()
                    }
                })
            },
            handleSelection(selection){
                this.selectIds = selection.map(item=>{
                    return item.id
                })
            },
            handleRemove(file,fileList){
                this.fileList = fileList
            },
            handleChangeSpu(spuId){
                // 切换spu_id
                this.initParamsByspuId(spuId)
            },
            handleInsert(){
                this.flag = 0;

                this.initForm()
                this.initParamsByspuId(1)
                this.dialogVisible =true

            },
            initForm(){
                this.skuForm.param={}
                this.skuForm.images={}
                this.skuForm.valid=true
                this.skuForm.title=""
                this.skuForm.spuId=1
                this.skuForm.price=""
                this.skuForm.id=""
                this.fileList=[]

            },
            submitForm(){
                this.$refs["skuForm"].validate(valid=>{
                    if (valid){

                        if (this.flag===0){
                            // 新增

                            this.postRequest("/sku",this.skuForm).then(data=>{
                                if (data){
                                    // console.log(data,666)
                                    this.initSku()
                                    this.initForm()
                                    this.dialogVisible=false
                                }
                            })
                        }

                        if (this.flag ===1){
                            //更新

                            this.putRequest("/sku",this.skuForm).then(data=>{
                                if (data){
                                    // console.log(data,777)
                                    this.initSku()
                                    this.initForm()
                                    this.dialogVisible=false
                                }
                            })
                        }
                        //


                    }
                })
            },
            submitUpload(){
                console.log(this.fileList)
                if (this.fileList.length===0){
                    this.$message.warning("请先选择上传文件！")
                    return
                }
                this.uploadFile()
            },
            uploadFile(){// 文件上传
                var formData = new FormData();
                this.fileList.forEach(file=>{
                    formData.append("multipartFiles",file.raw)
                })
                console.log(formData)
                this.postRequest("/sku/upload",formData,{"Content-Type":"multipart/form-data"}).then(({data})=>{
                    // 图片上传成功
                    // console.log(data,333333333333)
                    this.skuForm.images = data.desc
                    // console.log(this.skuForm,5555)
                })
            },
            handleExceed(files,fileList){
                this.$message.warning(`当前限制3个文件，本次选择了${files.length},共选择了${files.length+fileList.length}个`)
            },
            resetFileCount(){
                this.fileCount = 0;
            },
            handleChange(file,fileList){
                // console.log(file,fileList)
                // 之前的file
                 this.oldFileList = Object.assign(this.fileList);
                let isExist = this.oldFileList.some(f=>{
                    return f.name===file.name
                })

                if (isExist){
                    this.$message.warning("请勿重复上传文件")
                    fileList.pop()
                    return
                }

                this.fileList = fileList
                // 文件个数
                this.fileCount++
            },
            initSpu(){
                this.getRequest("/spu").then(data=>{
                    // console.log(data,11111111111)
                    this.spuList=data
                })
            },
            handleEdit(index,row){
                // console.log(index,row)
                this.flag=1
                this.skuForm = JSON.parse(JSON.stringify(row))
                this.initParamsByspuId(row.spuId)


                this.dialogVisible=true
            },

            initParamsByspuId(id){
                this.getRequest("/sku/params/"+id).then(data=>{
                        if (data[0]){

                            data.forEach(item=>{
                                if (item){
                                    item.details = JSON.parse(item.details)
                                }
                            })
                            this.defaultParams = data;
                        }else {
                            this.defaultParams=[]
                        }


                })
            },
            handleDelete(index,row){
                this.deleteRequest("/sku/"+row.id).then(data=>{
                    if (data){
                        this.initSku()
                    }
                })
            },
            initSku(){

                this.getRequest("/sku"+this.$route.path).then(data=>{
                    // console.log(data,99999)
                    data.records.forEach(item=>{
                        item.images = JSON.parse(item.images)
                        item.param = JSON.parse(item.param)
                    })
                    // console.log(data.records[0].images["hehe"][0])
                    this.skuList = data.records
                })
            }
        },
        watch:{

            $route(newVal,oldVal){
                // console.log(newVal,oldVal,4444)
                this.initSku()
            }
        },
        mounted() {
            this.initSpu()
            this.initSku()
        }
    }
</script>

<style scoped>

</style>
