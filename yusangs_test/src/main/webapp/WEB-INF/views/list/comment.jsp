<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="container">
		    <br><br>
	        <div>
	            <div>
	                <span><strong>Comments</strong></span> <span id="cCnt"></span>
	            </div>
	            <div>
	                <table class="table">                    
	                    <tr>
	                        <td>
	                        	댓글 아이디 : <input type="text" id="reply_id"/>
	                            <textarea style="width: 1100px" rows="3" cols="30" id="comment" name="comment" placeholder="댓글을 입력하세요"></textarea>
	                            <br>
	                            <div>
	                                <a href='#' onClick="repleOn(0, 1)" class="btn pull-right btn-success">등록</a>
	                            </div>
	                        </td>
	                    </tr>
	                </table>
	            </div>
	        </div>
		</div>
		<div class="container">
	        <div id="commentList">
	        </div>
		</div>
	</body>
	<script type="text/javascript">
		$(document).ready(function(){
			getRepleList();
		});
		
		function getRepleList(){
			var data = {};
			data.list_idx = "${sangse.IDX }";
			
			$.ajax({
				url: "<c:url value='getRepleList.do'/>",
				type: "get",
				dataType: "json",
				data: data,
				success: function(data){
					var html = "";
		            var cCnt = data.length;

		            if(data.length > 0){
		                for(i=0; i<data.length; i++){
		                    html += "<div><div>";
 							if(data[i].DEPTH != 1){
 								html += ">>>>";
					        }
		                    html += "<table class='table'><h6><strong>"+data[i].USERID+"</strong></h6>";
		                    html += data[i].REPLY + "<tr><td></td></tr>";
		                    html += "</table></div>";
		                    if(data[i].DEPTH == 1){
		                    	html += "<button name='reply_reply' value='"+data[i].IDX+"'>답글달기</button>";
					        }
		                    html += "</div>";
		                }
		            } else {
		                html += "<div>";
		                html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
		                html += "</table></div>";
		                html += "</div>";
		            }

		            $("#comment").val("");
					$("#reply_id").val("");
		            
		            $("#cCnt").html(cCnt);
		            $("#commentList").html(html);
				},
				error: function (request, status, error){
					console.log(error);
				}
			});
		}

		function repleOn(parent_idx, depth){
			var data = {};
			data.list_idx = "${sangse.IDX }";
			data.parent_idx = parent_idx;
			data.depth = depth;

			if(depth == 1){
				data.reply = $("#comment").val();
				data.reply_id = $("#reply_id").val();
			}else{
				data.reply = $("#comment_reply").val();
				data.reply_id = $("#comment_reply_id").val();
			}
			
			$.ajax({
				url: "<c:url value='repleOn.do'/>",
				type: "post",
				data: data,
				success: function(data){
					console.log(data);
					getRepleList();
				},
				error: function (request, status, error){
					console.log(error);
				}
			});
		}

		//대댓글 창 활성화
		$(document).on("click", "button[name='reply_reply']", function(){
			var html = "";
			console.log();
			
			html += "<div class='reply_reply_form'>";
			html += "댓글 아이디 : <input type='text' id='comment_reply_id'/>";
			html += "<textarea style='width: 1100px' rows='3' cols='30' id='comment_reply' name='comment' placeholder='댓글을 입력하세요'></textarea>";
			html += "<br>";
			html += "<div><a href='#' onClick='repleOn("+$(this).val()+", 2)' class='btn pull-right btn-success'>등록</a></div>";
			html += "</div>"
			
			$(this).parent("div").append(html);
			$(this).html("답글취소");
			$(this).attr({
				"name":"reply_reply_del"
			});
		});

		//대댓글 창 비활성화
		$(document).on("click", "button[name='reply_reply_del']", function(){
			$(this).parent("div").children(".reply_reply_form").remove();
			$(this).html("답글달기");
			$(this).attr({
				"name":"reply_reply"
			});
		});
	</script>
</html>