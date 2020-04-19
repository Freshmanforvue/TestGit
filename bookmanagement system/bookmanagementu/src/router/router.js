import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)
import PageOne from "@/components/PageOne"
import PageTwo from "@/components/PageTwo"
import PageThree from "@/components/PageThree"
import PageFour from "@/components/PageFour"

import index from "@/components/index"
export default  new VueRouter(
    {
        routes:[
            {path:'/',redirect:'PageOne',name:'图书管理',component:index,show:true,
            children:[ {path:'/PageOne',name:'图书查询',component:PageOne },
                {path:'/PageTwo',name:'图书添加',component:PageTwo }]},
            {path:'/navigator',name:'导航二',component:index,show:false,
                children:[ {path:'/PageThree',name:'页面3',component:PageThree},
                    {path:'/PageFour',name:'页面4',component:PageFour }]},

        ],
        mode:'history'
    }


)