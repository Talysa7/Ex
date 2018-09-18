<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<h2> Canvas Element </h2>

<style type="text/css">
	canvas {
		border : 2px solid blue;
		width : 400px;
		height : 300px;		
	}
</style>

<canvas id="cvs"></canvas>

<script type="text/javascript">
	//<!--
	var cvs = document.getElementById( 'cvs' );
	var ctx = cvs.getContext( '2d' );
	
	// 사각형
	ctx.fillStyle = 'yellow';
	ctx.fillRect( 10, 10, 50, 50 );
	ctx.strokeRect( 70, 10, 50, 50 );
	ctx.clearRect( 40, 40, 50, 50 );
	
	// 선긋기
	ctx.lineWidth = "5";
	ctx.lineCap = "round";
	ctx.beginPath();
	ctx.lineTo( 10, 50 );
	ctx.lineTo( 200, 50 );
	ctx.lineTo( 95, 100 );
	ctx.lineTo( 10, 50 );
	ctx.stroke();
	
	ctx.moveTo( 200, 70 );
	ctx.lineTo( 200, 150 );
	ctx.stroke();	
	ctx.closePath();
	
	// 글자 넣기
	ctx.fillStyle="red";
	ctx.font="15px Gothic";
	ctx.textAlign="left";
	ctx.fillText("Hello", 250, 20);
	ctx.textAlign="right";
	ctx.fillText("Hello", 250, 40);
	ctx.textAlign="center";
	ctx.fillText("Hello", 250, 60);
	ctx.textAlign="start";
	ctx.fillText("Hello", 250, 80);
	ctx.textAlign="end";
	ctx.fillText("Hello", 250, 100);
	
	
	//-->
</script>