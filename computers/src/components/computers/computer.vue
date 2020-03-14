<template>
    <div>
        <el-row style="height:840px;">
            <!-- <search-bar></search-bar> -->
            <el-tooltip effect="dark" placement="right" 
                        v-for="item in computer" 
                        :key="item.id">
                <p slot="content" style="font-size:14px;margin-bottom:6px;">{{item.brand}}</p>
                <p slot="content" style="font-size:13px;margin-bottom:6px">
                    <span>{{item.store}}</span> /
                    <span>{{item.price}}</span>
                </p>
                <p slot="content" style="width:300px" class="abstract">{{item.abs}}</p>
                <el-card style="width:200px;margin-bottom:20px;height:233px;float:left;margin-right:15px" class="computer" body-style="padding:10px" shadow="hover">
                    <div class="cover">
                        <!-- {name:'PageName',params:{id:1}} -->
                        
                        <router-link 
                            :to="{
                            name:'Details',
                            params:{
                                id:item.id,
                                brand:item.brand,
                                series:item.series,
                                model:item.model
                            }
                            }"><img :src="item.img" alt="封面"></router-link>
                    </div>
                    <div class="info">
                        <div class="title">
                            <router-link 
                            :to="{
                            name:'Details',
                            params:{
                                id:item.id,
                                brand:item.brand,
                                series:item.series,
                                model:item.model
                            }
                            }"><a href="">{{item.brand}} {{item.series}}</a></router-link>
                        </div>
                    </div>
                    <div class="store">{{item.store}}</div>
                </el-card>
            </el-tooltip>
        </el-row>
        <el-row>
            <el-pagination :current-page="1" :page-size="10" :total="20"></el-pagination>
        </el-row>
    </div>
</template>

<script>
export default {
    name:'Computer',
    data(){
        return{
            computer:[],
            username:''
        }
    },
    mounted:function(){
        this.loadComputer()
    },
    methods:{
        loadComputer(){
            var _this=this
            this.$axios.get('/computer').then(resp=>{
                if(resp&&resp.status==200){
                    _this.computer=resp.data
                }else{
                    console.log("fail")
                }
            })
        }
    }
}
</script>

<style scoped>
.cover{
    width:175px;
    height: 172px;
    margin-bottom: 7px;
    overflow: hidden;
    cursor:pointer;
}
img{
    width: 175px;
    height: 172px;
}
.title{
    font-size: 10px;
    text-align: left;
}
.store{
    color:brown;
    font-size: 8px;
    margin-top: 5px;
    margin-bottom: 6px;
    text-align: left;
}
.abstract{
    display: block;
    line-height: 17px;
}
a{
    text-decoration:none;
}
a:link, a:visited, a:focus{
    color: #3377aa;
}
</style>