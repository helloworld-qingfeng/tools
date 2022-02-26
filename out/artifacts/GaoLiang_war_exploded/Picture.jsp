<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en-US">
<head>
    <meta charset="UTF-8">
    <title>芜湖图新CAD图展示板</title>
    <style type="text/css">
        #box{ width:200px; height:200px; border:1px solid #ddd; }
    </style>
</head>
<body>
<a href="${pageContext.request.contextPath}/Picture.jsp">重置</a>
<div style="width:25%;height:5%;margin: auto">

    <div><input type="text" id="testInput" placeholder="批量复制图片粘贴此处" size="20" style="width: 100%;height: 100%" /></div>

</div>

<script type="text/javascript">
    (function(){
        var imgReader = function( item ){
            var blob = item.getAsFile(),
                reader = new FileReader();

            reader.onload = function( e ){
                var img = new Image();

                img.src = e.target.result;
                document.body.appendChild( img );
            };

            reader.readAsDataURL( blob );
        };

        document.getElementById( 'testInput' ).addEventListener( 'paste', function( e ){
            var clipboardData = e.clipboardData,
                i = 0,
                items, item, types;

            if( clipboardData ){
                items = clipboardData.items;

                if( !items ){
                    return;
                }

                item = items[0];
                types = clipboardData.types || [];

                for( ; i < types.length; i++ ){
                    if( types[i] === 'Files' ){
                        item = items[i];
                        break;
                    }
                }

                if( item && item.kind === 'file' && item.type.match(/^image\//i) ){
                    imgReader( item );
                }
            }
        });
    })();
</script>

</body>
</html>