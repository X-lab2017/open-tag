<template>
  <a-spin :spinning="confirmLoading">
    <j-form-container :disabled="formDisabled">
      <!-- 主表单区域 -->
      <a-form-model ref="form" :model="model" :rules="validatorRules" slot="detail">
        <a-row>
          <a-col :span="24" >
            <a-form-model-item label="标签对象id" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="actorId">
              <a-input v-model="model.actorId" placeholder="请输入标签对象id" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="标签对象姓名" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="actorName">
              <a-input v-model="model.actorName" placeholder="请输入标签对象姓名" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="标签对象类别标签" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="actorClass">
              <j-dict-select-tag type="radio" v-model="model.actorClass" dictCode="bot_lable_class" placeholder="请选择标签对象类别标签" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="标签对象标签是否难打" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="actorDifficult">
              <j-dict-select-tag type="radio" v-model="model.actorDifficult" dictCode="bot_lable_difficulty" placeholder="请选择标签对象标签是否难打" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24" >
            <a-form-model-item label="标签对象是否是机器人" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="actorBot">
              <j-dict-select-tag type="radio" v-model="model.actorBot" dictCode="bot_lable_bot" placeholder="请选择标签对象是否是机器人" />
            </a-form-model-item>
          </a-col>
        </a-row>
      </a-form-model>
    </j-form-container>
      <!-- 子表单区域 -->
    <a-tabs v-model="activeKey" @change="handleChangeTabs">
      <a-tab-pane tab="机器人标签结果" :key="refKeys[0]" :forceRender="true">
        <j-vxe-table
          keep-source
          :ref="refKeys[0]"
          :loading="datasourceBotLableTable.loading"
          :columns="datasourceBotLableTable.columns"
          :dataSource="datasourceBotLableTable.dataSource"
          :maxHeight="300"
          :disabled="formDisabled"
          :rowNumber="true"
          :rowSelection="true"
          :toolbar="true"
          />
      </a-tab-pane>
    </a-tabs>
  </a-spin>
</template>

<script>

  import { getAction } from '@/api/manage'
  import { JVxeTableModelMixin } from '@/mixins/JVxeTableModelMixin.js'
  import { JVXETypes } from '@/components/jeecg/JVxeTable'
  import { getRefPromise,VALIDATE_FAILED} from '@/components/jeecg/JVxeTable/utils/vxeUtils.js'
  import { validateDuplicateValue } from '@/utils/util'
  import JFormContainer from '@/components/jeecg/JFormContainer'

  export default {
    name: 'DatasourceBotForm',
    mixins: [JVxeTableModelMixin],
    components: {
      JFormContainer,
    },
    data() {
      return {
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },
        model:{
         },
        // 新增时子表默认添加几行空数据
        addDefaultRowNum: 1,
        validatorRules: {
        },
        refKeys: ['datasourceBotLable', ],
        tableKeys:['datasourceBotLable', ],
        activeKey: 'datasourceBotLable',
        // 机器人标签结果
        datasourceBotLableTable: {
          loading: false,
          dataSource: [],
          columns: [
            {
              title: '创建人',
              key: 'createBy',
               type: JVXETypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
            },
            {
              title: '更新人',
              key: 'updateBy',
               type: JVXETypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
            },
            {
              title: '是否是机器人',
              key: 'botLableBot',
              type: JVXETypes.select,
              options:[],
              dictCode:"bot_lable_bot",
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
            },
            {
              title: '机器人类别',
              key: 'botLableClass',
              type: JVXETypes.select,
              options:[],
              dictCode:"bot_lable_class",
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
            },
            {
              title: '是否难打',
              key: 'botLableDifficult',
              type: JVXETypes.select,
              options:[],
              dictCode:"bot_lable_difficulty",
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
            },
            {
              title: '标签对象',
              key: 'actorId',
               type: JVXETypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
            },
          ]
        },
        url: {
          add: "/datasource/datasourceBot/add",
          edit: "/datasource/datasourceBot/edit",
          queryById: "/datasource/datasourceBot/queryById",
          datasourceBotLable: {
            list: '/datasource/datasourceBot/queryDatasourceBotLableByMainId'
          },
        }
      }
    },
    props: {
      //表单禁用
      disabled: {
        type: Boolean,
        default: false,
        required: false
      }
    },
    computed: {
      formDisabled(){
        return this.disabled
      },
    },
    created () {
    },
    methods: {
      addBefore(){
        this.datasourceBotLableTable.dataSource=[]
      },
      getAllTable() {
        let values = this.tableKeys.map(key => getRefPromise(this, key))
        return Promise.all(values)
      },
      /** 调用完edit()方法之后会自动调用此方法 */
      editAfter() {
        this.$nextTick(() => {
        })
        // 加载子表数据
        if (this.model.id) {
          let params = { id: this.model.id }
          this.requestSubTableData(this.url.datasourceBotLable.list, params, this.datasourceBotLableTable)
        }
      },
      //校验所有一对一子表表单
        validateSubForm(allValues){
            return new Promise((resolve,reject)=>{
              Promise.all([
              ]).then(() => {
                resolve(allValues)
              }).catch(e => {
                if (e.error === VALIDATE_FAILED) {
                  // 如果有未通过表单验证的子表，就自动跳转到它所在的tab
                  this.activeKey = e.index == null ? this.activeKey : this.refKeys[e.index]
                } else {
                  console.error(e)
                }
              })
            })
        },
      /** 整理成formData */
      classifyIntoFormData(allValues) {
        let main = Object.assign(this.model, allValues.formValue)
        return {
          ...main, // 展开
          datasourceBotLableList: allValues.tablesValue[0].tableData,
        }
      },
      validateError(msg){
        this.$message.error(msg)
      },

    }
  }
</script>

<style scoped>
</style>