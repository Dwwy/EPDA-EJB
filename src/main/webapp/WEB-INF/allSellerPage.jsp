<%@ page import="com.example.demo1.Util.StaticVariable" %>
<%@ page import="com.example.demo1.Model.Output.SellerProfile" %>
<html>
<head>
    <title>All Seller</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
    <div id="sellers">

    </div>
</body>
<script>
    function generateURIComponent(jsonObject){
        let URIComponent = '?';
        Object.keys(jsonObject).forEach(key => {
            const value = typeof jsonObject[key] === 'object' ? JSON.stringify(jsonObject[key]) : jsonObject[key];
            const encodedValue = encodeURIComponent(value);
            URIComponent += (key+"="+encodedValue+"&");
        });
        return URIComponent.slice(0, -1);
    }
</script>
<script>
    $(document).ready(function() {
        $.ajax({
            url: "/app/seller/",
            type: "GET",
            dataType: "json",
            success: function(sellers) {
                $.each(sellers, function(index, seller) {
                    var emptyDiv = $("<div>")
                    const url = '/app/seller'+ generateURIComponent(seller)
                    emptyDiv.load(url,function(){
                        emptyDiv.replaceWith(...emptyDiv.children())
                    })
                    $('#sellers').append(emptyDiv);
                });
            },
            error: function() {
                alert("Error getting sellers.");
            }
        });
    });
</script>
</html>
