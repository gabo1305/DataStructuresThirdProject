<html>

<title>Buy Ticket</title>

<script>

    const url='http://localhost:9080/cual';
    const url2='http://localhost:9080/getPrice';
    const Http= new XMLHttpRequest();
    const Http2= new XMLHttpRequest();
    const HttpMethod="GET";
    var text;
    var textPrice="";
    var Inicio="?Start="
    var Final="&End="
    var cantidad='&Amount='
    function getText() {
        Http.open(HttpMethod, url);
        Http.send();
        Http.onreadystatechange = (e) => {
            //console.log(Http.responseText)
            text = Http.responseText;
            estaciones()
        };
    }

    function all() {
        getText()

    }

    function getPrice() {
        var e =document.getElementById("dropdownEstacionInicial");
        var f =document.getElementById("dropdownEstacionFinal");
        var g=document.getElementById("AmountId");
        var get=url2+Inicio+e.options[e.selectedIndex].value+Final+f.options[f.selectedIndex].value+cantidad+g.value;

        document.getElementById("AmountId").disabled=true;
        document.getElementById("buyID").disabled=true;

        Http2.open(HttpMethod,get)
        Http2.send();
        console.log(get)
        Http2.onreadystatechange = (e) =>{
            document.getElementById("AmountId").disabled=false;
            document.getElementById("buyID").disabled=false;
            textPrice = Http2.responseText;
            document.getElementById("textprueba").innerText=textPrice;
            console.log(textPrice);
        };
    }


        function estaciones() {
        obj = JSON.parse(text);
        var estacionOption = "<option value=''>select</option>"


        for (var i = 0; i<obj.nodes.length;i++){
            estacionOption += "<option value='"+obj.nodes[i].id+"'>"+obj.nodes[i].label+"</option>"
        }
        document.getElementById('dropdownEstacionInicial').innerHTML = estacionOption;



    }
    function paradasDisponibles() {
        obj = JSON.parse(text);
        var estacionId = document.getElementById("dropdownEstacionInicial");
        var paradasOption = "<option name=''> select</option>"

        for (var i=0; i<obj.edges.length; i++){
            if (obj.edges[i].source === estacionId.value){
                paradasOption += "<option value='"+obj.nodes[obj.edges[i].target].id+"'>"+obj.nodes[obj.edges[i].target].label+"</option>"
            }
        }
        document.getElementById('dropdownEstacionFinal').innerHTML = paradasOption;
    }


</script>

<body onload="all()">

<h1>Buy Ticket</h1>

<h2>Add your route to shopping cart </h2>

<form  action="/buy">
    Enter username<br>
    <input type="text" name="UserName">
    <br>

    Select a starting point <br>
    <select id = "dropdownEstacionInicial"  onchange="paradasDisponibles()" name="Start" required>
    </select><br><br>


    Select a finishing point <br>


    <select id = "dropdownEstacionFinal"  name="End" required>

    </select><br><br>

    select how many tickets you want <br>
    <input type="number"  id="AmountId" name="Amount" required
    min="1" max="100">
    <br>

    select the date of use of your ticket<br>

    <input type="date" id="fecha" required
    min="2020-08-13" max="2021-01-01">
    <br>


    <input type="submit" id="buyID" value="buy"><br>
    <br>

    This is the cost of your purchase<br>

    <label id="textprueba" > </label>

    <br>


</form>

<button type="button" id="GetID"  onclick="getPrice()">Get Price</button>

</body>

</html>
