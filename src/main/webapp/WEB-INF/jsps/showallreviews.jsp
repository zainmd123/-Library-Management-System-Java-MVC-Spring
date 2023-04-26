
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container" align="center">
    <%@include file="commons/header.jspf"%>
    <%@include file="commons/navigations.jspf"%>
    <div>
  <%--      <h3>List Of All books has been shown here </h3>--%>

<%--        ${listofbooks}--%>

            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <nav>
                            <div  id="nav-tab" role="tablist" align="center">
                               <h4> <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">List of Reviews</a></h4>

                            </div>
                        </nav>
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">


                                <table class="table" cellspacing="0">
                                    <thead>
                                    <tr>
                                    	<th>ID</th>
                                        <th>Book Title</th>
                                        <th>Description</th>

                                    </tr>

                                    </thead>

                                    <tbody>
                                    <c:forEach items="${listReviews}" var="review">
                                    <tr>

                                        <td><a href="#">${review.id}</a></td>
                                        <td>${review.title}</td>
                                        <td>${review.description}</td>
                                        <td><a href="/edit-review?id=${review.id}" class="btn btn-dark">Edit</a></td>
                                        <td><a href="/delete-review?id=${review.id}" class="btn btn-danger">Delete</a></td>

                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <a href="/showReviewform" class="btn btn-success">Add New Review</a>
    </div>

<%@include file="commons/footer.jspf"%>
</div>