import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import {JVxeTypes,JVxeColumn} from '/@/components/jeecg/JVxeTable/types'
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '标签对象id',
    align:"center",
    dataIndex: 'actorId'
   },
   {
    title: '标签对象姓名',
    align:"center",
    dataIndex: 'actorName'
   },
   {
    title: '标签对象类别标签',
    align:"center",
    dataIndex: 'actorClass_dictText'
   },
   {
    title: '标签对象标签是否难打',
    align:"center",
    dataIndex: 'actorDifficult_dictText'
   },
   {
    title: '标签对象是否是机器人',
    align:"center",
    dataIndex: 'actorBot_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '标签对象id',
    field: 'actorId',
    component: 'Input',
  },
  {
    label: '标签对象姓名',
    field: 'actorName',
    component: 'Input',
  },
  {
    label: '标签对象类别标签',
    field: 'actorClass',
    component: 'JSelectMultiple',
    componentProps:{
        dictCode:"bot_lable_class"
     },
  },
  {
    label: '标签对象标签是否难打',
    field: 'actorDifficult',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"bot_lable_difficulty"
     },
  },
  {
    label: '标签对象是否是机器人',
    field: 'actorBot',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"bot_lable_bot"
     },
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];
//子表单数据
//子表表格配置
export const datasourceBotLableColumns: JVxeColumn[] = [
    {
      title: '创建人',
      key: 'createBy',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '更新人',
      key: 'updateBy',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '是否是机器人',
      key: 'botLableBot',
      type: JVxeTypes.select,
      options:[],
      dictCode:"bot_lable_bot",
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '机器人类别',
      key: 'botLableClass',
      type: JVxeTypes.select,
      options:[],
      dictCode:"bot_lable_class",
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '是否难打',
      key: 'botLableDifficult',
      type: JVxeTypes.select,
      options:[],
      dictCode:"bot_lable_difficulty",
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '标签对象',
      key: 'actorId',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
  ]


/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
// 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}