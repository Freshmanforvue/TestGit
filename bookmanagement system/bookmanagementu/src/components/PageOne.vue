<template>
    <div>
    <el-table
            :data="tableData"
            border

            style="width: 100%">

        <el-table-column
                fixed
                prop="id"
                label="编号"
                width="100"
        align="center">
        </el-table-column>
        <el-table-column
        prop="bookname"
        label="书名"
        width="250"
        align="center">
        </el-table-column>
        <el-table-column
                prop="author"
                label="作者"
                width="250"
                align="center">
        </el-table-column>
        <el-table-column
                prop="price"
                label="价格(元)"
                width="120"
                align="center">
        </el-table-column>
        <el-table-column
                fixed="right"
                label="操作"
                width="100"
                align="center">
            <template slot-scope="scope">
                <el-button @click="handleClick(scope.row)" type="text" size="small">修改</el-button>
                <el-button @click="deleted(scope.row)" type="text" size="small">删除</el-button>
            </template>
        </el-table-column>
    </el-table>
    <el-pagination class="el-pagination"
            background
            layout="prev, pager, next"
            :page-size="pageSize"
            @current-change="page"
            :total="total">
    </el-pagination>
    </div>
</template>

<script>
    export default {
        methods: {
            deleted(row){
               const  ithis=this;
                console.log(row.id);
                console.log(ithis);
                this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    ithis.$axios({
                        url:'/books/delete/'+row.id,
                        method: 'post'//请求的方式
                    }).then(function (resp) {
                        if(resp.data=='success!'){
                            ithis.$message({
                                type: 'success',
                                message: '删除成功!'
                            });
                            window.location.reload();
                        }
                    })
                }).catch(() => {
                    ithis.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });

            },
            handleClick(row) {
                console.log(row.id);
                this.$router.push({  path:'/PageThree',
                    query:{
                    id:row.id
                    }}
                  );
            },
            page(a) {
                const ithis=this;
                ithis.$axios({
                    url:'/books/findAll/'+(a)+'/7',
                    method: 'get'//请求的方式
                }).then(function (resp) {
                   // console.log(resp.data);
                    ithis.tableData=resp.data;
                   // ithis.pageSize=resp.data.length;

                })
            }
        },

        data() {

            return {
                pageSize:3,
                total:30,
                tableData: [{
                    id: ' ',
                    bookname: ' ',
                    author: ' ',
                    price: ' ',

                }, {
                    id: ' ',
                    bookname: ' ',
                    author: ' ',
                    price: ' ',

                }, {
                    id: ' ',
                    bookname: ' ',
                    author: ' ',
                    price: ' ',

                }, {
                    id: ' ',
                    bookname: ' ',
                    author: ' ',
                    price: ' ',

                }]
            }
        }
        ,
        created() {
         const  ithis=this;
         ithis.$axios({
             url:'/books/see',
             method: 'get'//请求的方式
         }).then(function (resp) {
             //console.log(resp.data);


             ithis.total=resp.data.length;
             console.log(resp.data.length);

         }),
    ithis.$axios({
    url:'/books/findAll/1/7',
    method: 'get'//请求的方式
}).then(function (resp) {
//console.log(resp.data);
ithis.tableData=resp.data;
ithis.pageSize=resp.data.length;

})
        }
    }
</script>

<style scoped>
.el-pagination{
    background-color: white;
    height: 54px;
    border: 0 solid rgb(210, 210, 210);
    border-top-width: 1px;
    position: fixed;
    margin: auto;
    bottom: 0;
    width: 100%;
}
</style>