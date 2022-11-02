<template>
  <a-spin :spinning="loading">
    <a-form v-bind="formItemLayout">
      <a-row>
        <a-col :span="24">
          <a-form-item label="标签对象id" v-bind="validateInfos.actorId">
            <a-input v-model:value="formData.actorId" placeholder="请输入标签对象id" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="标签对象姓名" v-bind="validateInfos.actorName">
            <a-input v-model:value="formData.actorName" placeholder="请输入标签对象姓名" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="标签对象类别标签" v-bind="validateInfos.actorClass">
            <j-dict-select-tag type='radio' v-model:value="formData.actorClass" dictCode="bot_lable_class" placeholder="请选择标签对象类别标签" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="标签对象标签是否难打" v-bind="validateInfos.actorDifficult">
            <j-dict-select-tag type='radio' v-model:value="formData.actorDifficult" dictCode="bot_lable_difficulty" placeholder="请选择标签对象标签是否难打" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="标签对象是否是机器人" v-bind="validateInfos.actorBot">
            <j-dict-select-tag type='radio' v-model:value="formData.actorBot" dictCode="bot_lable_bot" placeholder="请选择标签对象是否是机器人" :disabled="disabled"/>
          </a-form-item>
        </a-col>
      </a-row>
    </a-form>

		<!-- 子表单区域 -->
    <a-tabs v-model:activeKey="activeKey">
      <a-tab-pane tab="机器人标签结果" key="datasourceBotLable" :forceRender="true">
        <j-vxe-table
          :keep-source="true"
          ref="datasourceBotLableTableRef"
          :loading="datasourceBotLableTable.loading"
          :columns="datasourceBotLableTable.columns"
          :dataSource="datasourceBotLableTable.dataSource"
          :maxHeight="300"
          :disabled="formDisabled"
          :rowNumber="true"
          :rowSelection="true"
          :toolbar="true"/>
      </a-tab-pane>
    </a-tabs>
  </a-spin>
</template>

<script lang="ts">
  import { defineComponent, ref, reactive, computed, toRaw } from 'vue';
  import { useValidateAntFormAndTable } from '/@/hooks/system/useJvxeMethods';
  import { queryDatasourceBotLableListByMainId, queryDataById, saveOrUpdate } from '../DatasourceBot.api';
  import { JVxeTable } from '/@/components/jeecg/JVxeTable';
  import {datasourceBotLableColumns} from '../DatasourceBot.data';
  import JDictSelectTag from '/@/components/Form/src/jeecg/components/JDictSelectTag.vue';
  import { Form } from 'ant-design-vue';
  const useForm = Form.useForm;

  export default defineComponent({
    name: "DatasourceBotForm",
    components:{
      JDictSelectTag,
      JVxeTable,
    },
    props:{
      disabled:{
        type: Boolean,
        default: false
      }
    },
    emits:['success'],
    setup(props, {emit}) {
      const loading = ref(false);
      const datasourceBotLableTableRef = ref();
      const datasourceBotLableTable = reactive<Record<string, any>>({
        loading: false,
        columns: datasourceBotLableColumns,
        dataSource: []
      });
      const activeKey = ref('datasourceBotLable');
      const formData = reactive<Record<string, any>>({
        id: '',
        actorId: '',
        actorName: '',
        actorClass: '',
        actorDifficult: '',
        actorBot: '',
      });

      //表单验证
      const validatorRules = reactive({
      });
      const {resetFields, validate, validateInfos} = useForm(formData, validatorRules, {immediate: true});
      const dbData = {};
      const formItemLayout = {
        labelCol: {xs: {span: 24}, sm: {span: 5}},
        wrapperCol: {xs: {span: 24}, sm: {span: 16}},
      };

      const formDisabled = computed(() => {
        return props.disabled;
      });

      function add() {
        resetFields();
        datasourceBotLableTable.dataSource = [];
      }

      async function edit(row) {
        //主表数据
        await queryMainData(row.id);
        //子表数据
        const datasourceBotLableDataList = await queryDatasourceBotLableListByMainId(row['actorId']);
        datasourceBotLableTable.dataSource = [...datasourceBotLableDataList];
      }

      async function queryMainData(id) {
        const row = await queryDataById(id);
        Object.keys(row).map(k => {
          formData[k] = row[k];
        });
      }

      const {getSubFormAndTableData, transformData} = useValidateAntFormAndTable(activeKey, {
        'datasourceBotLable': datasourceBotLableTableRef,
      });

      async function getFormData() {
        await validate();
        return transformData(toRaw(formData))
      }

      async function submitForm() {
        const mainData = await getFormData();
        const subData = await getSubFormAndTableData();
        const values = Object.assign({}, dbData, mainData, subData);
        console.log('表单提交数据', values)
        const isUpdate = values.id ? true : false
        await saveOrUpdate(values, isUpdate);
        //关闭弹窗
        emit('success');
      }
      
      function setFieldsValue(values) {
        if(values){
          Object.keys(values).map(k=>{
            formData[k] = values[k];
          });
        }
      }

      /**
       * 值改变事件触发-树控件回调
       * @param key
       * @param value
       */
      function handleFormChange(key, value) {
        formData[key] = value;
      }


      return {
        datasourceBotLableTableRef,
        datasourceBotLableTable,
        validatorRules,
        validateInfos,
        activeKey,
        loading,
        formData,
        setFieldsValue,
        handleFormChange,
        formItemLayout,
        formDisabled,
        getFormData,
        submitForm,
        add,
        edit
      }
    }
  });
</script>