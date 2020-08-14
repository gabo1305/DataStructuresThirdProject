<html>

<title>Buy Ticket</title>

<script>

    const url='http://localhost:9080/Update';
    const url2='http://localhost:9080/getPrice';
    const url3='http://localhost:9080/buy'
    const Http= new XMLHttpRequest();
    const Http2= new XMLHttpRequest();
    var Http3 = new XMLHttpRequest();
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

    var usuario;
    function all() {
        getText()
        usuario=sessionStorage.getItem('UserBuy')
        console.log("usuario")
        document.getElementById("SavedUser").value=usuario;

    }

    function getPrice() {
        var inicial =document.getElementById("dropdownEstacionInicial");
        var final =document.getElementById("dropdownEstacionFinal");
        var cantidadtickets=document.getElementById("AmountId");


        var get=url2+Inicio+inicial.options[inicial.selectedIndex].value+Final+final.options[final.selectedIndex].value+cantidad+cantidadtickets.value;
        console.log("f"+cantidadtickets.value+"f")
        if (cantidadtickets.value==""){
            alert("please enter a number of tickets");
            return
        }
        else{

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


    }



        function estaciones() {
        obj = JSON.parse(text);
        var estacionOption = "<option value=''>select</option>"


        for (var i = 0; i<obj.nodes.length;i++){
            estacionOption += "<option value='"+obj.nodes[i].id+"'>"+obj.nodes[i].label+"</option>"
        }
        document.getElementById('dropdownEstacionInicial').innerHTML = estacionOption;
        document.getElementById('dropdownEstacionFinal').innerHTML = estacionOption;
    }

    function compra() {
        var UserName = document.getElementById("SavedUser").value
        var Start = document.getElementById("dropdownEstacionInicial").value
        var End = document.getElementById("dropdownEstacionFinal").value
        var Amount = document.getElementById("AmountId").value
        var Date = document.getElementById("date").value
        var get = url3 + "?UserName=" + UserName + "&Start=" + Start + "&End=" + End + "&Amount=" + Amount + "&Date=" + Date;

        Http3.open(HttpMethod, get)
        Http3.send()
        console.log("get:" + get)
        Http3.onreadystatechange = (e) => {
            if(Http3.readyState === XMLHttpRequest.DONE) {
                console.log("Http3 response text: " + Http3.responseText)
                alert("purchase completed"+ Http3.responseText)
            }


        }

    }



</script>


<body onload="all()">

<h1>Buy Ticket</h1>

<h2>Add your route to shopping cart </h2>



    ID Card <br>
    <input type="text" name="UserName" id="SavedUser" disabled>
    <br>



    Select a starting point <br>
    <select id = "dropdownEstacionInicial" name="Start" required>
    </select><br><br>


    Select a finishing point <br>


    <select id = "dropdownEstacionFinal"  name="End" required >

    </select><br><br>

    select how many tickets you want <br>
    <input type="number"  id="AmountId" name="Amount" value="1" required
    min="1" max="100" >
    <br>

    select the date of use of your ticket<br>

    <input type="date" name="Date"  id="date"
    min="2020-08-13" max="2021-01-01" required>
    <br>


    <input type="submit" id="buyID" onclick="compra()" value="buy"><br>
    <br>

    This is the cost of your purchase<br>

    <label id="textprueba" > </label>

    <br>


    <button type="button" id="GetID"  onclick="getPrice()">Get Price</button>

</body>

</html>
