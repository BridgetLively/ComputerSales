<template>
  <el-container>
    <el-main>
      <div class="more">
        <el-dropdown>
          <span class="el-dropdown-link">
            更多<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="checkshopping">查看购物车</el-dropdown-item>
            <el-dropdown-item @click.native="clearshopping">清空购物车</el-dropdown-item>
            <el-dropdown-item @click.native="logout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
      <div>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="姓名">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="联系电话">
            <el-input v-model="form.phone"></el-input>
          </el-form-item>
          <el-form-item label="邮箱">
            <el-input v-model="form.email"></el-input>
          </el-form-item>
          <el-form-item label="运送地址">
            <el-input v-model="form.addr"></el-input>
          </el-form-item>
          <el-form-item label="支票单号">
            <el-input v-model="form.ticket"></el-input>
          </el-form-item>
          <el-form-item label="信用卡号">
            <el-input v-model="form.card"></el-input>
          </el-form-item>
          <el-form-item label="即时配送">
            <el-switch v-model="form.delivery"></el-switch>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">创建订单</el-button>
            <el-button type="primary" @click="checkorder">查看订单状态</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-main>
  </el-container>
    
</template>

<script>
  export default {
    data() {
      return {
        form: {
          name: '',
          phone: '',
          email:'',
          addr: '',
          ticket: '',
          card:'',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        order:[],
        str:'',
        count:0,
        shoppinglist:[],
      }
    },
    mounted:function() {
      this.loadUsername()
    },
    methods: {
      loadUsername(){
        this.username=this.$route.params.username
      },
      onSubmit() {
        this.$axios
        .post('/createorder',{
          name:this.form.name,
          phone:this.form.phone,
          email:this.form.email,
          addr:this.form.addr,
          ticket:this.form.ticket,
          card:this.form.card
        })
        this.$message('创建成功');
      },
      clearshopping()
      {
        this.$axios
        .post('/clearshopping')
        this.$message('清空成功');
      },
      checkshopping()
      {
        console.log("查看购物车")
        this.str=''
        this.count=0
        var _this=this
        this.$axios.get('/checkshopping').then(resp=>{
            if(resp&&resp.status==200){
                _this.shoppinglist=resp.data
                for(var i=0;i<this.shoppinglist.length;i++)
                {
                  if(this.shoppinglist[i][2]!=null)
                    this.str=this.str+'<br/>'+'标准电脑:'+this.shoppinglist[i][2]+" x1"
                  if(this.shoppinglist[i][3]!=null)
                    this.str=this.str+'    组装电脑:'+this.shoppinglist[i][3]+" x1"
                }
                console.log(this.str)
                this.$alert(this.str,'查看购物车',{dangerouslyUseHTMLString:true},{
                  confirmButtonText: '确定',
                  callback: action => {
                    this.$message({
                      type: 'info',
                      message: `action: ${ action }`
                    });
                  }
                },
                );
            }else{
                console.log("fail")
            }
        })
      },
      checkorder()
      {
        this.str=''
        this.count=0
        var _this=this
        this.$axios.get('/checkorderstatus').then(resp=>{
            if(resp&&resp.status==200){
                _this.order=resp.data
                for(var i=0;i<this.order.length;i++)
                {
                  this.str=this.str+'<br/>'+'订单:'+this.order[i][0]+' 状态:'+this.order[i][1]
                }
                console.log(this.str)
                this.$alert(this.str,'查看订单',{dangerouslyUseHTMLString:true},{
                  confirmButtonText: '确定',
                  callback: action => {
                    this.$message({
                      type: 'info',
                      message: `action: ${ action }`
                    });
                  }
                },
                );
            }else{
                console.log("fail")
            }
        })
      },
      logout()
      {
        console.log("logout")
        this.$axios
        .post('/logout',{
        })
        this.$message('退出成功');
      }
    }
  }
</script>

<style scoped>
.more{
  /* background-color:aquamarine; */
  width:8%;
  margin-left: 1380px;
  margin-bottom: 15px;
}
</style>

