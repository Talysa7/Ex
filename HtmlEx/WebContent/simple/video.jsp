<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="http://vjs.zencdn.net/4.9/video.js"></script>
		<link href="http://vjs.zencdn.net/4.9/video-js.css"
			rel="stylesheet" type="text/css">
	</head>
	<body>
		<video controls="controls" class="video-js vjs-default-skin" data-setup="{}">
			<source src="/HtmlEx/data/Wildlife.mp4" type="video/mp4"/>
			<track src="/HtmlEx/data/track.srt" kind="subtitles" srclang="ko" label="Korean"/>
		</video>
	</body>
</html>