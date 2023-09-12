<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Wellcome: ${sessionScope.name}</h1>
        <button onclick="window.location = 'login.jsp'" > Logout</button>
        <form>
            <div>
                <input name="search" type="text" placeholder="Search by id"/>
                <button type="submit" value="Search" name="action">Search</button>
            </div>
        </form>
        <form>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>PRICE</th>
                        <th>SIZE</th>
                        <th>DESCRIPTION<th> 
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="f" items="${sessionScope.flist}">
                    <tr>
                        <td>${f.getID()}</td>
                        <td>${f.getName()}</td> 
                        <td>${f.getPrice()}</td>
                        <td>${f.getSize()}</td>
                        <td>${f.getDescription()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
    </body>
</html>
