<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<body>
<h2>Hello World!</h2>
${msg}
<br>
<label>Country</label>
<select id="countrySelect" >
<option>Select</option>

<c:forEach items="${countryList}" var = "country">

<option value="${country.id}">${country.countryName}</option>

</c:forEach>
</select>

<br>
<label>Language</label>
<select id="languageSelect" >
<option>Select</option>

<%-- <c:forEach items="${countryList}" var = "country">

<option>${country.countryName}</option>

</c:forEach>
 --%>
 </select>


<p id="countryName"></p>

<p id="languageName"></p>

<hr>
<c:forEach items="${countryList}" var = "country">
<br>----------------------------<br>
${country.id} : ${country.countryName} 

<c:forEach items="${country.languageList}" var = "langList">

${langList.id} : ${langList.languageName}<br>

</c:forEach>
<%-- 
${country.languageList[0].languageName}
${country.languageList[1].languageName}
${country.languageList[2].languageName}
 --%>
</c:forEach>



</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(e){
		console.log('ready');
	});

	$(document).on('change', 'select#countrySelect', function(e){
		
		$('p#countryName').text($(this).find('option:selected').text());

		$.ajax({
			method:'post',
			url: "${pageContext.request.contextPath}/get-languages-by-country-id",
			data: 'countryId='+$(this).val(),
			success: function(resData){
				console.log(JSON.stringify(resData));
				
				var $lngOption = $('select#languageSelect');
				
				$.each(resData, function(index, val){
					$lngOption.append('<option value="'+val.id+'">'+val.languageName+'</option>');
				});
			}
		
		});
	});


$(document).on('change', 'select#languageSelect', function(e){
		
		$('p#languageName').text($(this).find('option:selected').text());

});
	
</script>



</html>
