<template>
    <el-container style="height: 500px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <!-- <el-menu :default-openeds="['1', '3']">
               <el-submenu index="1">
                 <template slot="title"><i class="el-icon-message"></i>导航一</template>

                   <el-menu-item index="1-1">选项1</el-menu-item>
                   <el-menu-item index="1-2">选项2</el-menu-item>


                   <el-menu-item index="1-3">选项3</el-menu-item>

                 <el-submenu index="1-4">
                   <template slot="title">选项4</template>
                   <el-menu-item index="1-4-1">选项4-1</el-menu-item>
                 </el-submenu>
               </el-submenu>
               <el-submenu index="2">
                 <template slot="title"><i class="el-icon-menu"></i>导航二</template>

                   <el-menu-item index="2-1">选项1</el-menu-item>
                   <el-menu-item index="2-2">选项2</el-menu-item>


                   <el-menu-item index="2-3">选项3</el-menu-item>

                 <el-submenu index="2-4">
                   <template slot="title">选项4</template>
                   <el-menu-item index="2-4-1">选项4-1</el-menu-item>
                 </el-submenu>
               </el-submenu>

             </el-menu>-->
            <el-menu router :default-openeds="['0','1']">
                <el-submenu v-for="(item,index) in $router.options.routes" v-bind:key="item.index" :index="index+''" >
                    <template slot="title" v-if="item.show"><i class="el-icon-message" ></i>{{item.name}}</template>
                    <el-menu-item v-for="item2 in item.children" v-bind:key="item2.name" :index="item2.path" :class="$route.path==item2.path?'is-active':''" >
                    <template v-if="item.show">
                        {{item2.name}}</template>
                    </el-menu-item>
                </el-submenu>
            </el-menu>
        </el-aside>
<!--        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <el-dropdown>
                    <i class="el-icon-setting" style="margin-right: 15px"></i>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>查看</el-dropdown-item>
                        <el-dropdown-item>新增</el-dropdown-item>
                        <el-dropdown-item>删除</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
                <span>王小虎</span>
            </el-header>
        < /el-container>-->
            <el-main>
<router-view></router-view>
            </el-main>

    </el-container>
</template>

<script>
    export default {
        name: ""
    }
</script>

<style scoped>

</style>