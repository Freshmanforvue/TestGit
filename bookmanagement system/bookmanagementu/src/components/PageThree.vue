<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

        <el-form-item label="图书编号" >
            <el-input v-model="ruleForm.id"  readonly></el-input>
        </el-form-item>
        <el-form-item label="图书名称" prop="bookname">
            <el-input v-model="ruleForm.bookname"></el-input>
        </el-form-item>
        <el-form-item label="作者" prop="author">
            <el-input v-model="ruleForm.author"></el-input>
        </el-form-item>
        <el-form-item label="价格" prop="price">
            <el-input v-model="ruleForm.price"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {
                    id:'',
                    bookname: '',
                    price: '',
                    author: '',

                },
                rules: {
                    bookname: [
                        { required: true, message: '请输入图书名称', trigger: 'blur' }

                    ],
                    author: [
                        { required: true, message: '请输入作者姓名', trigger: 'blur' }
                    ],
                    price: [
                        {required: true, message: '请输入图书价格', trigger: 'blur' }
                    ]

                }
            };
        },
        methods: {
            submitForm(formName) {
                //const ithis=this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$axios({
                            url: '/books/update',//请求的地址
                            method: 'post',//请求的方式
                            data: this.ruleForm//请求的表单数据
                        }).then(res => {
                            // console.info('后台返回的数据', res);
                            console.log(res);
                            if(res.data=='success!'){

                                this.$alert('修改成功！', '消息提示', {
                                    confirmButtonText: '确定',
                                    callback: action => {

                                        console.log(action);
                                        this.$router.push('/PageOne');
                                    }
                                });
                            }

                        }).catch(err => {
                            console.info('报错的信息', err.response.message);
                        });
                        //console.log(this.ruleForm)

                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        },
        created(){

          const ithis=this;
          this.$axios({
              url:'/books/retrieve/'+this.$route.query.id,
              method: 'get'//请求的方式
          }).then(function (resp) {
console.log(resp.data);
              ithis.ruleForm=resp.data;

          })
        }
    }
</script>

<style scoped>

</style>