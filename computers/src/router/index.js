import Vue from 'vue'
import Router from 'vue-router'
// 导入刚才编写的组件
import AppIndex from '@/components/home/AppIndex'
import Login from '@/components/Login'
import Home from '../components/Home'
import ComputersIndex from '../components/computers/ComputersIndex'
import details from '../components/computers/details'
import peijian from '../components/peijian/peijian'
import mine from '../components/mine/mine'
import manager from '../components/manager'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path:'/home',
      name:'Home',
      component:Home,
      //home页面并不需要被访问
      children:[
        {
          path:'/computers',
          name:'Computers',
          component:ComputersIndex,
          meta:{
            requireAuth:true
          }
        },
        {
          path:'/computers/details/:brand/:series/:model',
          name:'Details',
          component:details,
          meta:{
            requireAuth:true
          },
          
        },
        {
          path:'/peijian',
          name:'Peijian',
          component:peijian,
          meta:{
            requireAuth:true
          }
        },
        {
          path:'/mine',
          name:'Mine',
          component:mine,
          meta:{
            requireAuth:true
          }
        },
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/manager',
      name: 'Manager',
      component: manager
    }
  ]
})

