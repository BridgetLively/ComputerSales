<template>
    <el-container>
        <div v-for="item in details"
        :key="item.id" style="width:100%">
            <el-header>
                <p>{{brand}} {{item.series}} {{item.model}}</p>
            </el-header>
            <el-main>
                <div class="booking">
                    <div style="width:35%">
                        <el-card>
                            <img :src="item.img">
                        </el-card>
                    </div>
                    <div style="width:65%">
                        <!-- <el-card></el-card> -->
                        <p class="title">
                            {{item.brand}}{{item.series}}{{item.screen_size}}({{item.model}} {{item.ram_size}})
                        </p>
                        <p class="abs">
                            {{item.abs}}
                        </p>
                        <p class="price">
                            秒杀价 ￥{{item.price}}
                        </p>
                        <p class="num">
                            库存量：{{item.num}} 件
                        </p>
                        <p class="btn">
                            <el-button v-on:click="buyIt">加入购物车</el-button>
                            <el-button @click="dialogVisible = true">联系客服</el-button>
                        </p>
                        <div id="app">
                            <el-dialog
                                title="留言版"
                                :visible.sync="dialogVisible"
                                width="50%"
                                :before-close="handleClose">
                                <span>请输入留言信息</span>
                                <el-input type="text" v-model="comment" auto-complete="off" placeholder="留言信息"></el-input>
                                <span slot="footer" class="dialog-footer">
                                    <el-button @click="cancel">取 消</el-button>
                                    <el-button type="primary" @click="submit">确 定</el-button>
                                </span>
                                </el-dialog>
                        </div>
                    </div>
                </div>
                <div class="com_details">
                    <p>配置细节</p>
                    <el-table :data="tableData" stripe style="width: 100%">
                        <el-table-column
                            prop="str1"
                            label="配件"
                            width="auto"
                            align="center">
                        </el-table-column>
                        <el-table-column
                            prop="str2"
                            label="规格"
                            width="auto"
                            align="left">
                        </el-table-column>
                    </el-table>
                </div>
            </el-main>
        </div>
    </el-container>
</template>
<script>
export default {
    name:'Details',
    data(){
        return{
            comment:'',
            dialogVisible: false,
            tableData: [{str0:'series',str1:'系列',str2:''},
            {str0:'color',str1:'颜色',str2:''},
            {str0:'platform',str1:'平台',str2:''},
            {str0:'model',str1:'型号',str2:''},
            {str0:'os',str1:'操作系统',str2:''},
            {str0:'speaker',str1:'扬声器',str2:''},
            {str0:'microphone',str1:'内置麦克风',str2:''},
            {str0:'keyboard',str1:'键盘',str2:''},
            {str0:'touchpad',str1:'触摸板',str2:''},
            {str0:'show_port',str1:'显示端口',str2:''},
            {str0:'audio_port',str1:'音频端口',str2:''},
            {str0:'screen_type',str1:'屏幕类型',str2:''},
            {str0:'screen_size',str1:'屏幕规格',str2:''},
            {str0:'screen_resolution',str1:'物理分辨率',str2:''},
            {str0:'graphics_size',str1:'显存容量',str2:''},
            {str0:'graphics_type',str1:'显卡类型',str2:''},
            {str0:'ram_size',str1:'内存容量',str2:''},
            {str0:'cpu_model',str1:'CPU型号',str2:''},
            {str0:'cpu_num',str1:'处理器核数',str2:''},
            {str0:'power',str1:'电池',str2:''},
            {str0:'optical_type',str1:'光驱',str2:''},
            {str0:'hdd',str1:'固态硬盘',str2:''},
            {str0:'ssd',str1:'机械硬盘',str2:''},],
            // computer:[{
            //     brand:this.$route.params.brand,
            //     series:this.$route.params.series,
            //     model:this.$route.params.model
            // }],
            details:[{
                id:0,
                brand_id:0,
                img:'',
                series:'',
                color:'',
                platform:'',
                model:'',
                os:'',
                speaker:'',
                microphone:'',
                keyboard:'',
                touchpad:'',
                power:'',
                graphics_size:'',
                graphics_type:'',
                show_port:'',
                audio_port:'',
                screen_type:'',
                screen_size:'',
                screen_resolution:'',
                ram_size:'',
                hdd:'',
                ssd:'',
                cpu_model:'',
                cpu_num:'',
                optical_type:'',
                price:0.0,
                abs:'',
                num:''
            }],
            username:'',
            brand:''
        }
    },
    mounted:function(){
        this.loadDetails()
    },
    methods:{
        submit(){
            if(this.comment=='')
            {
                console.log("空留言")
                this.$message('留言不能为空');
            }else
            {
                this.$axios
                .post('/message',{
                comment:this.comment
                })
                console.log(this.comment)
                this.dialogVisible=false
                this.comment=""
            }
            
        },
        cancel()
        {
            this.dialogVisible=false
        },
        handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
        buyIt(){
            if(this.details[0].num>0)
            {
                var _this=this
                this.$axios
                    .post('/computer/details/order1',{
                        s_id:this.details[0].id
                    })
                this.$message('添加成功');
            }else{
                this.$message('库存量不足')
            }
            
        },
        loadDetails(){
            var _this=this
            this.$axios
                .post('/computer/details',{
                    id:this.$route.params.id
                })
                .then(resp=>{
                    _this.details=resp.data
                     for(var key in this.tableData)
                    {
                        var value=this.tableData[key].str0
                        for(var ke in this.details[0])
                        {
                            if(value==ke)
                            {
                                this.tableData[key].str2=this.details[0][ke]
                                break
                            }
                        }
                    }
                })
                this.brand=this.$route.params.brand
        }
    }
}
</script>

<style scoped>
.com{
    background-color: aqua,
    /* padding: 0px; */
}
.el-header{
    background-color: #e6eaee;
    color: #333;
    text-align: center;
    font-size: 18px;
    /* line-height: 60px; */
}
img{
    width: 350px;
    height: 330px;
    margin: center;
}
.title{
    text-align: center;
    margin-top: 23px;
    height: 10%;
    font-weight: bold
    /* background-color: aqua; */
}
.abs{
    text-align: center;
    /* background-color: bisque; */
    height: 15%;
}
.price{
    text-align: center;
    /* background-color: aqua; */
    height: 10%;
}
.num{
    text-align: center;
    margin-top: 20px;
    /* background-color: bisque; */
    height: 15%;
}
.btn{
    margin-top: 20px;
    /* background-color: aqua; */
    height: 20%;
}
.booking{
    display: flex;
}
.com_details{
    /* background-color: bisque; */
    font-weight: bold;
    width: 100%;
}
/* .el-main{
    display: table-row;
} */
</style>