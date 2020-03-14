<template>
  <body id="poster">
    <el-form class="login-container" label-position="left" label-width="0px">
    <h3 class="login_titile">系统登录</h3>
    <el-form-item>
      <el-input type="text" v-model="loginForm.username" auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="loginForm.password" auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-radio v-model="radio" label="1" @change="user" >用户</el-radio>
    <el-radio v-model="radio" label="2" @change="manager" >管理员</el-radio>
    <el-form-item>
      <el-button type="primary" style="width:100%;background:#505458;border:none" v-on:click="register">注册</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" style="width:100%;background:#505458;border:none" v-on:click="login">登录</el-button>
    </el-form-item>
  </el-form>
  </body>
</template>
<style>
  #poster{
    background: url("../assets/login_background.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
  body{
    margin: 0px;
  }
  .login-container{
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background:#fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6ca;
  }
  .login_title{
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
</style>
<script>
  export default {
    name: 'Login',
    data () {
      return {
        loginForm: {
          username: '',
          password: '',
        },
        responseResult: [],
        radio: '1',
        // radioclick:'false'
      }
      
    },
    methods: {
      user(){
        this.radio=1;
        
        console.log(this.radio)
      },
      manager(){
        this.radio=2;
        console.log(this.radio)
        this.$router.push({
          name:'Manager'
        })
      },
      login () {
        this.$axios
          .post('/login', {
            username: this.loginForm.username,
            password: this.loginForm.password
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              this.$router.push({
                name:'Computers',
                params:{
                  username:this.loginForm.username
                }
              })
            }
          })
          .catch(failResponse => {
          })
      },
      register(){
        this.$axios
        .post('/register',{
          username:this.loginForm.username,
          password:this.loginForm.password
        })
        .then(successResponse=>{
          if(successResponse.data.code===200){
            this.$message('注册成功');
          }
        })
        .catch(failResponse=>{
          this.$message('注册失败')
        })
      }
    }
  }
</script>

