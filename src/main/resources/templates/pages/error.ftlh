<#import "/spring.ftl" as spring />


<html>
<head>
    <title>Army</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
    <link rel="stylesheet" href="/css/error.css"/>
</head>
<body>

<hr id="error">
<div class="container">
    <div class="copy-container center-xy">
        <p>
            <#--${errorMessage!""}-->
            <#if errorMessage??>
                <@spring.message errorMessage/>
            </#if>
        </p>
        <a style="color: white;" href="/admin/home">Home</a>
        <span class="handle"></span>
    </div>
</div>

<a id="cb-replay" href="/">
    <svg version="1.1" xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" viewBox="0 0 279.9 297.3" xml:space="preserve">
        <g>
            <path d="M269.4,162.6c-2.7,66.5-55.6,120.1-121.8,123.9c-77,4.4-141.3-60-136.8-136.9C14.7,81.7,71,27.8,140,27.8
      c1.8,0,3.5,0,5.3,0.1c0.3,0,0.5,0.2,0.5,0.5v15c0,1.5,1.6,2.4,2.9,1.7l35.9-20.7c1.3-0.7,1.3-2.6,0-3.3L148.6,0.3
      c-1.3-0.7-2.9,0.2-2.9,1.7v15c0,0.3-0.2,0.5-0.5,0.5c-1.7-0.1-3.5-0.1-5.2-0.1C63.3,17.3,1,78.9,0,155.4
      C-1,233.8,63.4,298.3,141.9,297.3c74.6-1,135.1-60.2,138-134.3c0.1-3-2.3-5.4-5.3-5.4l0,0C271.8,157.6,269.5,159.8,269.4,162.6z"/>
        </g>
    </svg>
</a>
</body>
</html>