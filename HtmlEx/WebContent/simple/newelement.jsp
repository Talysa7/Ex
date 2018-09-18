<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h2>new element</h2>
<form oninput="result.value=parseInt(a.value)+parseInt(b.value)">
	<input type="text" name="a" value="0">
	+<input type="text" name="b" value="0">
	=<output name="result"></output>
</form>
<br>
0<progress max="10" value="5"></progress>10
<br>
0<meter min="0" max="10" low="4"  high="7" value="6"></meter>10
<div>
<div contenteditable="true">편집 가능</div>
<div contenteditable="false">편집 불가능</div>
</div>