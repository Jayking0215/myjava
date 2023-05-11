<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!-- HIT상품 보여주기 -->
<c:import url="/prodPspec">
	<c:param name="pspec" value="HIT"/>
</c:import>

<!-- NEW상품 보여주기 -->
<c:import url="/prodPspec">
	<c:param name="pspec" value="NEW"/>
</c:import>

<!-- BEST상품 보여주기 -->
<c:import url="/prodPspec">
	<c:param name="pspec" value="BEST"/>
</c:import>