import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'



import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI);

import {getRequest,postRequest,deleteRequest,putRequest} from "@/utils/api";
import axios from "axios";

Vue.prototype.getRequest=getRequest
Vue.prototype.postRequest=postRequest
Vue.prototype.deleteRequest=deleteRequest
Vue.prototype.putRequest=putRequest

Vue.config.productionTip = false





axios.defaults.baseURL="http://192.168.183.1:8090"

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
