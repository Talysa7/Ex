<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>Drag and Drop</h2>
<style type="text/css">
	div {
		width:200px;
		height:300px;
		margin:20px;
		float:left;
	}
	#blue {
		border:1px solid blue;
	}
	#red {
		border:1px solid red;
	}
	#green {
		border:1px solid green;
	}
</style>
<div id="blue" ondrop="drop(this, event)" ondragenter="return false" ondragover="return false"></div>
<div id="red" ondrop="drop(this, event)" ondragenter="return false" ondragover="return false"></div>
<div id="green" ondrop="drop(this, event)" ondragenter="return false" ondragover="return false">
	<img id="target" src="/HtmlEx/data/cat1.jpg" width="200" height="300" draggable="true" ondragstart="drag(this, event)">
	<a id="daum" draggable="true" ondragstart="drag(this, event)">다음</a>
</div>
<script type="text/javascript">
	function drag(target, event) {
		event.dataTransfer.setData("id", target.id);
	}
	function drop(element, event) {
		var targetelement=document.getElementById(event.dataTransfer.getData("id"));
		element.appendChild(targetelement);
		event.preventDefault();
	}
</script>