<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Strong Web Form</title>
	</head>
	<body>
		<form>
			<table border="1">
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" autofocus></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="text" name="age" placeholder="숫자만 입력하세요"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="datetime-local" name="logtime"></td>
				</tr>
				<tr>
					<th>일자</th>
					<td><input type="date" name="today"></td>
				</tr>
				<tr>
					<th>시각</th>
					<td><input type="time" name="now"></td>
				</tr>
				<tr>
					<th>월</th>
					<td><input type="month" name="month"></td>
				</tr>
				<tr>
					<th>주</th>
					<td><input type="week" name="week"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<th>홈페이지</th>
					<td><input type="url" name="url"></td>
				</tr>
				<tr>
					<th>색상</th>
					<td><input type="color" name="color"></td>
				</tr>
				<tr>
					<th>검색</th>
					<td><input type="search" name="keyword"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="tel" name="tel"></td>
				</tr>
				<tr>
					<th>몸무게</th>
					<td><input type="number" name="ton"></td>
				</tr>
				<tr>
					<th>키</th>
					<td>100<input type="range" name="tall" min="100" max="180" step="5">180</td>
				</tr>
				<tr>
					<th>파일</th>
					<td><input type="file" name="file" accept="image/*"></td>
				</tr>
				<tr>
					<th>
						<input type="submit" name="확인">
						<input type="reset" name="취소">
					</th>
				</tr>
			</table>
		</form>
	</body>
</html>