<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅창구현</title>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<input type="text" id="msg"/>
	<input type="button" id="btn" value="전송"/>
	<input type="file" id="file" name="upfile"/>
	<input type="button" id="filebtn" value="file전송"/>
	<div id="container"></div>
	
	
	<script>
		var socket;
		var nickname = prompt("대화명을 입력하세요!");
		$(function(){
			
			$("#filebtn").click(function() {
				var file = $("#file")[0].files[0];
				console.log(file);
				socket.binaryType = "arraybuffer";//파일을 버퍼 형식으로 바꿔줘야 한다.
				var reader = new FileReader();
				
				reader.onload = function(e) {
					var msg = {"nickname":nickname,"msg":file.name,"flag":"file"};
					socket.send(JSON.stringify(msg));
					
					/* console.log(e); */
					socket.send(e.target.result);
				}
				
				
				reader.readAsArrayBuffer(file);
			})
			
			socket = new WebSocket("ws:192.168.20.17:9090/spring/chatting")
			/*
				웹소켓 객체 안의 메소드를 구현하면 됨
				 onopen, onmessage, onclose, onerror 속성~
				 구현함수를 해당 속성에 대입하면 됨!
				 소켓 메세지를 서버로 전송할때 사용하는
				 send()가 있음
			*/
			
			
			//소켓세션이 연결되면 실행되는 함수
			socket.onopen = function(e) {
				console.log(e);
			}
			
			socket.onmessage = function(e) {
				console.log(e);
				var msg = JSON.parse(e.data);
				$("#container").append("<p>"+msg["nickname"]+":"+msg["msg"]+"</p>");
				
				/* 
				var premsg = $("#container").text();
				$("#container").text(premsg+"<p>"+msg["nickname"]+":"+msg["msg"]+"</p>");
				 */
			}
			
			socket.onclose = function(e) {
				console.log(e);
			}
			
			$('#btn').click(function() {
				var msg = {"nickname":nickname,"msg":$("#msg").val(),"whisper":"귓속말아이디명"};
				socket.send(JSON.stringify(msg));
				$("#msg").val("");
			})
		})

	</script>
</body>
</html>