<template>
    <div>
        <div>添加商品</div>
        <div class="com_details">
            <el-button size="small" @click="addComputer = true">添加商品</el-button>
            <div id="app">
            <el-dialog
                title="添加标准电脑"
                :visible.sync="addComputer"
                width="50%"
                :before-close="handleClose">
                <span>请输入要添加的标准电脑</span>
                <el-input v-model="s_com1" placeholder="请输入编号" ></el-input>
                <el-input v-model="s_com2" placeholder="请输入品牌" ></el-input>
                <el-input v-model="s_com3" placeholder="请输入店铺"></el-input>
                <el-input v-model="s_com4" placeholder="请输入电脑类型"></el-input>
                <el-input v-model="s_com5" placeholder="请输入图片" ></el-input>
                <el-input v-model="s_com6" placeholder="请输入系列" ></el-input>
                <el-input v-model="s_com7" placeholder="请输入颜色" ></el-input>
                <el-input v-model="s_com8" placeholder="请输入平台" ></el-input>
                <el-input v-model="s_com9" placeholder="请输入型号" ></el-input>
                <el-input v-model="s_com10" placeholder="请输入操作系统" ></el-input>
                <el-input v-model="s_com11" placeholder="请输入品牌" ></el-input>
                <el-input v-model="s_com12" placeholder="请输入扬声器" ></el-input>
                <el-input v-model="s_com13" placeholder="请输入麦克风"></el-input>
                <el-input v-model="s_com14" placeholder="请输入键盘" ></el-input>
                <el-input v-model="s_com15" placeholder="请输入触摸板" ></el-input>
                <el-input v-model="s_com16" placeholder="请输入电池"></el-input>
                <el-input v-model="s_com17" placeholder="请输入显卡大小" ></el-input>
                <el-input v-model="s_com18" placeholder="请输入显卡类型" ></el-input>
                <el-input v-model="s_com19" placeholder="请输入显示端口" ></el-input>
                <el-input v-model="s_com20" placeholder="请输入音频端口"></el-input>
                <el-input v-model="s_com21" placeholder="请输入屏幕类型" ></el-input>
                <el-input v-model="s_com22" placeholder="请输入屏幕尺寸" ></el-input>
                <el-input v-model="s_com23" placeholder="请输入屏幕分辨率" ></el-input>
                <el-input v-model="s_com24" placeholder="请输入内存大小" ></el-input>
                <el-input v-model="s_com25" placeholder="请输入机械硬盘" ></el-input>
                <el-input v-model="s_com26" placeholder="请输入固态硬盘" ></el-input>
                <el-input v-model="s_com27" placeholder="请输入cpu型号"></el-input>
                <el-input v-model="s_com28" placeholder="请输入cpu核数"></el-input>
                <el-input v-model="s_com29" placeholder="请输入光驱" ></el-input>
                <el-input v-model="s_com30" placeholder="清楚人请输入价格"></el-input>
                <el-input v-model="s_com29" placeholder="请输入简介"></el-input>
                <el-input v-model="s_com30" placeholder="请输入库存量" ></el-input>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="cancel">取 消</el-button>
                    <el-button type="primary" @click="addComputer">确 定</el-button>
                </span>
                </el-dialog>
        </div>
            <p>标准电脑信息</p>
            <el-table :data="tableData0" stripe style="width: 100%">
                <el-table-column
                    prop="id"
                    label="编号"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="brand"
                    label="品牌"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="store"
                    label="店铺"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="type"
                    label="电脑类型"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="img"
                    label="图片"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="series"
                    label="系列"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="color"
                    label="颜色"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="platform"
                    label="平台"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="model"
                    label="型号"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="os"
                    label="操作系统"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="brand"
                    label="品牌"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="speaker"
                    label="扬声器"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="microphone"
                    label="麦克风"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="keyboard"
                    label="键盘"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="touchpad"
                    label="触摸板"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="power"
                    label="电池"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="graphics_size"
                    label="显卡大小"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="graphics_type"
                    label="显卡类型"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="show_port"
                    label="显示端口"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="audio_port"
                    label="音频端口"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="screen_type"
                    label="屏幕类型"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="screen_size"
                    label="屏幕尺寸"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="screen_resolution"
                    label="屏幕分辨率"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="ram_size"
                    label="内存大小"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="hdd"
                    label="机械硬盘"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="ssd"
                    label="固态硬盘"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="cpu_model"
                    label="cpu型号"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="cpu_num"
                    label="cpu核数"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="optical_type"
                    label="光驱"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="price"
                    label="价格"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="abs"
                    label="简介"
                    width="auto">
                </el-table-column>
                <el-table-column
                    prop="num"
                    label="库存量"
                    width="auto">
                </el-table-column>
            </el-table>
        </div>
        <div class="allpeijian">添加修改配件</div>
        <div class="menu_position">
            <el-dropdown>
              <span class="el-dropdown-link">
                请选择配件类型<i class="el-icon-arrow-down el-icon--right"></i>
              </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item @click.native="s_menu">屏幕</el-dropdown-item>
                <el-dropdown-item @click.native="r_menu">内存</el-dropdown-item>
                <el-dropdown-item @click.native="d_menu">硬盘</el-dropdown-item>
                <el-dropdown-item @click.native="c_menu">CPU</el-dropdown-item>
                <el-dropdown-item @click.native="p_menu">电源</el-dropdown-item>
                <el-dropdown-item @click.native="g_menu">显卡</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>
        <div class="tables">
          <el-table
            :data=tableData
            stripe border
            style="width: 100%">
            <template v-for="(item,index) in header">
              <el-table-column :prop="item.column_name" :label="item.column_comment" :key="index"></el-table-column>
            </template>
          </el-table>
        </div>
    </div>
