<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <%--bootstrap核心css--%>
    <link rel="stylesheet" href="${cp}/boot/css/bootstrap.min.css">
    <!--jqGrid-->
    <%--表格样式--%>
    <%--<link rel="stylesheet" href="${cp}/jqGrid/cs">--%>
    <link rel="stylesheet" href="${cp}/jqGrid/css/trirand/ui.jqgrid-bootstrap.css">
    <!--jquery.js-->
    <script src="${cp}/boot/js/jquery-3.3.1.min.js"></script>
    <!--bootstrap.js-->
    <script src="${cp}/boot/js/bootstrap.min.js"></script>
    <!--国际化-->
    <script src="${cp}/jqGrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <!--jqGrid核心js-->
    <script src="${cp}/jqGrid/js/trirand/jquery.jqGrid.min.js"></script>


    <script type="text/javascript">

        $(function () {

            $("#list").jqGrid({
                url: "${cp}/user/queryAll",//分页访问路径
                editurl: "${cp}/user/edit",//表单请求路径  oper=add 添加  oper=edit 修改 oper=del 删除
                styleUI: "Bootstrap",//设置引入样式必须设置的属性
                datatype: "json",//返回数据类型
                autowidth: true, //设置表单适应父容器
                viewrecords: true, //是否显示总条数
                caption: "员工表",  //设置表单名称
                toolbar: [true, "top"], //显示工具栏

                colNames: [
                    "ID", "名字", "年龄", "性别", "生日", "部门"
                ],
                colModel: [
                    {name: "id"},
                    {name: "username", editable: true},
                    {
                        name: "age", edittype: 'number', editable: true, editrules: {
                            number: true, minValue: 10, maxValue: 100, required: true
                        }
                    },
                    {name: "sex", editable: true},
                    {name: "birthday", editable: true, edittype: 'date'},
                    {
                        name: "department", editable: true, edittype: "select", editoptions: {
                            value: "保卫部:保卫部;研发部:研发部"
                        }
                    },
                ],
                ondblClickRow: function (rowid, iRow, iCol, e) {
                    console.log(rowid);
                    console.log(iRow);
                    console.log(iCol);
                    console.log(e);
                }
            })
        });
    </script>

</head>
<body>
<div>
    <table id="list"></table>

    <form action="${pageContext.request.contextPath}/user/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file"> <br>
        <input type="submit" value="上传">
    </form>

</div>
</body>
</html>
