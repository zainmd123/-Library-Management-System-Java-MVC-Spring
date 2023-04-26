<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <%@include file="commons/header.jspf"%>
    <%@include file="commons/navigations.jspf"%>
    <h5><a href="/wishList"> Click For Back</a></h5>
    <head>
        <link href="AddBook.css" rel="stylesheet">
    </head>

    <div align="center">

        <section class="get-in-touch">
            <h1 class="title">Add New Book Here</h1>
            
    <form:form method="post" modelAttribute="wishlist" cssClass="contact-form row">
    
     <div class="form-field col-lg-6">
     	<form:label path="bookName" cssClass="lable">Enter Book name:</form:label>
	    <form:input type="text" path="bookName" placeholder="Book title" ></form:input>
	</div>
	

					
				<button type="submit" class="btn btn-light"> Save Book to wishlist</button>
         <%-- <div class="form-field col-lg-6">
          <form:label path="book_published" >Enter Publish Date: </form:label>
          <form:input path="book_published" type="date" required="required" cssClass="input-text js-input"/>
         </div> --%>
         
        <%-- <div class="form-field col-lg-12">
            <input class="submit-btn" type="submit" value="Add Book">
        </div>--%>

    </form:form>
        </section>


        <%@include file="commons/footer.jspf"%>
    </div>
</div>