</template>

<script>
export default {
    name:'Manager',
    data(){
        return{
            addComputer: false,
            s_com1:"",
            s_com2:"",
            s_com3:"",
            s_com4:"",
            s_com5:"",
            s_com6:"",
            s_com7:"",
            s_com8:"",
            s_com9:"",
            s_com10:"",
            s_com11:"",
            s_com12:"",
            s_com13:"",
            s_com14:"",
            s_com15:"",
            s_com16:"",
            s_com17:"",
            s_com18:"",
            s_com19:"",
            s_com20:"",
            s_com31:"",
            s_com32:"",
            s_com13:"",
            s_com14:"",
            s_com15:"",
            s_com16:"",
            s_com17:"",
            s_com18:"",
            s_com19:"",
            s_com20:"",
            tableData0: [],
            tableData:[],
            header:[{column_name:"id",column_comment:"屏幕编号"},
            {column_name:"screen_type",column_comment:"屏幕类型"},
            {column_name:"screen_size",column_comment:"屏幕尺寸"},
            {column_name:"screen_resolution",column_comment:"分辨率"},
            {column_name:"price",column_comment:"价格"},
            {column_name:"num",column_comment:"库存量"}],
            header1:[{column_name:"id",column_comment:"屏幕编号"},
            {column_name:"screen_type",column_comment:"屏幕类型"},
            {column_name:"screen_size",column_comment:"屏幕尺寸"},
            {column_name:"screen_resolution",column_comment:"分辨率"},
            {column_name:"price",column_comment:"价格"},
            {column_name:"num",column_comment:"库存量"}],
            header2:[{column_name:"id",column_comment:"内存编号"},
            {column_name:"ram_size",column_comment:"内存大小"},
            {column_name:"price",column_comment:"价格"},
            {column_name:"num",column_comment:"库存量"}],
            header3:[{column_name:"id",column_comment:"硬盘编号"},
            {column_name:"disk_type",column_comment:"硬盘类型"},
            {column_name:"disk_size",column_comment:"硬盘大小"},
            {column_name:"price",column_comment:"价格"},
            {column_name:"num",column_comment:"库存量"}],
            header4:[{column_name:"id",column_comment:"CPU编号"},
            {column_name:"cpu_num",column_comment:"CPU核数"},
            {column_name:"price",column_comment:"价格"},
            {column_name:"num",column_comment:"库存量"}],
            header5:[{column_name:"id",column_comment:"电源编号"},
            {column_name:"power_type",column_comment:"电源类型"},
            {column_name:"price",column_comment:"价格"},
            {column_name:"num",column_comment:"库存量"}],
            header6:[{column_name:"id",column_comment:"显卡编号"},
            {column_name:"graphics_size",column_comment:"显卡大小"},
            {column_name:"graphics_type",column_comment:"显卡类型"},
            {column_name:"price",column_comment:"价格"},
            {column_name:"num",column_comment:"库存量"}],
            tableData1: [],
            tableData2: [],
            tableData3: [],
            tableData4: [],
            tableData5: [],
            tableData6: [],
        }
    },
    mounted:function(){
        this.loadComputer()
        this.loadScreen()
        this.loadRam()
        this.loadDisk()
        this.loadCpu()
        this.loadPower()
        this.loadGraphics()
    },
    methods:{
        submit(){
            if(this.comment=='')
            {
              this.$message('留言不能为空');
            }else{
              this.$axios
              .post('/message',{
              comment:this.comment
              })
              console.log(this.comment)
              this.addComputer=false
              this.comment=""
            }
            
        },
        cancel()
        {
            this.addComputer=false
        },
        loadComputer(){
            var _this=this
            this.$axios.get('/manager/getallcomputers').then(resp=>{
                if(resp&&resp.status==200){
                    _this.tableData0=resp.data
                }else{
                    console.log("fail")
                }
            })
        },
        loadScreen(){
            var _this=this
            this.$axios.get('/screen').then(resp=>{
                if(resp&&resp.status==200){
                    _this.tableData1=resp.data
                    _this.tableData=resp.data
                }else{
                    console.log("fail")
                }
            })
        },
        loadRam(){
            var _this=this
            this.$axios.get('/ram').then(resp=>{
                if(resp&&resp.status==200){
                    _this.tableData2=resp.data
                }else{
                    console.log("fail")
                }
            })
        },
        loadDisk(){
            var _this=this
            this.$axios.get('/disk').then(resp=>{
                if(resp&&resp.status==200){
                    _this.tableData3=resp.data
                }else{
                    console.log("fail")
                }
            })
        },
        loadCpu(){
            var _this=this
            this.$axios.get('/cpu').then(resp=>{
                if(resp&&resp.status==200){
                    _this.tableData4=resp.data
                }else{
                    console.log("fail")
                }
            })
        },
        loadPower(){
            var _this=this
            this.$axios.get('/power').then(resp=>{
                if(resp&&resp.status==200){
                    _this.tableData5=resp.data
                }else{
                    console.log("fail")
                }
            })
        },
        loadGraphics(){
            var _this=this
            this.$axios.get('/graphics').then(resp=>{
                if(resp&&resp.status==200){
                    _this.tableData6=resp.data
                }else{
                    console.log("fail")
                }
            })
        },
        s_menu()
      {
        this.header=this.header1
        this.tableData=this.tableData1
      },
      r_menu()
      {
        this.header=this.header2
        this.tableData=this.tableData2
      },
      d_menu()
      {
        this.header=this.header3
        this.tableData=this.tableData3
      },
      c_menu()
      {
        this.header=this.header4
        this.tableData=this.tableData4
      },
      p_menu()
      {
        this.header=this.header5
        this.tableData=this.tableData5
      },
      g_menu()
      {
        this.header=this.header6
        this.tableData=this.tableData6
      },
    }
}
</script>

<style scoped>
.inputs_com{
  /* background-color: aqua; */
  /* margin-top: 0px;
  height: 40px; */
  display: inline;
}
.com_details{
    /* background-color: bisque; */
    /* font-weight: bold; */
    width: 100%;
}
.el-dropdown-link {
    cursor: pointer;
    color: #409EFF;
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }
</style>