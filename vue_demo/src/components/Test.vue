<template>
  <div id="app">
    <template>
    <el-table
      :data="tableData"
      stripe
      style="width: 100%"
      @selection-change="selectionChange"
    >
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column prop="id" label="ID" width="180"> </el-table-column>
      <el-table-column prop="name" label="姓名" width="180"> </el-table-column>
      <el-table-column prop="sex" label="性别"> </el-table-column>
      <el-table-column prop="tell" label="电话"> </el-table-column>
      <el-table-column prop="addr" label="地址"> </el-table-column>
    </el-table>
    </template>
    <!-- 分页 -->
        <el-pagination v-if="page.total>page.size" background layout="prev, pager, next" @current-change="handleCurrentChange"
            :page-size="page.size" :current-page="page.current" :total="page.total">
        </el-pagination>
  </div>
</template>
<script>
export default {
  name: "app",
  data() {
    return {
      tableData: [],
      page: {
        current: 1,
        size: 2,
        total: 0,
      },
      idList: [],
    };
  },
  // 页面初始话的时候调用
  created() {
    this.getData();
  },
  methods: {
    //通过axios请求服务器，获取数据
    getData() {
      let that = this;
      let url =
        "http://localhost:8081/customer/selesctAll?size=" +
        that.page.size +
        "&&current=" +
        that.page.current;
      that.axios.get(url).then(
        (rs) => {
          // console.log(rs.data);
          // console.log(rs.data.data.records);
          // console.log(rs.data.data.total);
          that.tableData = rs.data.data.records;
          that.page.total = rs.data.data.total;
          // console.log(that.page.size);
          // console.log(that.page.total);
        },
        (rs) => {
          console.log("error");
        }
      );
    },
    //分页点击事件
    handleCurrentChange(current) {
      this.page.current = current;
      this.getData();
    },
    // 行选择触发事件
    selectionChange(selection) {
      this.idList = [];
      selection.forEach((element) => {
        this.idList.push(element.id);
      });
      console.log(this.idList);
    },
  },
};
</script>
