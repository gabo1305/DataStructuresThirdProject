<html>

<title>Buy Ticket</title>

<script>

    const url='http://localhost:9080/cual';
    const url='http://localhost:9080/getPrice';
    const Http= new XMLHttpRequest();
    const HttpMethod="GET";
    var text;

    function getText() {
        Http.open(HttpMethod, url);
        Http.send();
        Http.onreadystatechange = (e) => {
            console.log(Http.responseText)
            text = Http.responseText;
            estaciones()
        };
    }

    function all() {
        getText()
    }

    function estaciones() {
        obj = JSON.parse(text);
        var estacionOption = "<option value=''>select</option>"


        for (var i = 0; i<obj.nodes.length;i++){
            estacionOption += "<option value='"+obj.nodes[i].label+"'>"+obj.nodes[i].label+"</option>"
        }
        document.getElementById('dropdownEstacionInicial').innerHTML = estacionOption;
        document.getElementById('dropdownEstacionFinal').innerHTML = estacionOption;


    }



</script>

<body onload="all()">

<h1>Buy Ticket</h1>

<h2>Add your route to shopping cart </h2>

<form  action="ConfirmarCompra.jsp" method="post">
    Select a starting point <br>
    <select id = "dropdownEstacionInicial" name="Initial" required>
    </select><br><br>


    Select a finishing point <br>
    <select id = "dropdownEstacionFinal" name="Final" required>
    </select><br><br>

    <input type="number" name="Amount" required>

    <input type="submit" value="go to shopping cart">

</form>

<form>


</form>
   <input type="submit" value="Consult price ">
<form >
    <input type="submit" value="Add to shopping cart ">
</form>

<br><br>


