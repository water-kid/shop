<template>
    <el-container>

        <el-aside width="400px">
            <div style="display: flex">
                <el-tag type="success">商品title</el-tag>
                <el-input
                        placeholder="请输入内容"
                        v-model="pagination.title">
                    <i slot="prefix" class="el-input__icon el-icon-search"></i>
                </el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
            </div>
            <el-menu
                    :default-active="$route.path"
                    class="el-menu-vertical-demo"
                    @select="handleSelectMenu"
                   >
                <el-menu-item :index="'/'+item.id" v-for="(item,index) in spuList" :key="item.id">{{ item.title}}</el-menu-item>


            </el-menu>

            <el-pagination
                    background
                    layout="prev, pager, next"
                    :page-size="pagination.pageSize"
                    :current-page="pagination.currentPage"
                    @current-change="handleCurrentChange"
                    :total="pagination.total">
            </el-pagination>
        </el-aside>
        <el-main>
            <router-view></router-view>
        </el-main>

    </el-container>
</template>

<script>
    export default {
        name: "SkuHome",
        data(){
            return{
                spuList:[],
                pagination:{
                    currentPage:1,
                    pageSize:4,
                    title:"",
                    total:0
                }
            }
        },
        methods:{
            handleSearch(){
                this.initSpu()
                this.pagination.currentPage=1
            },
            handleSelectMenu(index,indexPath){
                // console.log(index,indexPath)
                this.$router.push(index)

            },
            handleCurrentChange(val){
                // console.log("currentpage---"+val)
                this.pagination.currentPage=val
                this.initSpu()

                this.$router.push("/"+((this.pagination.currentPage-1)*this.pagination.pageSize+1))
            },

            initSpu() {
                let url = "?"
                Object.keys(this.pagination).forEach(key=>{
                    url+= key+"="+this.pagination[key]+"&"
                })

                this.getRequest("/spu/getByPage"+url).then(data=>{
                    // console.log(data,888)
                    this.spuList = data.records
                    this.pagination.currentPage=data.current
                    this.pagination.pageSize = data.size
                    this.pagination.total = data.total
                })
            }
        },
        mounted() {
            this.initSpu()
            this.$router.push("/1")
        }
    }
</script>

<style scoped>

</style>
