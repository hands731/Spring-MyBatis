<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jstlHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<meta charset="UTF-8">
<title>게시판</title>
<style>
  table {
    width: 100%;
    border: 1px solid #444444;
  }
  th, td {
    border: 1px solid #444444;
  }
</style>
<script type="text/javascript">
function deleteDocument(){
	var docId=${detail.id};
	location.href="/Blog/deleteDocument?id="+docId;
}


function updateDocument(){
	var docId=${detail.id};
	location.href = "/Blog/updateBoard?id="+docId;
}

function likeValidation(){
	
	var documentId = ${detail.id};
	like(documentId);

}
function like(documentId){

	$.ajax({
			
			url : "/Blog/jquery/like",
			type : 'POST',
			data : {  
					id : documentId	
			},
			
			success:function(data){
				$('#likeTd').html(data);
			}
			
		})
}




</script>
</head>
<body>
<form>
<table id ="myTable">
        <caption>게시판 글 내용 </caption>
    <tbody>
            <tr>
                <th>제목: </th>
                <td>${detail.subject}</td>
            </tr>
            
            <tr>
                <th>내용: </th>
                <td>${detail.context}</td>
            </tr>
            
            <tr>
                <th>조회수: </th>
                <td>${detail.views}</td>
            </tr>
            <tr>
                <th>좋아요: </th>
                <td id="likeTd">${detail.likes}</td>
         	</tr>
         	
            <tr>
                <td colspan="2">
                	<input type="button" value="좋아요" onclick="likeValidation()"/>
                    <input type="button" value="수정" onclick="updateDocument()"/>
                    <input type="button" value="삭제" onclick="deleteDocument()"/>
                    <input type="button" value="목록보기" onclick="javascript:location.href='board'"/>
        

                </td>
            </tr>
    </tbody>
</table>
</form>
</body>
</html>