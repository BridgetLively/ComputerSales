<template>
    <el-container>
      <el-header>
        浏览下方可供选择配件，并将需要购买的配件编号填入对应输入框内
      </el-header>
      <el-main>
        <div class="choose">
          <el-input v-model="input1" placeholder="请输入屏幕编号" @input="s_id"></el-input>
          <el-input v-model="input2" placeholder="请输入内存编号" @input="r_id"></el-input>
          <el-input v-model="input3" placeholder="请输入硬盘编号" @input="d_id"></el-input>
          <el-input v-model="input4" placeholder="请输入CPU编号" @input="c_id"></el-input>
          <el-input v-model="input5" placeholder="请输入电源编号" @input="p_id"></el-input>
          <el-input v-model="input6" placeholder="请输入显卡编号" @input="g_id"></el-input>
          <el-button size="small" v-on:click="countPrice">计算总价</el-button>
        </div>
        <div class="disp_price"><p>总计：￥ {{count}} <el-button size="small" v-on:click="buyIt">加入购物车</el-button>
          <el-button size="small" @click="dialogVisible = true">联系客服</el-button></p></div>
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
      </el-main>
    </el-container>
</template>

<script>
  export default {
    name: 'AppIndex',
    data() {
      return {
        comment:'',
        dialogVisible: false,
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
        input1:'',
        input2:'',
        input3:'',
        input4:'',
        input5:'',
        input6:'',
        count:0,
        show1:false
      }
    },
    mounted:function(){
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
      s_id()
      {
        var true1=0
        for(var key in this.tableData1)
        {
          if(this.tableData1[key].id==this.input1)
            true1=1
        }
        if(true1==0)
        {
          this.input1=""
          this.$message('没有该选项！');
        }
        if(this.tableData1[this.input1-1].num<=0)
        {
          this.$message('该配件无库存！');
          this.input1=""
        }
      },
      r_id()
      {
        var true1=0
        for(var key in this.tableData2)
        {
          if(this.tableData2[key].id==this.input2)
            true1=1
        }
        if(true1==0)
        {
          this.input2=""
          this.$message('没有该选项！');
        }
        if(this.tableData2[this.input2-1].num<=0)
        {
          this.$message('该配件无库存！');
          this.input2=""
        }
      },
      d_id()
      {
        var true1=0
        for(var key in this.tableData3)
        {
          if(this.tableData3[key].id==this.input3)
            true1=1
        }
        if(true1==0)
        {
          this.input3=""
          this.$message('没有该选项！');
        }
        if(this.tableData3[this.input3-1].num<=0)
        {
          this.$message('该配件无库存！');
          this.input3=""
        }
      },
      c_id()
      {
        var true1=0
        for(var key in this.tableData4)
        {
          if(this.tableData4[key].id==this.input4)
            true1=1
        }
        if(true1==0)
        {
          this.input4=""
          this.$message('没有该选项！');
        }
        if(this.tableData4[this.input4-1].num<=0)
        {
          this.$message('该配件无库存！');
          this.input4=""
        }
      },
      p_id()
      {
        var true1=0
        for(var key in this.tableData5)
        {
          if(this.tableData5[key].id==this.input5)
            true1=1
        }
        if(true1==0)
        {
          this.input5=""
          this.$message('没有该选项！');
        }
        if(this.tableData5[this.input5-1].num<=0)
        {
          this.$message('该配件无库存！');
          this.input5=""
        }
      },
      g_id()
      {
        var true1=0
        for(var key in this.tableData6)
        {
          if(this.tableData6[key].id==this.input6)
            true1=1
        }
        if(true1==0)
        {
          this.input6=""
          this.$message('没有该选项！');
        }
        if(this.tableData6[this.input6-1].num<=0)
        {
          this.$message('该配件无库存！');
          this.input6=""
        }
      },
      buyIt(){
        var _this=this
        this.countPrice()
        if(this.input1==""||this.input2==""||this.input3==""||this.input4==""||this.input5==""||this.input6=="")
        {
          this.$message('请选好六个主要配件！');
        }else{
          this.$axios
          .post('/computer/details/order2',{
              screen_id:this.input1,
              ram_id:this.input2,
              disk_id:this.input3,
              cpu_id:this.input4,
              power_id:this.input5,
              graphics_id:this.input6
          })
          this.$message('添加成功');
        }
                  
      },
      countPrice(){
        this.count=0
        for(var key in this.tableData1)
        {
            if(this.tableData1[key].id==this.input1)
              this.count=this.count+this.tableData1[key].price   
        }
        for(var key in this.tableData2)
        {
            if(this.tableData2[key].id==this.input2)
              this.count=this.count+this.tableData2[key].price   
        }
        for(var key in this.tableData3)
        {
            if(this.tableData3[key].id==this.input3)
              this.count=this.count+this.tableData3[key].price   
        }
        for(var key in this.tableData4)
        {
            if(this.tableData4[key].id==this.input4)
              this.count=this.count+this.tableData4[key].price   
        }
        for(var key in this.tableData5)
        {
            if(this.tableData5[key].id==this.input5)
              this.count=this.count+this.tableData5[key].price   
        }
        for(var key in this.tableData6)
        {
            if(this.tableData6[key].id==this.input6)
              this.count=this.count+this.tableData6[key].price   
        }
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
        }
    }
    
  }
</script>

<style scoped>
.disp_price{
  margin-top: 250px;
}
.menu_position{
  margin-top: 40px;
}
.choose{
  /* background-color: aqua; */
  margin-top: 0px;
  height: 40px;
  /* display: flex; */
}
.tables{
  /* display: flex; */
  margin-top: 10px;
}
.el-dropdown-link {
    cursor: pointer;
    color: #409EFF;
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }
</style>