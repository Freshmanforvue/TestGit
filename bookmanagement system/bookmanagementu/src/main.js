import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from './router/router'
import axios from 'axios'

//axios.defaults.baseURL = 'http://localhost:8081'
Vue.prototype.$axios = axios
import VueRouter from 'vue-router'

Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(VueRouter)
new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
