<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()
%>/resources/css/style.css">
</head>
<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
<div id="formProd" class="cadre">
<f:form modelAttribute="produit" action="saveProd"	method="post" enctype="multipart/form-data">
<table>
<tr>
<td>ID Produit:</td>
<td>${produit.idProduit}<f:input type="hidden" path="idProduit"/></td>
<td><f:errors path="idCategorie"></f:errors> </td>
</tr>
<tr>
<td>Nom Produit</td><td><f:input path="nomProduit"/></td>
<td><f:errors path="nomProduit"></f:errors> </td>
</tr>
<tr>
<td>Description</td>
<td><f:textarea path="description"/></td>
<td><f:errors path="description"></f:errors> </td>
</tr>
<tr>
<td>Photo</td>
<c:if test="${produit.idProduit!=null}">
<td><img src="photoCat?idCat=${produit.idProduit}"></td>
</c:if>
<td>
<input type="file" name="file"></td>
</tr>
<tr>
<td><input type="submit" value="Save"></td>
</tr>
</table>
</f:form>
</div>
<div id="tabProduits" class="cadre">
<table class="tabStyle1">
<tr>
<th>ID</th><th>NOM Prod</th><th>DESCRIPTION</th><th>PHOTO</th>
<th></th><th></th>
</tr>
<c:forEach items="${produits}" var="cat">
<tr>
<td>${cat.idProduit}</td>
<td>${cat.nomProduit}</td>
<td>${cat.description}</td>
<td><img src="photoProd?idProd=${cat.idProduit}"></td>
<td><a href="suppProd?idProd=${cat.idProduit}">Supprimer</a></td>
<td><a href="editProd?idProdt=${cat.idProduit}">Edit</a></td>
</tr>
</c:forEach>
</table>
</div>


