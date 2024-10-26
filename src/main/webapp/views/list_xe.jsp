<%@ page import="vn.edu.iuh.fit.frontend.dto.XeDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xe</title>
</head>
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
        text-align: center;
    }
</style>
<body>
<h1 style="text-align: center;">Cửa hàng Bán Xe Gắn Máy</h1>
<div style="display: flex;flex-direction: row">
    <a style="margin-right: 5px" href="controller?action=list_xe">Danh sách Xe</a> <span>|</span> <a style="margin-left: 5px" href="controller?action=add_xe">Thêm Xe</a>
</div>
<div style="display: flex;justify-content: flex-end;align-items: center;margin-bottom: 10px">
    <form action="controller" method="get">
        <input type="hidden" name="action" value="search_xe">
    <input type="text" name="timkiem"/>
    <button type="submit"    >Tìm kiếm</button>
    </form>
</div>

<table style="width:100%">
    <tr>
        <th>Mã xe</th>
        <th>Tên xe</th>
        <th>Giá xe</th>
        <th>Năm SX</th>
        <th>Hãng Xe</th>
    </tr>
    <%
        List<XeDTO> listXe = (List<XeDTO>) request.getAttribute("xes");
        if (listXe == null) {   %>
            <tr>
                <td colspan="5">Không có dữ liệu</td>
            </tr>
        <% } else {
            for (XeDTO xe : listXe) { %>
                <tr>
                    <td><%= xe.getId() %></td>
                    <td><%= xe.getTenxe() %></td>
                    <td><%= xe.getGiaXe() %></td>
                    <td><%= xe.getNamsanxuat() %></td>
                    <td><%= xe.getTenhangxe() %></td>
                </tr>
            <% }
} %>



</table>

<hr  style=" color: black ;height: 5px;width: 100%" />
<h2 style="text-align: center">LeMinhThat_21086061_SoMay</h2>
</body>
</html>
