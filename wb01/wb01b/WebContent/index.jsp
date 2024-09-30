<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    
        <style>
            @charset "UTF-8";
    
            * {
                margin: 0;
                padding: 0;
            }
    
            .header {
                display: block;
                background-color: blue;
                color: white;
                text-align: center;
                height: 60px;
                font-size: 40px;
                padding: 0px;
                top: 0;
                height: 150px;
                font-weight: 1000;
                display: flex;
                align-items: center;
                justify-content: center;
            }
    
            footer {
                background-color: skyblue;
                color: white;
                height: 80px;
                line-height: 80px;
                text-align: center;
    
                position: absolute;
                bottom: 0;
                width: 100%;
            }
        </style>
    
        <!-- navbar스타일 -->
        <style>
            .nav {
                background-color: plum;
                color: white;
                height: 60px;
    
                line-height: 58px;
            }
    
            .nav li {
                width: 100px;
                height: 40px;
            }
    
            .nav ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
            }
    
            .nav li {
                display: inline;
                margin: 0 5px;
            }
    
            .nav li a {
                text-decoration: none;
                color: white;
            }
    
            .nav li a:hover {
                color: aqua;
            }
        </style>
    
    </head>
    <div class="header">
        쇼핑몰 회원관리 ver1.0
    </div>
    <div class="nav">
        <ul>
            <li><a class="active" href="#">회원등록</a></li>
            <li><a href="#">회원목록조회/수정</a></li>
            <li><a href="#">회원매출조회</a></li>
            <li><a href="#">홈으로</a></li>
        </ul>
    </div>
    <main>
        <section>
            <div class="title">
                쇼핑몰회원관리 프로그램
            </div>
            쇼핑몰 회원정보와 회원매출정보 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다.<br>
            프로그램 작성 순서
            <ul>
                <li>회원정보 테이블을 생성한다.</li>
                <li>회원정보, 매출정보 테이블에 제시된 문제지의 참조데이터를 추가 생성한다.</li>
                <li>회원정보 입력 하면프로그램을 작성한다.</li>
                <li>회원정보 조회 프로그램을 작성한다.</li>
                <li>회원매출정보 조회 프로그램을 작성한다.</li>
            </ul>
        </section>
    </main>
    <footer>
        HRDKOREA Copyrightⓒ2016 All rights reserved. Human Resources Develpment Service of Korea
    </footer>
    </body>
    
    </html>