<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2021-07-20
  Time: 오후 3:26
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/_css/mainStyle.css" type="text/css" rel="stylesheet">

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="http://davidlynch.org/projects/maphilight/jquery.maphilight.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            if(${result == "true"}){
                alert("로그아웃되었습니다.");
            }

            if(${removeResult == 0}){
                alert("계정 탈퇴가 완료되었습니다. 그동안 이용해주셔서 감사합니다.");
            }
        });

        $(function () {
            $.fn.maphilight.defaults = {
                fill: true,
                fillColor: '000000',
                fillOpacity: 0.2,
                stroke: true,
                strokeColor: '495c75',
                strokeOpacity: 1,
                strokeWidth: 1.2,
                fade: true,
                alwaysOn: false
            }
            $('.map').maphilight();
        });
    </script>

    <title>MAIN</title>
</head>
<body>
    <!--헤더-->
    <div>
        <jsp:include page="header.jsp"/>
    </div>
    <div id="main_container">

        <!--배경사진-->
        <div id="main_img--seoul">
            <img src="${pageContext.request.contextPath}/_image/main/seoul/seoul2.png" width="1600px;" height="500px;">
        </div>

        <hr style=" width:100%; color:#bac8d9; margin-top: 40px">

        <!--추천코스-->
        <div id="main_bestcourse">
            <p>BEST COURSE</p>
            <svg onclick="convertBeforeImg()" xmlns="http://www.w3.org/2000/svg" width="100" height="100" fill="#495c75"
                 style="vertical-align: top; padding-top: 80px" class="bi bi-caret-left" viewBox="0 0 16 16">
                <path d="M10 12.796V3.204L4.519 8 10 12.796zm-.659.753-5.48-4.796a1 1 0 0 1 0-1.506l5.48-4.796A1 1 0 0 1 11 3.204v9.592a1 1 0 0 1-1.659.753z"></path>
            </svg>
            <img id="img1" src="${pageContext.request.contextPath}/_image/main/testCourse/course1.png" width="300px" height="250px">
            <img id="img2" src="${pageContext.request.contextPath}/_image/main/testCourse/course2.png" width="300px" height="250px"
                 style="margin-left: 40px; margin-right: 40px;">
            <img id="img3" src="${pageContext.request.contextPath}/_image/main/testCourse/course3.png" width="300px" height="250px">
            <svg onclick="convertAfterImg()" xmlns="http://www.w3.org/2000/svg" width="100" height="100" fill="#495c75"
                 style="vertical-align: top; padding-top: 80px" class="bi bi-caret-right" viewBox="0 0 16 16">
                <path d="M6 12.796V3.204L11.481 8 6 12.796zm.659.753 5.48-4.796a1 1 0 0 0 0-1.506L6.66 2.451C6.011 1.885 5 2.345 5 3.204v9.592a1 1 0 0 0 1.659.753z"></path>
            </svg>
        </div>

        <hr style=" width:100%; color:#bac8d9; margin-top: 40px">

        <!--지도-->
        <div id="main_map--text">
            <p>SEOUL AREA</p>
        </div>
        <div id="main_map">
            <img class="map" src="${pageContext.request.contextPath}/_image/main/seoul/map-fi-c-1.png" usemap="#image-map" alt="map"/>
            <map name="image-map">
                <area target="" alt="광화문" title="광화문" href="${pageContext.request.contextPath}/areaL?sigungu=3" coords="337,150,58" shape="circle">
                <area target="" alt="홍대" title="홍대" href="${pageContext.request.contextPath}/areaL?sigungu=7" coords="350,260,52" shape="circle">
                <area target="" alt="강남" title="강남" href="${pageContext.request.contextPath}/areaL?sigungu=1" coords="510,400,51" shape="circle">
                <area target="" alt="여의도" title="여의도" href="${pageContext.request.contextPath}/areaL?sigungu=5" coords="225,300,62" shape="circle">
                <area target="" alt="잠실" title="잠실" href="${pageContext.request.contextPath}/areaL?sigungu=6" coords="615,350,52" shape="circle">
                <area target="" alt="명동" title="명동" href="${pageContext.request.contextPath}/areaL?sigungu=4" coords="460,156,420,300" shape="rect">
                <area target="" alt="강북" title="강북" href="${pageContext.request.contextPath}/areaL?sigungu=2" coords="480,77,54" shape="circle">
            </map>
        </div>

        <hr style=" width:100%; color:#bac8d9; margin-top: 40px">

        

    </div>

    <!--푸터-->
    <div>
        <jsp:include page="footer.jsp"/>
    </div>

    <script type="text/javascript" src="${pageContext.request.contextPath}/_js/mainUtil.js"></script>
</body>
</html>
