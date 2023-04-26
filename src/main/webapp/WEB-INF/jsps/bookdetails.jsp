<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container" align="center">
    <%@include file="commons/header.jspf"%>
    <%@include file="commons/navigations.jspf"%>

   
<head>
        <link href="search.css" rel="stylesheet">
    </head>

<div class="container search-table">
    <div class="search-box">
        <div class="row">
            <div class="col-md-3">
                <h5>Search All Fields</h5>
            </div>
            <div class="col-md-9">
                <input type="text" id="myInput" onkeyup="myFunction()" class="form-control" placeholder="Search your book name">
                <script>
                    $(document).ready(function () {
                        $("#myInput").on("keyup", function () {
                            var value = $(this).val().toLowerCase();
                            $("#myTable tr").filter(function () {
                                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                            });
                        });
                    });
                </script>
            </div>
        </div>
    </div>
    <div class="search-list">
        <h6>Select Book</h6>
    <table class="table" id="myTable">
            <thead>
            <tr>
                <th>Title</th>
                <th>Author</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${searchbook}" var="book">
            <tr>
                <td>${book.book_name}</td>
                <td>${book.book_authors }</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>
<%@include file="commons/footer.jspf"%>
