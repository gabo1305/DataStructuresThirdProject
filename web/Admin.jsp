<html>

<title>Admin</title>

<head>
    <link rel="stylesheet" href="tableStyle.css">
</head>

<script src="noBack.js"></script>

<script>
    const url='http://localhost:9080/cual';
    const url2='http://localhost:9080/addStopping';
    const url3='http://localhost:9080/deleteNode';
    const url4='http://localhost:9080/newRoute';
    const url5='http://localhost:9080/deleteRoute';
    const Http= new XMLHttpRequest();
    const Http2= new XMLHttpRequest();
    const Http3 = new XMLHttpRequest();
    var Http4 = new XMLHttpRequest();
    var Http5 = new XMLHttpRequest();
    var Http6 = new XMLHttpRequest();
    var Http7 = new XMLHttpRequest();
    const HttpMethod="GET";
    var yaEsta = false;
    var text;
    var usersText;
    var ticketFechaText;

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
        yaEsta=false;
        getText()
        getUsers()
    }

    function estaciones() {
        obj = JSON.parse(text);
        var estacionOption = "<option name=''> select</option>"
        var estacionOptionReservacion = "<option name=''> Ruta</option>"

        for (var i = 0; i<obj.nodes.length;i++){
            estacionOption += "<option value='"+obj.nodes[i].id+"'>"+obj.nodes[i].label+"</option>"
            estacionOptionReservacion += "<option value='"+obj.nodes[i].id+"'>"+obj.nodes[i].label+"</option>"
        }
        document.getElementById('dropdownEstacionInicial').innerHTML = estacionOption;
        document.getElementById('dropdownEstacionFinal').innerHTML = estacionOption;
        document.getElementById('dropdownEstaciones').innerHTML = estacionOption;
        document.getElementById('dropdownEstacionEliminar').innerHTML = estacionOption;
        document.getElementById('dropdownReservaciones').innerHTML = estacionOptionReservacion;
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
                tableRow += "<tr><td><a href='UserTicketUsuario.jsp?UserName="+obj[i].ID+"'>"+obj[i].ID+"<a></td><td>"+obj[i].wallet.tickets.length+"</td></tr>";
            }
            document.getElementById('userTable').innerHTML = tableRow;
        }
    }

    function porRuta() {
        var e = document.getElementById("dropdownReservaciones");
        var strUser = e.options[e.selectedIndex].value;
        console.log("Esto es el dropdown: " +strUser)
        window.location.href="http://localhost:9080/UserTicketRuta.jsp?Node="+strUser;
    }

    function getTicketFecha() {
        var fecha = document.getElementById("fecha")
        console.log("esto es fecha: "+fecha.value)
        Http3.open("GET",'http://localhost:9080/consultDate?Date='+fecha.value)
        Http3.send();
        Http3.onreadystatechange=(e)=>{
            console.log("entro a onreadystage")
            ticketFechaText = Http3.responseText;
            console.log("Esto es ticket fecha: " + ticketFechaText)
            obtenerFecha()
        }
    }

    function obtenerFecha() {
        obj = JSON.parse(ticketFechaText);
        var tableRow = "<tr><th>Usuario</th><th>Trayectroia</th><th>Ticket Id</th><th>Precio</th></tr>"
        for (var i=0; i<obj.length; i++){
            tableRow += "<tr><td>"+obj[i].UserID+"</td><td>"+obj[i].trajectory+"</td><td>"+obj[i].ID+"</td><td>"+obj[i].price+"</td></tr>";
        }
        document.getElementById('userTable').innerHTML = tableRow;
    }

    function agregarEstacion() {
        var StopName = document.getElementById("StopName").value
        var XPos = document.getElementById("XPos").value
        var YPos = document.getElementById("YPos").value
        var get = url2+"?StopName="+StopName+"&XAxis="+XPos+"&YAxis="+YPos;
        Http4.open(HttpMethod, get)
        Http4.send()
        console.log("get:" + get)
        Http4.onreadystatechange = (e) => {
            if(Http4.readyState === XMLHttpRequest.DONE) {
                console.log("Http4 response text: " + Http4.responseText)
                alert(Http4.responseText)
            }
        }
    }

    function eliminarEstacion() {
        var NodeId = document.getElementById("dropdownEstacionEliminar").value
        var get = url3+"?NodeID="+NodeId;
        Http5.open(HttpMethod, get)
        Http5.send()
        console.log("get:" + get)
        Http5.onreadystatechange = (e) => {
            if(Http5.readyState === XMLHttpRequest.DONE) {
                console.log("Http5 response text: " + Http5.responseText)
                alert(Http5.responseText)
            }
        }
    }

    function agregarRuta() {
        var Initial = document.getElementById("dropdownEstacionInicial").value
        var Final = document.getElementById("dropdownEstacionFinal").value
        var Distance = document.getElementById("distance").value
        var get = url4+"?Initial="+Initial+"&Final="+Final+"&Distance="+Distance;
        Http6.open(HttpMethod, get)
        Http6.send()
        console.log("get:" + get)
        Http6.onreadystatechange = (e) => {
            if(Http6.readyState === XMLHttpRequest.DONE) {
                console.log("Http6 response text: " + Http6.responseText)
                alert(Http6.responseText)
            }
        }
    }

    function eliminarRuta() {
        var Initial = document.getElementById("dropdownEstaciones").value
        var Final = document.getElementById("dropdownParadas").value
        var get = url5+"?Estaciones="+Initial+"&Paradas="+Final;
        Http7.open(HttpMethod, get)
        Http7.send()
        console.log("get:" + get)
        Http7.onreadystatechange = (e) => {
            if(Http7.readyState === XMLHttpRequest.DONE) {
                console.log("Http7 response text: " + Http7.responseText)
                alert(Http7.responseText)
            }
        }
    }




