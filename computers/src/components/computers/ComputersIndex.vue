<template>
    <el-container>
        <el-main>
            <computer class="computer-area"></computer>
        </el-main>
    </el-container>
</template>

<script>
import computer from './computer'
export default {
    name:'AppComputers',
    components:{computer}
}
</script>
<style scoped>
.computer-area{
    width:990px;
    margin-left: 0px;
    margin-right: auto;
}
</style>