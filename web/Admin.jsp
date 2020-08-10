<html>

<title>Admin</title>

<head>
    <link rel="stylesheet" href="tableStyle.css">
</head>

<script src="noBack.js"></script>

<script>
    const url='http://localhost:9080/cual';
    const Http= new XMLHttpRequest();
    const Http2= new XMLHttpRequest();
    const HttpMethod="GET";
    var text;
    var usersText;

    function getText() {
        Http.open(HttpMethod, url);
        Http.send();
        Http.onreadystatechange = (e) => {
            text = Http.responseText;
            estaciones()
        };
    }

    function getUsers() {
        Http2.open("GET",'http://localhost:9080/usersXd')
        Http2.send();
        Http2.onreadystatechange = (e) =>{
            usersText = Http2.responseText;
        }
    }



    function all() {
        getText()
        getUsers()
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

    function reservaciones(tipoDeReservacion) {
        if (tipoDeReservacion==='Usuario'){
            obj = JSON.parse(usersText);
            var tableRow = "<tr><th>Usuario</th><th>Cantidad de tiquetes</th></tr>"

            for (var i=0; i<obj.length; i++){
                tableRow += "<tr><td><a href='userTicket?UserName="+obj[i].ID+"'>"+obj[i].ID+"<a></td><td>"+obj[i].wallet.tickets.length+"</td></tr>";
            }
            document.getElementById('userTable').innerHTML += tableRow;
        }
        if (tipoDeReservacion==='Ruta'){

        }
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

<form action="/deleteRoute">
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

<form>
    <h4>Forma de visualizar reservaciones</h4>
    <input type="button" onclick="reservaciones('Usuario')" value="Usuarios">
    <input type="button" onclick="reservaciones('Fecha')" value="Fecha">
    <input type="button" onclick="reservaciones('Ruta')" value="Ruta">
</form>


<table id="userTable">
</table>



</body>

</html>