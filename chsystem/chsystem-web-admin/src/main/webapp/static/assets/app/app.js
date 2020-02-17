var App = function () {


    //ICheck
    var _masterCheckbox;
    var _checkbox;

    //用于存放 ID 的数组
    var _idArray;
    /**
     * 私有方法,初始化 ICheck
     */
    var handlerInitCheckbox = function () {
        //激活
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        });
        //获取控制端 Checkbox
        _masterCheckbox = $('input[type="checkbox"].minimal.icheck_master');

        //获取全部 Checkbox 集合
        _checkbox = $('input[type="checkbox"].minimal');

    };

    /**
     * Checkbox 全选功能
     */
    var handlerCheckboxAll = function () {
        _masterCheckbox.on("ifClicked",function (e) {
            //返回 true 表示未选中
            if (e.target.checked){
                _checkbox.iCheck("uncheck");
            }

            //选中状态
            else {
                _checkbox.iCheck("check");
            }
        });



    };

    /**
     * 批量删除
     */
    var handlerDeleteMulti = function (url) {
        _idArray = new Array();
        //将选中元素的 ID 放入数组中
        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id  != null && _id  != 'undefine' && $(this).is(":checked") ) {
                _idArray.push(_id);
            }
        });

        if (_idArray.length === 0){
            $("#modal-message").html("您还没有选择任何数据项，请至少选择一项")
        }

        else {
            $("#modal-message").html("确定要删除这些用户吗？")
        }

        $("#modal-default").modal("show");

        $("#btnModalOk").bind("click",function () {
            del();
        });

        /**
         * 当前私有函数的私有函数,删除数据
         */
        function del() {

            $("#modal-default").modal("hide");
            //如果没有选择数据项的处理
            if (_idArray.length === 0){

            }
            //删除操作
            else {
                setTimeout(function () {
                    $.ajax({
                        "url": url,
                        "type": "POST",
                        "data": {"ids": _idArray.toString()},
                        "dataType": "JSON",
                        "success": function (data) {
                            //删除成功
                            if (data.status === 200){
                                window.location.reload();
                            }

                            //删除失败
                            else {
                                $("#btnModalOk").unbind("click");
                                $("#btnModalOk").bind("click",function () {
                                    $("#modal-default").modal("hide");
                                });
                                $("#modal-message").html(data.message);
                                $("#modal-default").modal("show");

                            }
                        }
                    })

                }, 500);
            }

        }
    };


    /**
     * 初始化 DataTables
     */
    var hanlerInitDataTables = function (url, columns) {
        $('#dataTable').DataTable({
            "paging": true,
            "info": true,
            "lengthChange": false,
            "ordering": false,
            "processing": true,
            "searching": false,
            "serverSide": true,
            "deferRender": true,
            "ajax": {
                "url": url
            },
            "columns": columns ,
            // 表格重绘的回调函数
            "drawCallback": function (settings) {
                handlerInitCheckbox();
                handlerCheckboxAll();
            },
            // 国际化
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            }
        })

    }



    return{

        init:function(){
            handlerInitCheckbox();
            handlerCheckboxAll();
        },


        getCheckbox: function () {
            return _checkbox;
        },

        deleteMultu: function (url) {
            handlerDeleteMulti(url)
        },

        initDataTables: function (url, columns) {
            hanlerInitDataTables(url, columns)
        }

    }

}();




$(document).ready(function () {
   App.init();
});