</script>

<body onload="all()">

<h1>Admin Page</h1>


<h2>Agregar estacion</h2>

    Nombre de nueva estacion<br>
    <input type="text" id="StopName" name="StopName"><br><br>

    Posicion en X de estacion<br>
    <input type="number" id="XPos" name="XAxis"><br><br>

    Posicion en Y de estacion<br>
    <input type="number" id="YPos" name="YAxis"><br><br>

    <input type="submit" onclick="agregarEstacion()" value="Add new station">

<br><br>



<h2>Eliminar estacion</h2>
    Estacion que desea eliminar<br>
    <select id="dropdownEstacionEliminar" name="NodeID" required>
    </select><br><br>

    <input type="submit" onclick="eliminarEstacion()" value="Eliminar estacion">



<br><br>



<h2>Agregar ruta</h2>


    Select a starting point <br>
    <select id = "dropdownEstacionInicial" name="Initial" required>
    </select><br><br>


    Select a finishing point <br>
    <select id = "dropdownEstacionFinal" name="Final" required>
    </select><br><br>

    Select the distance between the two points <br>
    <input type="number" id="distance" name="Distance" required><br>
    <br>
    <input type="submit" onclick="agregarRuta()" value="Agregar ruta">


<br><br>


<h2>Eliminar ruta</h2>


    <h4>Estacion</h4>
    <select id="dropdownEstaciones" onchange="paradasDisponibles()" name="Estaciones" required>
    </select>

    <h4>Paradas</h4>
    <select id="dropdownParadas" name="Paradas" required>
    </select><br><br>


    <input type="submit" onclick="eliminarRuta()" value="Eliminar ruta">


<br><br>

<h2>Reservaciones</h2>

<form>
    <h4>Forma de visualizar reservaciones</h4>
    <input type="button" onclick="reservaciones('Usuario')" value="Usuarios">
    <input type="date" id="fecha" onchange="getTicketFecha()" name="Date" required min="2020-08-13" max="2021-01-01">

    <select id="dropdownReservaciones" onchange="porRuta()" name="Tickets">
    </select>
</form>


<table id="userTable">
</table>



</body>

</html>