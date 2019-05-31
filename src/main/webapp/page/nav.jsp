<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="layui-col-md2 block-border-top">
	<ul class="layui-nav layui-nav-tree" style="width: 100%">
		<li class="layui-nav-item"><a href="javascript:;">日程</a>
			<dl class="layui-nav-child">
				<dd>
					<a class="layui-btn layui-btn-sm layui-btn-normal"
					   href="${pageContext.request.contextPath}/page/schedule/schedule.jsp">
						<i class="layui-icon layui-icon-date"></i> 日程
					</a>
				</dd>
				<dd>
					<a href="${pageContext.request.contextPath}/page/meettable.jsp">我的预订</a>
				</dd>
			</dl>
		</li>
	</ul>
</div>