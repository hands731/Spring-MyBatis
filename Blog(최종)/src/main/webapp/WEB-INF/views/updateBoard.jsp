<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<meta charset="UTF-8">
<title>글 작성</title>
<script type="text/javascript">

function updateValidation(){
	
	var docId = ${detail.id};
	var subject = $("#subject").val();
	var content = $("#content").val();
	updateDocument(subject,content,docId);
}

function updateDocument(subject, content,docId){
	$.ajax({
		
		url : "/Blog/jquery/updateDocument",
		type : 'POST',
		data : {  
				subject : subject,
				context : content,
				id : docId
		},
		
		success:function(){
			location.href='detailDocument?id='+docId;
		}
		
	})
	
}

</script>
<% 
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
%>
</head>
<body>
<form>
<table>
        <caption>게시판 수정하기 </caption>
    <tbody>
            <tr>
                <th>제목: </th>
                <td><input type="text"  id="subject" value=${detail.subject} /></td>
            </tr>
            <tr>
                <th>내용: </th>
                <td><textarea cols="30" rows="10"  id="content">${detail.context}</textarea></td>
            </tr>
           <!--  <tr>
                <th>첨부파일: </th>
                <td><input type="text" placeholder="파일을 선택하세요. " name="filename"/></td>
            </tr> -->
            <tr>
                <td colspan="2">
                    <input type="button" value="수정" onclick="updateValidation()"/>
                    <input type="button" value="뒤로" onclick="javascript:location.href='detailDocument?id='+${detail.id}"/>
                </td>
            </tr>
    </tbody>
</table>
</form>
</body>
</html>