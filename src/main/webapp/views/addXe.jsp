<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Xe</title>
</head>
<body>
<h1>Thêm Xe Mới</h1>
<form action="controller" method="post">
    <input type="hidden" name="action" value="add_xe">
    <label for="maxe">Mã Xe:</label>
    <input type="text" id="maxe" name="maxe" required><br>
    <label for="tenxe">Tên Xe:</label>
    <input type="text" id="tenxe" name="tenxe" required><br>
    <label for="giaxe">Giá Xe:</label>
    <input type="text" id="giaxe" name="giaxe" required><br>
    <label for="namsanxuat">Năm Sản Xuất:</label>
    <input type="text" id="namsanxuat" name="namsanxuat" required><br>
    <label for="tenhangxe">Tên Hãng Xe:</label>
    <input type="text" id="tenhangxe" name="tenhangxe" required><br>
    <button type="submit">Thêm Xe</button>
</form>
</body>
</html>