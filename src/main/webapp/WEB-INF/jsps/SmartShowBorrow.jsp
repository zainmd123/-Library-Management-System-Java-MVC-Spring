<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container" align="center">


    <%@include file="commons/header.jspf"%>
    <%@include file="commons/navigations.jspf"%>
    <div>
        <%--      <h3>List Of All books has been shown here </h3>--%>

        <%--        ${listofbooks}--%>
            <h2>${success}</h2>

        <section id="tabs" class="project-tab">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <nav>
                            <div  id="nav-tab" role="tablist" align="center">
                                <h4> <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Borrow Book Details</a></h4>

                            </div>
                        </nav>
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">


                                <table class="table" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>User Name</th>
                                        <th>Book</th>
                                        <th>Date of Borrow</th>
                                        <th>Date of Return</th>
                                        <th>Return</th>
                                        <%--<th>Return</th>--%>

                                    </tr>

                                    </thead>

                                    <tbody>
                                    <c:forEach items="${listEntries}" var="entry">
                                        <tr>

                                            <td>${entry.userName}</td>
                                            <td>${entry.bookName}</td>
                                            <c:set var = "now" value = "<%= new java.util.Date()%>" />
                                            <td><fmt:formatDate value="${now}" pattern="YYYY-MM-dd"></fmt:formatDate> </td>
                                            <td><fmt:formatDate value="${entry.dateOfReturn}" pattern="YYYY-MM-dd"></fmt:formatDate> </td>
                                            <td><a href="/set-returndate?id=${entry.id}" class="btn btn-success"> Return</a> </td>
                                            <%--<td><input type="date" class="date-picker date-picker-popup" required="please select date" name="dateofreturn"></td>--%>


                                            <td><a href="/del-smartbs?id=${entry.id}" class="btn btn-outline-danger">Remove</a></td>
                                        </tr>
                                    </c:forEach>


                                    </tbody>
                                </table>

                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <a href="/sml-main" class="btn btn-success">Add New Entry</a>
            </section>
    </div>
    <%@include file="commons/footer.jspf"%>
</div>
