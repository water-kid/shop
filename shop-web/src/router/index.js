import Vue from 'vue'
import VueRouter from 'vue-router'
import SKU from "@/views/SKU";
Vue.use(VueRouter)
import SkuHome from "@/views/SkuHome";


// 获取原型对象push函数
const originalPush = VueRouter.prototype.push

// 获取原型对象replace函数
const originalReplace = VueRouter.prototype.replace

// 修改原型对象中的push函数
VueRouter.prototype.push = function push(location){
  return originalPush.call(this , location).catch(err=>err)
}

// 修改原型对象中的replace函数
VueRouter.prototype.replace = function replace(location){
  return originalReplace.call(this , location).catch(err=>err)
}


const routes = [

  {
    path: '/',
    name: 'sku',
    component: SkuHome,
    children:[
      {
        path: ':id',
        name: 'sku',
        component: SKU
      }
    ]
  },
  // {
  //   path: '/about',
  //   name: 'about',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  // }
]

const router = new VueRouter({
  routes,
  mode:"hash"
})

export default router
