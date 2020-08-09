<html>

<title>Admin</title>
<script src="noBack.js"></script>

<script>
    const url='http://localhost:9080/cual';
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
        var estacionOption = "<option name=''> select</option>"

        for (var i = 0; i<obj.nodes.length;i++){
            estacionOption += "<option value='"+obj.nodes[i].id+"'>"+obj.nodes[i].label+"</option>"
        }
        document.getElementById('dropdownEstacionInicial').innerHTML = estacionOption;
        document.getElementById('dropdownEstacionFinal').innerHTML = estacionOption;
        document.getElementById('dropdownEstaciones').innerHTML = estacionOption;
    }
    
    function paradasDisponibles() {
        obj = JSON.parse(text);
        var estacionId = document.getElementById("dropdownEstaciones");
        var paradasOption = "<option name=''> select</option>"

        for (var i=0; i<obj.edges.length; i++){
            if (obj.edges[i].source === estacionId.value){
                paradasOption += "<option value='"+obj.nodes[obj.edges[i].target].id+"'>"+obj.nodes[obj.edges[i].target].label+"</option>"
            }
        }
        document.getElementById('dropdownParadas').innerHTML = paradasOption;

    }
</script>

<body onload="all()">

<h1>Admin Page</h1>

<h2>Agregar ruta</h2>

<form  action="/newRoute">
    Select a starting point <br>
    <select id = "dropdownEstacionInicial" name="Initial" required>
    </select><br><br>


    Select a finishing point <br>
    <select id = "dropdownEstacionFinal" name="Final" required>
    </select><br><br>

    Select the distance between the two points <br>
    <input type="number" name="Distance" required><br>
    <br>
    <input type="submit" value="Agregar ruta">
</form>

<br><br>


<h2>Eliminar ruta</h2>

<form>
    <h4>Estacion</h4>
    <select id="dropdownEstaciones" onchange="paradasDisponibles()" name="Estaciones" required>
    </select>

    <h4>Paradas</h4>
    <select id="dropdownParadas" name="Paradas" required>
    </select><br><br>

    <input type="submit" value="Eliminar ruta">
</form>

<br><br>

<h2>Reservaciones</h2>


</body>

</html>